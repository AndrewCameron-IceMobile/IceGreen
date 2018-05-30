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
 * Created by andrew.cameron on 04/04/2018.
 */

public class MainFragment extends Fragment {

    private OnNextClickListener mOnNextClickListener;

    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_main, parent, false);

        return view;
    }

    public static MainFragment newInstance(final Bundle extra) {
        MainFragment fragment = new MainFragment();
        fragment.setArguments(extra);
        return fragment;
    }

    public interface OnNextClickListener {
        void onNextClicked();
    }

    public void setOnNextClickListener(OnNextClickListener onNextClickListener) {
        mOnNextClickListener = onNextClickListener;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button buttonNext = (Button) view.findViewById(R.id.button_go_to_login);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnNextClickListener.onNextClicked();
            }
        });
    }
}
