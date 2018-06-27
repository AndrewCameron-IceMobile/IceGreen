package com.icemobile.icegreen.dao.firebase.impl;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.icemobile.icegreen.dao.firebase.Day;
import com.icemobile.icegreen.dao.firebase.FirebaseDAO;

/**
 * Created by andrew.cameron on 20/06/2018.
 */

public class FirebaseDAOImpl implements FirebaseDAO {

    private static FirebaseDAOImpl sFirebaseDAO;

    public static FirebaseDAOImpl getInstance(){
        if(sFirebaseDAO == null){
            sFirebaseDAO = new FirebaseDAOImpl();
        }

        return sFirebaseDAO;
    }

    @Override
    public FirebaseUser getUserProfile() {
        return FirebaseAuth.getInstance().getCurrentUser();
    }

    @Override
    public void updateDay(Day day, boolean isChecked) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference profilesReference = database.getReference("Profiles");
        final DatabaseReference userProfileReference = profilesReference.child(getUserProfile().getUid());

        DatabaseReference dayToUpdate = null;

        switch (day){
            case MONDAY:
                dayToUpdate = userProfileReference.child("monPresent");
                break;
            case TUESDAY:
                dayToUpdate = userProfileReference.child("tuePresent");
                break;
            case WEDNESDAY:
                dayToUpdate = userProfileReference.child("monPresent");
                break;
            case THURSDAY:
                dayToUpdate = userProfileReference.child("monPresent");
                break;
            case FRIDAY:
                dayToUpdate = userProfileReference.child("monPresent");
                break;
        }

        if(dayToUpdate != null) {
            dayToUpdate.setValue(isChecked);
        }
    }

}
