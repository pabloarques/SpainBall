package com.example.spainball;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PersonajesDao {

    @Query("select * from personajes")
    LiveData<List<Personajes>> getPersonajes();

    @Insert
    void addPersonaje(Personajes personajes);

    @Insert
    void addPersonaje(List<Personajes> personajes);

    @Delete
    void deletePersonaje(Personajes personajes);

    @Query("DELETE FROM personajes")
    void deletePersonaje();
}
