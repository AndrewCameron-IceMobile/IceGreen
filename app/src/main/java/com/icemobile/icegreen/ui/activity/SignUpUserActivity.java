package com.icemobile.icegreen.ui.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.icemobile.icegreen.R;

/**
 * Created by andrew.cameron on 14/06/2018.
 */

public class SignUpUserActivity extends AppCompatActivity{

    private EditText emailInput;
    private EditText passwordInput;
    private FirebaseAuth mFirebaseAuth;

    private View.OnClickListener confirm_button_signup;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_signup);

        emailInput = findViewById(R.id.email_input);
        passwordInput = findViewById(R.id.password_input);

        mFirebaseAuth = FirebaseAuth.getInstance();

        final Button signUpConfirm = findViewById(R.id.confirm_button_signup);
        signUpConfirm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                signup_User(v);
            }
        });
    }

    public void signup_User(View v) {
        final ProgressDialog progressDialog = ProgressDialog.show(SignUpUserActivity.this, "Please wait...", "Processing...", true);
        mFirebaseAuth.createUserWithEmailAndPassword(emailInput.getText().toString(), passwordInput.getText().toString())
        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();

                if (task.isSuccessful()) {
                    Toast.makeText(SignUpUserActivity.this, "Registration successful", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(SignUpUserActivity.this, LoginActivity.class);
                    startActivity(i);
                } else {
                    Log.e("ERROR", task.getException().toString());
                    Toast.makeText(SignUpUserActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
