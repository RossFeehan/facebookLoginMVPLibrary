package ross.feehan.com.facebooklogin.Shared; /*
 * Created by Ross Feehan on 11/05/2016.
 */

import android.app.Application;

import java.util.Arrays;
import java.util.List;

import dagger.ObjectGraph;

public class FacebookLoginApplication extends Application{

    private ObjectGraph objectGraph;

    @Override
    public void onCreate(){
        super.onCreate();

        //DAGGER
        objectGraph = ObjectGraph.create(getModules().toArray());
        objectGraph.inject(this);

    }

    private List<Object> getModules(){
        return Arrays.<Object>asList(new SharedDIModules(this));
    }

    public ObjectGraph getObjectGraph(){
        return objectGraph;
    }
}
