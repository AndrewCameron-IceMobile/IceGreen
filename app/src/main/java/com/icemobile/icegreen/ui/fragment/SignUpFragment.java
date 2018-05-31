package com.icemobile.icegreen.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.icemobile.icegreen.R;

/**
 * Created by andrew.cameron on 30/05/2018.
 */

public class SignUpFragment extends Fragment{

    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_signup, parent, false);

        return view;
    }

    public static MainFragment newInstance(final Bundle extra) {
        MainFragment fragment = new MainFragment();
        fragment.setArguments(extra);
        return fragment;
    }
}
