package com.icemobile.icegreen.ui.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.icemobile.icegreen.R;
//import com.icemobile.icegreen.ui.activity.ProfileActivity;
import com.icemobile.icegreen.ui.fragment.LoginFragment;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity implements LoginFragment.OnLoginClickListener, LoginFragment.OnSignupClickListener, LoginFragment.OnFindUsernameClickListener {

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

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("Profiles");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                final List<String> profiles = new ArrayList<String>();

                for (DataSnapshot profilesSnapshot: dataSnapshot.getChildren()) {
                    String profileUsername = profilesSnapshot.child("username").getValue(String.class);
                    profiles.add(profileUsername);
                }

                Spinner profileSpinner = (Spinner) findViewById(R.id.spinner);
                ArrayAdapter<String> profilesAdapter = new ArrayAdapter<String>(LoginActivity.this, android.R.layout.simple_spinner_item, profiles);
                profilesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                profileSpinner.setAdapter(profilesAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void showFragment(){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        LoginFragment fragment = LoginFragment.newInstance(getIntent().getBundleExtra(ARG_EXTRA_BUNDLE));
        fragment.setOnLoginClickListener(this);
        fragment.setOnSignupClickListener(this);
        fragment.setOnFindUsernameClickListener(this);

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

    @Override
    public void OnFindUsernameClicked() {
        final AutoCompleteTextView usersName = (AutoCompleteTextView) findViewById(R.id.name_search);
        usersName.setThreshold(1);
        usersName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference ref = database.getReference("Profiles");

                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        final List<String> profiles = new ArrayList<String>();

                        for (DataSnapshot profilesSnapshot: dataSnapshot.getChildren()) {
                            String profileUsername = profilesSnapshot.child("username").getValue(String.class);
                            profiles.add(profileUsername);
                        }

                        Spinner profileSpinner = (Spinner) findViewById(R.id.spinner);
                        ArrayAdapter<String> profilesAdapter = new ArrayAdapter<String>(LoginActivity.this, android.R.layout.simple_spinner_item, profiles);
                        profilesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        profileSpinner.setAdapter(profilesAdapter);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
