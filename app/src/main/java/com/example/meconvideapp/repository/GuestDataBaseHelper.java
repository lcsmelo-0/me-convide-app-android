package com.example.meconvideapp.repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.example.meconvideapp.constants.DataBaseConstants;

public class GuestDataBaseHelper  extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "MeusConvidados.db";
    private static final String CREATE_TABLE_GUEST = "create table " + DataBaseConstants.GUEST.TABLE_NAME + " ("
            + DataBaseConstants.GUEST.COLUMNS.ID + " integer primary key autoincrement, "
            + DataBaseConstants.GUEST.COLUMNS.NAME + " text, "
            + DataBaseConstants.GUEST.COLUMNS.PRESENCE + " integer);";

    public GuestDataBaseHelper(Context context) {
        super(context, this.DATABASE_NAME, null, this.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_GUEST);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}

