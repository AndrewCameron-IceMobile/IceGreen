package com.icemobile.icegreen.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.icemobile.icegreen.R;

/**
 * Created by andrew.cameron on 04/04/2018.
 */

public class LoginFragment extends Fragment {

    private OnLoginClickListener mOnLoginClickListener;

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
        void OnLoginClicked();
    }

    public void setOnLoginClickListener(OnLoginClickListener onLoginClickListener) {
        mOnLoginClickListener = onLoginClickListener;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final EditText usersName = (EditText) view.findViewById(R.id.text_users_name);
        usersName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usersName.getText().clear();
            }
        });

        Button buttonLogin = (Button) view.findViewById(R.id.button_go_to_profile);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnLoginClickListener.OnLoginClicked();
            }
        });
    }
}
