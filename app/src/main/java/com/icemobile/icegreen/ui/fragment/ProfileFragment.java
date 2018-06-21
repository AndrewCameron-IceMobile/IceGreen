package com.icemobile.icegreen.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.icemobile.icegreen.R;

import com.nex3z.togglebuttongroup.MultiSelectToggleGroup;
import com.nex3z.togglebuttongroup.button.CircularToggle;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by andrew.cameron on 05/04/2018.
 */

public class ProfileFragment extends Fragment {

    private OnConfirmClickListener mOnConfirmClickListener;
    private OnReturnClickListener mOnReturnClickListener;
    private String email, uID, name_of_user;
    private long currentLeaves, newLeaves;
    private Boolean mon = false, tue = false, wed = false, thu = false, fri = false;

    private static final String TAG = "USER";

    // Mulit Select TAG
    private static final String LOG_TAG = ProfileFragment.class.getSimpleName();


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
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final TextView currentUserTextView = (TextView) view.findViewById(R.id.current_user_display);

        //Retrieve the UserID
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            uID = user.getUid();
        }
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = database.getReference("Profiles");

        //[BEGIN] Update Leaves
        final DatabaseReference dayPresent = reference.child(uID);

        MultiSelectToggleGroup multi = (MultiSelectToggleGroup) view.findViewById(R.id.day_choices);
        multi.setOnCheckedChangeListener(new MultiSelectToggleGroup.OnCheckedStateChangeListener() {
            @Override
            public void onCheckedStateChanged(MultiSelectToggleGroup group, int checkedId, boolean isChecked) {
                CircularToggle toggle = view.findViewById(checkedId);
                String tag = "" + toggle.getTag();

                switch (tag) {
                    case "monday":
                        DatabaseReference updateMon = dayPresent.child("monPresent");
                        updateMon.setValue(isChecked);

                        break;
                    case "tuesday":
                        DatabaseReference updateTue = dayPresent.child("tuePresent");
                        updateTue.setValue(isChecked);

                        break;
                    case "wednesday":
                        DatabaseReference updateWed = dayPresent.child("wedPresent");
                        updateWed.setValue(isChecked);
                        break;
                    case "thursday":
                        DatabaseReference updateThu = dayPresent.child("thuPresent");
                        updateThu.setValue(isChecked);
                        break;
                    case "friday":
                        DatabaseReference updateFri = dayPresent.child("friPresent");
                        updateFri.setValue(isChecked);
                        break;
                }
                System.out.println("Clicked");
            }
        });

        DatabaseReference profiles = FirebaseDatabase.getInstance().getReference("Profiles");
        DatabaseReference profileRef = profiles.child(uID);
        DatabaseReference profileName = profileRef.child("name");

        profileName.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.i(TAG, dataSnapshot.getValue(String.class));
                name_of_user = dataSnapshot.getValue().toString();
                System.out.println(name_of_user);

                currentUserTextView.setText(name_of_user);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "onCancelled", databaseError.toException());
            }
        });

        Button buttonConfirm = (Button) view.findViewById(R.id.button_confirm_days);
        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Retrieve the UserID
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null) {
                    uID = user.getUid();
                }
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference reference = database.getReference("Profiles");

                //[BEGIN] Update Leaves
                DatabaseReference updateLeaves = reference.child(uID);
                DatabaseReference getCurrentLeaves = updateLeaves.child("numberOfLeaves");
                getCurrentLeaves.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        currentLeaves = (Long) dataSnapshot.getValue();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

                newLeaves = currentLeaves++;
                updateLeaves.child("numberOfLeaves").setValue(newLeaves);
                //[END] Update Leaves

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
