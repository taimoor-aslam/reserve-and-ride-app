package com.example.resereride;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDatabase extends SQLiteOpenHelper {
   private static final String DB_NAME="reserve";
   private static final String TABLE_NAME="reservationInfo";
   private static final Integer DB_VERSION=1;
   private static final String COLUMN_ID="col_id";
   private static final String USER_NAME="name";
   private static final String USER_PHONE="phone";
   private static final String USER_PASSWORD="password";
   private static final String USER_CNIC="cnic";
   private static final String USER_EMAIL="email";
   private static final String USER_GENDER="gender";
   SQLiteDatabase db;

    public MyDatabase(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + "("
                        + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + USER_NAME + " TEXT,"
                        + USER_PHONE + " TEXT,"
                        + USER_CNIC + " TEXT,"
                        + USER_EMAIL + " TEXT,"
                        + USER_PASSWORD + " TEXT,"
                        + USER_GENDER + " TEXT"
                        + ")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public long insert(String name,String phone,String cnic,String email,String password,String gender)
    {
        db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(USER_NAME,name);
        cv.put(USER_PHONE,phone);
        cv.put(USER_CNIC,cnic);
        cv.put(USER_EMAIL,email);
        cv.put(USER_PASSWORD,password);
        cv.put(USER_GENDER,gender);
        long id=db.insert(TABLE_NAME,null,cv);
        db.close();
        return id;
    }
    public boolean verify(String phone,String password)
    {
        db=this.getReadableDatabase();
        Cursor c=db.query(TABLE_NAME,new String []{USER_PHONE,USER_PASSWORD},
                USER_PHONE + "=? AND " +USER_PASSWORD + "=?",new String[]{phone,password},
                null,null,null,null);
        if(c!=null&&c.moveToFirst())
        {
            return true;
        }
        return false;
    }
    public String show() {
        db = this.getReadableDatabase();
        Cursor c = db.query(TABLE_NAME, new String[]{USER_NAME, USER_EMAIL, USER_CNIC,USER_PASSWORD,USER_PHONE,USER_GENDER},
                null, null, null, null, null);
        int firstIndex = c.getColumnIndex(USER_PHONE);
        int secondIndex = c.getColumnIndex(USER_PASSWORD);

        String result="";
        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            String mPhone = c.getString(firstIndex);
            String mPassword = c.getString(secondIndex);
            result+=c.getString(firstIndex)+" "+c.getString(secondIndex)+"\n\n";
        }
        return result;
    }
}
