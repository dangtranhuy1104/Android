package com.fpt.edu.ss10.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class},version=1)

public abstract class Appdatabase extends RoomDatabase {
    private static Appdatabase appdatabase;
    public abstract UserDao userDao();
    public static Appdatabase getAppdatabase(Context context){
        if (appdatabase==null){
            appdatabase = Room.databaseBuilder(context,Appdatabase.class,"User.db").allowMainThreadQueries().build();
        }
        return appdatabase;
    }
}
