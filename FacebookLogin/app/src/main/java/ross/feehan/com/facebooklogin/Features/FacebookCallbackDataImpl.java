package ross.feehan.com.facebooklogin.Features; /*
 * Created by Ross Feehan on 11/05/2016.
 */

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.LoggingBehavior;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

import ross.feehan.com.facebooklogin.BuildConfig;
import ross.feehan.com.facebooklogin.DataTypes.FacebookDetailsObject;
import ross.feehan.com.facebooklogin.DataTypes.FacebookLoginOnActivityResultObject;
import ross.feehan.com.facebooklogin.Features.FacebookCallbackDataInterface;
import ross.feehan.com.facebooklogin.Features.FacebookLoginLogicInterface;

public class FacebookCallbackDataImpl implements FacebookCallbackDataInterface{

    private Activity activity;
    private CallbackManager callbackManager;
    private FacebookLoginLogicInterface logic;
    private FacebookDetailsObject facebookDetails;

    //Constructor
    public FacebookCallbackDataImpl(Context ctx, Activity activity, FacebookDetailsObject facebookDetails){
        FacebookSdk.sdkInitialize(ctx.getApplicationContext());
        this.activity = activity;
        this.facebookDetails = facebookDetails;

        setUpFacebookDebug();
        setUpFacebookCallback();
    }

    //CLASS METHODS
    private void setUpFacebookDebug() {
        if (BuildConfig.DEBUG) {
            FacebookSdk.setIsDebugEnabled(true);
            FacebookSdk.addLoggingBehavior(LoggingBehavior.INCLUDE_ACCESS_TOKENS);
        }
    }

    //The callback from Facebook, if we successfully got the users facebook details
    private void setUpFacebookCallback() {
        callbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.i("fb login", loginResult.getAccessToken().toString());
                getUserDetailsFromFacebook(loginResult.getAccessToken());
            }

            @Override
            public void onCancel() {
                Log.i("fb login", "onCancel");
                logic.facebookLoginCancelled();
            }

            @Override
            public void onError(FacebookException error) {
                Log.i("fb login", "fb error");
                logic.facebookLoginError();
            }
        });
    }

    private void getUserDetailsFromFacebook(final AccessToken accessToken){
        GraphRequest request = GraphRequest.newMeRequest(accessToken, new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {
                if (response.getError() == null) {
                    Log.i("fb login", "got user details");
                    Log.i("fb login", object.toString());
                    extractFacebookUserDetailsAndSendBackToLogic(object, accessToken.toString());
                } else {
                    Log.i("fb login", "user details error");
                    logic.facebookLoginError();
                }
            }
        });

        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,first_name,last_name,email,picture.type(large)");
        request.setParameters(parameters);
        request.executeAsync();
    }

    private void extractFacebookUserDetailsAndSendBackToLogic(JSONObject userDetails, String facebookToken){
        try{
            facebookDetails.setFirstName(userDetails.optString("first_name"));
            facebookDetails.setLastName(userDetails.optString("last_name"));
            facebookDetails.setEmail(userDetails.optString("email"));
            facebookDetails.setProfilePicUrl(userDetails.getJSONObject("picture").getJSONObject("data").optString("url"));
            facebookDetails.setFacebookID(userDetails.optString("id"));
            facebookDetails.setFacebookToken(facebookToken);
            logic.facebookLoginSuccessful(facebookDetails);
        }catch(JSONException e){
            e.printStackTrace();
            logic.facebookLoginError();
        }
    }

    //INTERFACE METHODS
    //FacebookCallbackDataInterface METHODS
    @Override
    public void startFacebookLogin(FacebookLoginLogicInterface logic) {
        this.logic = logic;
        if(activity != null){
            LoginManager.getInstance().logInWithReadPermissions(activity, Arrays.asList("public_profile", "email"));
        }
        else{
            logic.facebookLoginError();
        }
    }

    @Override
    public void facebookLoginOnActivityResult(FacebookLoginOnActivityResultObject facebookLoginOnActivityResult) {
        callbackManager.onActivityResult(facebookLoginOnActivityResult.getRequestCode(),
                facebookLoginOnActivityResult.getResultCode(),
                facebookLoginOnActivityResult.getData());
    }

    @Override
    public void unregisterActivity() {
        activity = null;
    }
}