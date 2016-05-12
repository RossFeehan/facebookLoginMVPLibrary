package ross.feehan.com.facebooklogin.Features;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Toast;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ross.feehan.com.facebooklogin.DataTypes.FacebookLoginOnActivityResultObject;
import ross.feehan.com.facebooklogin.R;
import ross.feehan.com.facebooklogin.Shared.FacebookLoginApplication;

public class FacebookLoginActivity extends AppCompatActivity implements FacebookLoginViewInterface{

    @Bind(R.id.rootView) ViewGroup rootView;

    @Inject FacebookLoginLogicInterface logic;
    @Inject FacebookLoginOnActivityResultObject facebookLoginOnActivityResultObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initDependencies();
        setupUI();
    }

    private void initDependencies() {
        ((FacebookLoginApplication) getApplication()).getObjectGraph().plus(new FacebookLoginDIModule(this, this, this)).inject(this);
    }

    private void setupUI() {
        setContentView(R.layout.facebook_login_layout);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.loginWithFacebookBTN)
    void onLoginWithFacebookBTNClicked(){
        logic.facebookLoginBtnClicked();
    }

    //INTERFACE METHODS
    //FacebookLoginViewInterface METHODS
    @Override
    public void facebookLoginSuccessful(String message) {
        Snackbar.make(rootView, message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void facebookLoginCancelled(String message) {
        Snackbar.make(rootView, message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void facebookLoginError(String userMessage) {
        Toast.makeText(this, userMessage, Toast.LENGTH_LONG).show();
    }

    //ACTIVITY LIFECYCLE METHODS
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        facebookLoginOnActivityResultObject.setRequestCode(requestCode);
        facebookLoginOnActivityResultObject.setResultCode(resultCode);
        facebookLoginOnActivityResultObject.setData(data);
        logic.facebookLoginOnActivityResult(facebookLoginOnActivityResultObject);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("onDestroy", "LoginLandingActivity");
        logic.unregisterActivity();
    }
}