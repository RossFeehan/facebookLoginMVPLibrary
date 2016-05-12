package ross.feehan.com.facebooklogin.Features; /*
 * Created by Ross Feehan on 11/05/2016.
 */

import ross.feehan.com.facebooklogin.DataTypes.FacebookDetailsObject;
import ross.feehan.com.facebooklogin.DataTypes.FacebookLoginOnActivityResultObject;

public interface FacebookLoginLogicInterface {

    /**
     * User has clicked facebook login button
     */
    void facebookLoginBtnClicked();

    /**
     * Facebook Login request result being handled
     * @param facebookLoginOnActivityResult the code of the request, result of the request and data of the request that was made
     */
    void facebookLoginOnActivityResult(FacebookLoginOnActivityResultObject facebookLoginOnActivityResult);

    /**
     * Facebook Login has been successful
     * @param facebookDetails the users facebook details
     */
    void facebookLoginSuccessful(FacebookDetailsObject facebookDetails);

    /**
     * facebook login has been cancelled by user
     */
    void facebookLoginCancelled();

    /**
     *there was an error with facebook login
     */
    void facebookLoginError();

    /** unregisterActivity activity */
    void unregisterActivity();
}
