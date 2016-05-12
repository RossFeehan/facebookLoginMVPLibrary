package ross.feehan.com.facebooklogin.Shared; /*
 * Created by Ross Feehan on 11/05/2016.
 */

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(injects = FacebookLoginApplication.class, library = true)
public class SharedDIModules {

    private Context ctx;

    public SharedDIModules(Context ctx){
        this.ctx = ctx;
    }

    @Provides @Singleton
    public MessageFactory provideMessageFactory(){
        return new MessageFactory(ctx);
    }
}
