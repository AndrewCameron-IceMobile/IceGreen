package com.icemobile.icegreen.ui.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.icemobile.icegreen.R;
import com.icemobile.icegreen.leaderboard.LeaderboardProfile;
import com.icemobile.icegreen.ui.fragment.MainFragment;
import com.icemobile.icegreen.ui.fragment.SignUpFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrew.cameron on 30/05/2018.
 */

public class SignUpActivity extends AppCompatActivity implements SignUpFragment.OnCancelSignUpClickListener, SignUpFragment.OnConfirmSignUpClickListener {

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
        SignUpFragment fragment = SignUpFragment.newInstance(getIntent().getBundleExtra(ARG_EXTRA_BUNDLE));
        fragment.setOnConfirmSignUpClickListener(this);
        fragment.setOnCancelSignUpClickListener(this);

        ft.replace(R.id.fragment_container, fragment, SIGNUP_FRAGMENT_TAG);
        ft.commit();
    }

    private boolean isFragmentShown(){
        FragmentManager fm = getFragmentManager();
        Fragment fragment = fm.findFragmentByTag(SIGNUP_FRAGMENT_TAG);

        return fragment != null;
    }

    @Override
    public void onCancelSignUpClicked() {
        Intent myIntent = new Intent(SignUpActivity.this, LoginActivity.class);
        startActivity(myIntent);

    }

    @Override
    public void onConfirmSignUpClicked() {
// Read from database
        EditText email = (EditText) findViewById(R.id.email_input);
        String username = email.getText().toString();
        long leaves = 0;
//        int id = 4;

//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("Profiles");
//        LeaderboardProfile profile = new LeaderboardProfile(id, username, leaves);
//        myRef.setValue(profile);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("Profiles");

//        DatabaseReference profilesRef = ref.child("Profiles");
        DatabaseReference newProfileRef = ref.child(username);
        newProfileRef.setValue(new LeaderboardProfile(username, leaves));

        Intent myIntent = new Intent(SignUpActivity.this, LoginActivity.class);
        startActivity(myIntent);
    }
}
