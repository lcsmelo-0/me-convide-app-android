package com.example.meconvideapp.repository;

import android.content.Context;

public class GuestRepository {

    private static GuestRepository INSTANCE;
    private GuestDataBaseHelper mGuestDataBaseHelper;

    private GuestRepository(Context c){
        this.mGuestDataBaseHelper = new GuestDataBaseHelper(c);
    }

    public static synchronized GuestRepository getInstance(Context c){
        if(INSTANCE == null){
            INSTANCE = new GuestRepository(c);
        }
        return INSTANCE;
    }
}
