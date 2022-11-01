package com.example.spainball;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Personajes.class}, version = 1)
public abstract class PersonajesDb extends RoomDatabase {

    private static PersonajesDb INSTANCE;

    public static PersonajesDb getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(
                            context.getApplicationContext(),
                            PersonajesDb.class, "db"
                    ).build();
        }
        return INSTANCE;
    }

    public abstract PersonajesDao getPersonajesDao();

}
