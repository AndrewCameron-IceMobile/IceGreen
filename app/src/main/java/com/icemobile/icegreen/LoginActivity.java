package com.icemobile.icegreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    public EditText nameBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nameBox = (EditText) findViewById(R.id.enterNameBox);
        nameBox.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        nameBox.getText().clear();
    }

    public void goToProfile(View view) {
        Intent myIntent = new Intent(LoginActivity.this, ProfileActivity.class);
        startActivity(myIntent);
    }
}
