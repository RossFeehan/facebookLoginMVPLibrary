package ross.feehan.com.facebooklogin.Features; /*
 * Created by Ross Feehan on 11/05/2016.
 */

/**
 * Shows UI to user
 * Reports user's interaction with it to {@link FacebookLoginLogicImpl}
 */
public interface FacebookLoginViewInterface {

    /**
     * Facebook Login has been successful
     */
    void facebookLoginSuccessful(String message);

    /**
     * facebook login has been cancelled by user
     */
    void facebookLoginCancelled(String message);

    /**
     *there was an error with facebook login
     */
    void facebookLoginError(String userMessage);
}
