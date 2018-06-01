package com.cross.android.crossapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.cross.android.crossapplication.R;
import com.cross.android.crossapplication.model.User;
import com.cross.android.crossapplication.service.LoginService;
import com.cross.android.crossapplication.util.RetrofitUtil;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.Arrays;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashActivity extends AppCompatActivity implements FacebookCallback<LoginResult>{
    private LoginButton loginButton;
    private CallbackManager callbackManager = null;
    private View rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Realm.init(this);
        startActivity(new Intent(this, MainActivity.class));
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        setContentView(R.layout.activity_splash);
        rootView = findViewById(R.id.rootView);
        callbackManager = CallbackManager.Factory.create();
        loginButton = findViewById(R.id.btn_fb);
        loginButton.setReadPermissions(Arrays.asList("public_profile", "email"));
        loginButton.registerCallback(callbackManager, this);
        findViewById(R.id.btnLoginFacebook).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginButton.performClick();
            }
        });
        checkLogined();
    }

    private void checkLogined(){
        Realm realm = Realm.getDefaultInstance();
        if(realm.where(User.class).count()>0){
            next();
        }
    }

    private void next(){
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }


    @Override
    public void onSuccess(LoginResult loginResult) {
        LoginService service = RetrofitUtil.create(this).create(LoginService.class);
        service.signin(loginResult.getAccessToken().getToken()).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){
                    Realm realm = Realm.getDefaultInstance();
                    realm.beginTransaction();
                    realm.copyToRealm(response.body());
                    realm.commitTransaction();
                    next();
                }else{
                    Snackbar.make(rootView, "로그인 실패", Snackbar.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Snackbar.make(rootView, "로그인 실패", Snackbar.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
    }

    @Override
    public void onCancel() {
    }

    @Override
    public void onError(FacebookException exception) {
        Snackbar.make(rootView, "로그인 실패", Snackbar.LENGTH_SHORT);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}
