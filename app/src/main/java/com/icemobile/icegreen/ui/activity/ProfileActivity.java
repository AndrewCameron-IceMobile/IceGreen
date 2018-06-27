package com.icemobile.icegreen.ui.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.icemobile.icegreen.ui.fragment.ProfileFragment;
import com.icemobile.icegreen.R;

import com.nex3z.togglebuttongroup.MultiSelectToggleGroup;

public class ProfileActivity extends AppCompatActivity implements ProfileFragment.OnConfirmClickListener, ProfileFragment.OnReturnClickListener {

    private static final String PROFILE_FRAGMENT_TAG = "PROFILE_FRAGMENT_TAG";
    public static final String ARG_EXTRA_BUNDLE = "ARG_EXTRA_BUNDLE";

    // Mulit Select TAG
    private static final String LOG_TAG = ProfileFragment.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(0,0);
        setContentView(R.layout.activity_profile);
//        init();

        if (savedInstanceState == null && !isFragmentShown()){
            showFragment();
        }
    }

    private void showFragment() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ProfileFragment fragment = ProfileFragment.newInstance(getIntent().getBundleExtra(ARG_EXTRA_BUNDLE));
        fragment.setOnConfirmClickListener(this);
        fragment.setOnReturnClickListener(this);

        ft.replace(R.id.fragment_container, fragment, PROFILE_FRAGMENT_TAG);
        ft.commit();
    }

    private boolean isFragmentShown() {
        FragmentManager fm = getFragmentManager();
        Fragment fragment = fm.findFragmentByTag(PROFILE_FRAGMENT_TAG);

        return fragment != null;
    }

    @Override
    public void onConfirmClicked() {
        Intent myIntent = new Intent(ProfileActivity.this, LeaderboardActivity.class);
        startActivity(myIntent);
    }

    @Override
    public void onReturnClickListener() {

    }
}
