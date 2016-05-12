package ross.feehan.com.facebooklogin.Features; /*
 * Created by Ross Feehan on 11/05/2016.
 */

import ross.feehan.com.facebooklogin.DataTypes.FacebookDetailsObject;
import ross.feehan.com.facebooklogin.DataTypes.FacebookLoginOnActivityResultObject;
import ross.feehan.com.facebooklogin.Shared.MessageFactory;

public class FacebookLoginLogicImpl implements FacebookLoginLogicInterface{

    private FacebookCallbackDataInterface facebookCallback;
    private FacebookLoginViewInterface view;
    private MessageFactory messageFactory;

    //CONSTRUCTOR
    public FacebookLoginLogicImpl(FacebookCallbackDataInterface facebookCallback, FacebookLoginViewInterface view,
                                  MessageFactory msgFactory){
        this.facebookCallback = facebookCallback;
        this.view = view;
        this.messageFactory = msgFactory;
    }

    //INTERFACE METHODS
    //FacebookLoginLogicInterface METHODS
    @Override
    public void facebookLoginBtnClicked() {
        facebookCallback.startFacebookLogin(this);
    }

    @Override
    public void facebookLoginOnActivityResult(FacebookLoginOnActivityResultObject facebookLoginOnActivityResult) {
        facebookCallback.facebookLoginOnActivityResult(facebookLoginOnActivityResult);
    }

    @Override
    public void facebookLoginSuccessful(FacebookDetailsObject facebookDetails) {
        //TODO SEND THE FACEBOOKDETAILS OBJECT TO YOUR BACKEND TO SAVE THIS FACEBOOK USER
        view.facebookLoginSuccessful(messageFactory.facebookSuccess());
    }

    @Override
    public void facebookLoginCancelled() {
        view.facebookLoginCancelled(messageFactory.facebookAppIDMessage());
    }

    @Override
    public void facebookLoginError() {
        view.facebookLoginError(messageFactory.facebookLoginError());
    }

    @Override
    public void unregisterActivity() {
        facebookCallback.unregisterActivity();
    }
}