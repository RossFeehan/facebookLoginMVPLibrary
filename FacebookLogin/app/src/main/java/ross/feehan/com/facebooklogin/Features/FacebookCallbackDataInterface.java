package ross.feehan.com.facebooklogin.Features; /*
 * Created by Ross Feehan on 11/05/2016.
 */

import ross.feehan.com.facebooklogin.DataTypes.FacebookLoginOnActivityResultObject;

public interface FacebookCallbackDataInterface {

    /**
     * Facebook Login request made
     * @param logic FacebookLoginLogicInterface class to callback to
     */
    void startFacebookLogin(FacebookLoginLogicInterface logic);

    /**
     * Facebook Login request result being handled
     * @param facebookLoginOnActivityResult the code of the request, result of the request and data of the request that was made
     */
    void facebookLoginOnActivityResult(FacebookLoginOnActivityResultObject facebookLoginOnActivityResult);

    /** unregisterActivity activity */
    void unregisterActivity();
}
