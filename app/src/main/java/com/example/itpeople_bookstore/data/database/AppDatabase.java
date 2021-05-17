package com.example.itpeople_bookstore.data.database;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

public abstract class AppDatabase extends RoomDatabase {

    public abstract BookDAO bookDAO();

    private static AppDatabase instance = null;

    public static AppDatabase getInstance(Application app) {
        if (instance != null) {
            return instance;
        } else {
            synchronized (app.getApplicationContext()) {
                instance = buildDatabase(app);
                return instance;
            }
        }
    }


    private static AppDatabase buildDatabase(Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, "itpeople_bookstore")
                .fallbackToDestructiveMigration().build();
    }
}
