package com.icemobile.icegreen.Firebase;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by andrew.cameron on 20/06/2018.
 */

public class FirebaseDAOimpl {

    private final FirebaseDatabase mFirebaseDAOimpl;

    public FirebaseDAOimpl() {
        mFirebaseDAOimpl = FirebaseDatabase.getInstance();
    }
}
