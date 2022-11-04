package com.example.spainball;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PersonajesViewModel extends AndroidViewModel {
    private final Application app;
    private final PersonajesDb db;
    private final PersonajesDao personajesDao;
    private LiveData<List<Personajes>> personajes;

    public PersonajesViewModel(@NonNull Application application) {
        super(application);
        this.app = application;
        this.db = PersonajesDb.getDatabase(this.app);
        this.personajesDao =this.db.getPersonajesDao();

    }

        public LiveData<List<Personajes>> getPersonajes() {

        return personajesDao.getPersonajes();
    }

    public void refresh(){
        Toast.makeText(getApplication().getApplicationContext(), "Actualizando...", Toast.LENGTH_LONG).show();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(
                app.getApplicationContext()
        );
        ExecutorService executor = Executors.newSingleThreadExecutor();

        executor.execute(() ->{
            PersonajesApi api = new PersonajesApi();
            ArrayList<Personajes> personajes = api.getPersonaje();
            this.personajesDao.deletePersonaje();
            this.personajesDao.addPersonaje(personajes);
        });

    }


}
