package com.icemobile.icegreen.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.icemobile.icegreen.R;

/**
 * Created by andrew.cameron on 30/05/2018.
 */

public class SignUpFragment extends Fragment{

    private OnConfirmSignUpClickListener mOnConfirmSignUpClickListener;
    private OnCancelSignUpClickListener mOnCancelSignUpClickListener;

    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_signup, parent, false);

        return view;
    }

    public static SignUpFragment newInstance(final Bundle extra) {
        SignUpFragment fragment = new SignUpFragment();
        fragment.setArguments(extra);
        return fragment;
    }

    public interface OnCancelSignUpClickListener {
        void onCancelSignUpClicked();
    }

    public interface OnConfirmSignUpClickListener {
        void onConfirmSignUpClicked();
    }

    public void setOnCancelSignUpClickListener(OnCancelSignUpClickListener onCancelSignUpClickListener) {
        mOnCancelSignUpClickListener = onCancelSignUpClickListener;
    }

    public void setOnConfirmSignUpClickListener(OnConfirmSignUpClickListener onConfirmSignUpClickListener) {
        mOnConfirmSignUpClickListener = onConfirmSignUpClickListener;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button buttonCancel = (Button) view.findViewById(R.id.cancel_button_signup);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnCancelSignUpClickListener.onCancelSignUpClicked();
            }
        });

        Button buttonConfirm = (Button) view.findViewById(R.id.confirm_button_signup);
        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnConfirmSignUpClickListener.onConfirmSignUpClicked();
            }
        });
    }
}
