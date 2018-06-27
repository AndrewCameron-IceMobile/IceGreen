package com.icemobile.icegreen.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.icemobile.icegreen.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrew.cameron on 04/04/2018.
 */

public class LoginFragment extends Fragment {

    private OnLoginClickListener mOnLoginClickListener;
    private OnSignupClickListener mOnSignupClickListener;
    private EditText emailInput;
    private EditText passwordInput;

    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_login, parent, false);

        return view;
    }

    public static LoginFragment newInstance(final Bundle extra) {
        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(extra);
        return fragment;
    }

    public interface OnLoginClickListener {
        void OnLoginClicked(String email, String password);
    }

    public interface OnSignupClickListener {
        void OnSignupClicked();
    }

    public void setOnLoginClickListener(OnLoginClickListener onLoginClickListener) {
        mOnLoginClickListener = onLoginClickListener;
    }

    public void setOnSignupClickListener(OnSignupClickListener onSignupClickListener) {
        mOnSignupClickListener = onSignupClickListener;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        emailInput = view.findViewById(R.id.username_input_login);
        passwordInput = view.findViewById(R.id.password_input_login);

        Button buttonLogin = (Button) view.findViewById(R.id.button_go_to_profile);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnLoginClickListener.OnLoginClicked(emailInput.getText().toString(), passwordInput.getText().toString());
            }
        });

        Button buttonSignup = view.findViewById(R.id.button_go_to_signup);
        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnSignupClickListener.OnSignupClicked();
            }
        });
    }
}
