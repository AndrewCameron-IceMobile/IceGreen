package com.icemobile.icegreen.ui.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.icemobile.icegreen.R;
import com.icemobile.icegreen.leaderboard.LeaderboardProfile;
import com.icemobile.icegreen.ui.fragment.LoginFragment;
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
    private static final String TAG = "SIGNUP";

    // [START declare_auth]
    private FirebaseAuth mAuth;
    // [END declare_auth]

    // [START Text Fields]
    private EditText emailField;
    private EditText passwordField;

//    private EditText emailField = (EditText) findViewById(R.id.email_input);
//    String email = emailField.getText().toString();
////
//    private EditText passwordField = (EditText) findViewById(R.id.password_input);
//    String password = passwordField.getText().toString();
    // [END Text Fields]



//    EditText lastNameInput = (EditText) findViewById(R.id.last_name_input);
//    String lastName = lastNameInput.getText().toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(0,0);
        setContentView(R.layout.activity_signup);

        // [START initialize_auth]
        mAuth = FirebaseAuth.getInstance();
        // [END initialize_auth]

        //Views
        emailField = (EditText) findViewById(R.id.email_input);
        passwordField = (EditText) findViewById(R.id.password_input);

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

    // [START on_start_check_user]
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    // BEGIN CREATE ACCOUNT
    private void createAccount(String email, String password) {
        Log.d(TAG, "createAccount:" + email);
//        if (!validateForm()) {
//            return;
//        }

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(SignUpActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }

        });
    }
    // END CREATE ACCOUNT

//    private boolean validateForm() {
//        boolean valid = true;
//
//        String email = emailField.getText().toString();
//
//        if (TextUtils.isEmpty(email)) {
//            emailField.setError("Required");
//            valid = false;
//        } else {
//            emailField.setError(null);
//        }
//
//        String password = passwordField.getText().toString();
//
//        if (TextUtils.isEmpty(password)) {
//            passwordField.setError("Required");
//            valid = false;
//        } else {
//            passwordField.setError(null);
//        }
//
//        return valid;
//    }

    //Update UI
    private void updateUI(FirebaseUser user) {
        if (user != null) {

        } else {

        }
    }

    @Override
    public void onCancelSignUpClicked() {

        Intent myIntent = new Intent(SignUpActivity.this, LoginActivity.class);
        startActivity(myIntent);

    }

    @Override
    public void onConfirmSignUpClicked() {
        final ProgressDialog progressDialog = ProgressDialog.show(SignUpActivity.this, "Please wait...", "Processing...", true);
        mAuth.createUserWithEmailAndPassword(emailField.getText().toString(), passwordField.getText().toString())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if (task.isSuccessful()) {
                            Toast.makeText(SignUpActivity.this, "Registration successful", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(SignUpActivity.this, LoginActivity.class);
                            startActivity(i);
                        } else {
                            Log.e("ERROR", task.getException().toString());
                            Toast.makeText(SignUpActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

//        String testEmail = "email@email.com";
//        String testPassword = "pass";
//
//        createAccount(testEmail, testPassword);
//
//        Intent myIntent = new Intent(SignUpActivity.this, LoginActivity.class);
//        startActivity(myIntent);

// Read from database
//        EditText email = (EditText) findViewById(R.id.email_input);
//        String username = email.getText().toString();
//
//        EditText firstNameInput = (EditText) findViewById(R.id.first_name_input);
//        String firstName = firstNameInput.getText().toString();
//        EditText lastNameInput = (EditText) findViewById(R.id.last_name_input);
//        String lastName = lastNameInput.getText().toString();

//        long leaves = 0, monPresent = 0, tuePresent = 0, wedPresent = 0, thuPresent = 0, friPresent = 0;

//        final FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference ref = database.getReference("Profiles");

//        DatabaseReference newProfileRef = ref.child(username);
//        newProfileRef.setValue(new LeaderboardProfile(username, leaves, password, name, monPresent, tuePresent, wedPresent, thuPresent, friPresent));
    }

//    @Override
//    public void onClick(View v) {
//        int i = v.getId();
//
//        if (i == R.id.confirm_button_signup) {
//            createAccount(emailField.getText().toString(), passwordField.getText().toString());
//
//            Intent myIntent = new Intent(SignUpActivity.this, LoginFragment.class);
//            startActivity(myIntent);
//        }
//    }
}
