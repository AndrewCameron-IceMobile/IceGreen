package com.icemobile.icegreen.ui.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.icemobile.icegreen.R;
import com.icemobile.icegreen.ui.fragment.MainFragment;
import com.icemobile.icegreen.ui.fragment.SignUpFragment;

/**
 * Created by andrew.cameron on 30/05/2018.
 */

public class SignUpActivity extends AppCompatActivity {

    private static final String SIGNUP_FRAGMENT_TAG = "SIGNUP_FRAGMENT_TAG";
    public static final String ARG_EXTRA_BUNDLE = "ARG_EXTRA_BUNDLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(0,0);
        setContentView(R.layout.activity_signup);

        if (savedInstanceState == null && !isFragmentShown()){
            showFragment();
        }
    }

    private void showFragment(){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        MainFragment fragment = MainFragment.newInstance(getIntent().getBundleExtra(ARG_EXTRA_BUNDLE));

        ft.replace(R.id.fragment_container, fragment, SIGNUP_FRAGMENT_TAG);
        ft.commit();
    }

    private boolean isFragmentShown(){
        FragmentManager fm = getFragmentManager();
        Fragment fragment = fm.findFragmentByTag(SIGNUP_FRAGMENT_TAG);

        return fragment != null;
    }
}
