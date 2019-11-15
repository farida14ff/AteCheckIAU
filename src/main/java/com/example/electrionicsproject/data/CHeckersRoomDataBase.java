package com.example.electrionicsproject.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.electrionicsproject.models.Checker;



@Database(entities = Checker.class, version = 1)
public abstract class CHeckersRoomDataBase extends RoomDatabase {

    public abstract CheckersDao checkersDao();
    //add

    private static volatile CHeckersRoomDataBase cHeckersRoomDataBase;

    public static CHeckersRoomDataBase getDatabase(final Context context) {
        if (cHeckersRoomDataBase == null) {
            synchronized (CHeckersRoomDataBase.class) {
                cHeckersRoomDataBase = Room.databaseBuilder(context.getApplicationContext(),
                        CHeckersRoomDataBase.class, "note_database")
                        .allowMainThreadQueries()
                        .build();
            }
        }
        return cHeckersRoomDataBase;


    }

}

