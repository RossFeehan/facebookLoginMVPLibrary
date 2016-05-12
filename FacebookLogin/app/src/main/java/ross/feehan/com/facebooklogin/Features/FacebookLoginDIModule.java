package ross.feehan.com.facebooklogin.Features; /*
 * Created by Ross Feehan on 11/05/2016.
 */

import android.app.Activity;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ross.feehan.com.facebooklogin.DataTypes.FacebookCallbackDataImpl;
import ross.feehan.com.facebooklogin.DataTypes.FacebookDetailsObject;
import ross.feehan.com.facebooklogin.DataTypes.FacebookLoginOnActivityResultObject;
import ross.feehan.com.facebooklogin.Shared.MessageFactory;

@Module(injects = FacebookLoginActivity.class, complete = false)
public class FacebookLoginDIModule {

    private Context ctx;
    private FacebookLoginViewInterface view;
    private Activity activity;

    //CONSTRUCTOR
    public FacebookLoginDIModule(Context ctx, FacebookLoginViewInterface view, Activity activity) {
        this.ctx = ctx;
        this.view = view;
        this.activity = activity;
    }

    @Provides
    public FacebookCallbackDataInterface provideFacebookCallbackDataInterface(FacebookDetailsObject facebookDetails) {
        return new FacebookCallbackDataImpl(ctx, activity, facebookDetails);
    }

    @Provides
    public FacebookLoginLogicInterface provideFacebookLoginLogicInterface(FacebookCallbackDataInterface facebookCallback, MessageFactory msgFactory){
        return new FacebookLoginLogicImpl(facebookCallback, view, msgFactory);
    }

    @Provides
    public FacebookLoginOnActivityResultObject provideFacebookLoginOnActivityResult(){
        return new FacebookLoginOnActivityResultObject();
    }

    @Provides
    public FacebookDetailsObject provideFacebookDetailsObject(){
        return new FacebookDetailsObject();
    }
}