package com.icemobile.icegreen.dao.firebase;

import com.google.firebase.auth.FirebaseUser;

/**
 * Created by andrew.cameron on 21/06/2018.
 */

public interface FirebaseDAO {

    FirebaseUser getUserProfile();
    void updateDay(final Day day, final boolean isChecked);

}
