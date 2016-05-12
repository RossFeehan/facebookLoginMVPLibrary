package ross.feehan.com.facebooklogin.Shared; /*
 * Created by Ross Feehan on 11/05/2016.
 */

import android.content.Context;

import ross.feehan.com.facebooklogin.R;

public class MessageFactory {

    private Context ctx;

    //CONSTRUCTOR
    public MessageFactory(Context ctx){
        this.ctx = ctx;
    }

    public String facebookLoginError(){ return ctx.getString(R.string.facebookError); }

    public String facebookSuccess(){ return ctx.getString(R.string.facebookSuccess); }

    public String facebookAppIDMessage(){ return ctx.getString(R.string.facebookAppIDMessage); }



}
