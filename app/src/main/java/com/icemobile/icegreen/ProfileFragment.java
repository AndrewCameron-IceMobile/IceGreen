package com.icemobile.icegreen;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by andrew.cameron on 05/04/2018.
 */

public class ProfileFragment extends Fragment {

    private OnConfirmClickListener mOnConfirmClickListener;
    private OnReturnClickListener mOnReturnClickListener;

    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_profile, parent, false);

        return view;
    }

    public static ProfileFragment newInstance(final Bundle extra) {
        ProfileFragment fragment = new ProfileFragment();
        fragment.setArguments(extra);
        return fragment;
    }

    public interface OnConfirmClickListener {
        void onConfirmClicked();
    }

    public void setOnConfirmClickListener(OnConfirmClickListener onConfirmClickListener) {
        mOnConfirmClickListener = onConfirmClickListener;
    }

    public interface OnReturnClickListener {
        void onReturnClickListener();
    }

    public void setOnReturnClickListener(OnReturnClickListener onReturnClickListener) {
        mOnReturnClickListener = onReturnClickListener;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button buttonConfirm = (Button) view.findViewById(R.id.button_confirm_days);
        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnConfirmClickListener.onConfirmClicked();
            }
        });

        ImageView viewReturn = (ImageView) view.findViewById(R.id.view_return_to_login);
        viewReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mOnReturnClickListener.onReturnClickListener();
                getActivity().finish();
            }
    });
    }
}
