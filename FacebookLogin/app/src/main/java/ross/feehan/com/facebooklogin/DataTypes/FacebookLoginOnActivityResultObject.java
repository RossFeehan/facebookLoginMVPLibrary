package ross.feehan.com.facebooklogin.DataTypes; /*
 * Created by Ross Feehan on 11/05/2016.
 */

import android.content.Intent;

public class FacebookLoginOnActivityResultObject {

    private int requestCode;
    private int resultCode;
    private Intent data;

    //CONSTRUCTORS
    public FacebookLoginOnActivityResultObject(){

    }

    public FacebookLoginOnActivityResultObject(int requestCode, int resultCode, Intent data){
        setRequestCode(requestCode);
        setResultCode(resultCode);
        setData(data);
    }

    //SETTERS
    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public void setRequestCode(int requestCode) {
        this.requestCode = requestCode;
    }

    public void setData(Intent data) {
        this.data = data;
    }

    //GETTERS
    public int getResultCode() {
        return resultCode;
    }

    public int getRequestCode() {
        return requestCode;
    }

    public Intent getData() {
        return data;
    }
}
