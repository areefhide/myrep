package com.myrep.rals.tehcnicianapps.Utility;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.myrep.rals.tehcnicianapps.LoginActivity;

/**
 * Created by Pinjaman on 1/22/2018.
 */

public class SessionManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    int PRIVATE_MODE =  0;

    private static final String PREF_NAME = "republic";
    private static final String KEY_USER = "username";
    private static final String IS_LOGIN = "IsLoggedIn";
    private static final String KEY_TOKEN = "token";

    public SessionManager(Context _context) {
        this._context = _context;
        pref = _context.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
        editor = pref.edit();
    }
    public void CreateLoginSession(String user, String token){
        editor.putBoolean(IS_LOGIN,true);
        editor.putString(KEY_USER,user);
        editor.putString(KEY_TOKEN,token);
        editor.commit();
    }

    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN,false);
    }

    public String getToken(){
        return pref.getString(KEY_TOKEN,"");
    }

    public void logoutUser(){
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();

        // After logout redirect user to Login Activity
        Intent i = new Intent(_context, LoginActivity.class);
        // Closing all the Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Add new Flag to start new Activity
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Staring Login Activity
        _context.startActivity(i);
    }



}
