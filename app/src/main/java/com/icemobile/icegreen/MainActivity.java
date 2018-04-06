package com.icemobile.icegreen;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements MainFragment.OnNextClickListener {

    private static final String MAIN_FRAGMENT_TAG = "MAIN_FRAGMENT_TAG";
    public static final String ARG_EXTRA_BUNDLE = "ARG_EXTRA_BUNDLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(0,0);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null && !isFragmentShown()){
            showFragment();
        }
    }

    private void showFragment(){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        MainFragment fragment = MainFragment.newInstance(getIntent().getBundleExtra(ARG_EXTRA_BUNDLE));
        fragment.setOnNextClickListener(this);

        ft.replace(R.id.fragment_container, fragment, MAIN_FRAGMENT_TAG);
        ft.commit();
    }

    private boolean isFragmentShown(){
        FragmentManager fm = getFragmentManager();
        Fragment fragment = fm.findFragmentByTag(MAIN_FRAGMENT_TAG);

        return fragment != null;
    }

    @Override
    public void onNextClicked() {
        finish();
        Intent myIntent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(myIntent);
    }
}
