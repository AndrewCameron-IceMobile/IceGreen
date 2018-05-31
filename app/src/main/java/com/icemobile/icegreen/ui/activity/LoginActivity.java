package com.icemobile.icegreen.ui.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.icemobile.icegreen.R;
//import com.icemobile.icegreen.ui.activity.ProfileActivity;
import com.icemobile.icegreen.ui.fragment.LoginFragment;

public class LoginActivity extends AppCompatActivity implements LoginFragment.OnLoginClickListener, LoginFragment.OnSignupClickListener{

    private static final String LOGIN_FRAGMENT_TAG = "LOGIN_FRAGMENT_TAG";
    public static final String ARG_EXTRA_BUNDLE = "ARG_EXTRA_BUNDLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(0,0);
        setContentView(R.layout.activity_login);

        if (savedInstanceState == null && !isFragmentShown()){
            showFragment();
        }
    }

    private void showFragment(){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        LoginFragment fragment = LoginFragment.newInstance(getIntent().getBundleExtra(ARG_EXTRA_BUNDLE));
        fragment.setOnLoginClickListener(this);
        fragment.setOnSignupClickListener(this);

        ft.replace(R.id.fragment_container, fragment, LOGIN_FRAGMENT_TAG);
        ft.commit();
    }

    private boolean isFragmentShown(){
        FragmentManager fm = getFragmentManager();
        Fragment fragment = fm.findFragmentByTag(LOGIN_FRAGMENT_TAG);

        return fragment != null;
    }

    @Override
    public void OnLoginClicked() {
        Intent myIntent = new Intent(LoginActivity.this, ProfileActivity.class);
        startActivity(myIntent);
    }

    @Override
    public void OnSignupClicked() {
        Intent myIntent = new Intent(LoginActivity.this, SignUpActivity.class);
        startActivity(myIntent);
    }
}
