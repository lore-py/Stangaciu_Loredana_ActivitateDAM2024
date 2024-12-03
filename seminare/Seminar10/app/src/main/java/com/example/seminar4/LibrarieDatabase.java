package com.example.seminar4;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Librarie.class}, version = 1, exportSchema = false)
public abstract class LibrarieDatabase extends RoomDatabase {

    public abstract LibrarieDao librarieDao();

    private static volatile LibrarieDatabase INSTANCE;

    public static LibrarieDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (LibrarieDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    LibrarieDatabase.class, "librarie_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
