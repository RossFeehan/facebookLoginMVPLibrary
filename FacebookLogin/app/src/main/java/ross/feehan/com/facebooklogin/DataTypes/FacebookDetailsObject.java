package ross.feehan.com.facebooklogin.DataTypes; /*
 * Created by Ross Feehan on 11/05/2016.
 */

public class FacebookDetailsObject {

 String firstName;
    String lastName;
    String email;
    String profilePicUrl;
    String facebookID;
    String facebookToken;

    //CONSTRUCTOR
    public FacebookDetailsObject(){

    }

    public FacebookDetailsObject(String firstName, String lastName, String email,
                                 String profilePicUrl, String facebookID, String facebookToken){
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setProfilePicUrl(profilePicUrl);
        setFacebookID(facebookID);
        setFacebookToken(facebookToken);
    }

    //SETTERS
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setProfilePicUrl(String profilePicUrl) {
        this.profilePicUrl = profilePicUrl;
    }

    public void setFacebookID(String facebookID) {
        this.facebookID = facebookID;
    }

    public void setFacebookToken(String facebookToken) {
        this.facebookToken = facebookToken;
    }

    //GETTERS
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getProfilePicUrl() {
        return profilePicUrl;
    }

    public String getFacebookID() {
        return facebookID;
    }

    public String getFacebookToken() {
        return facebookToken;
    }
}
