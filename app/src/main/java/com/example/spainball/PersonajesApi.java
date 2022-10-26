package com.example.spainball;

import android.util.Log;

import com.example.spainball.HttpsUtils;
import com.example.spainball.Personajes;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class PersonajesApi {

    ArrayList<Personajes> getPokemon(){
    String url = "https://ydbbirhldzcaggqvhltp.supabase.co/rest/v1/personajes?apikey=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InlkYmJpcmhsZHpjYWdncXZobHRwIiwicm9sZSI6ImFub24iLCJpYXQiOjE2NjY2OTUxNTAsImV4cCI6MTk4MjI3MTE1MH0.UMO3HMblINIkVW20KROL9-KNvZfBZAko0F_KmcX3-4k";

    try{
        String result = HttpsUtils.get(url);
        JSONArray results = new JSONArray(result);

    ArrayList<Personajes> personajeArray = new ArrayList<>();
    for(int i=0; i <results.length(); i++){
        JSONObject personajeJson = results.getJSONObject(i);
        Personajes personaje = new Personajes();

        personaje.setNombre(personajeJson.getString("nombre"));
        personaje.setRaza(personajeJson.getString("raza"));
        personaje.setNivelPoder(personajeJson.getInt("nivel_poder"));
        String sprites = personajeJson.getString("imagen");
        personaje.setImagen(sprites);

        personajeArray.add(personaje);
       // Log.e("PRUEBA", personaje.getNombre());
    }

        return personajeArray;

     }catch(Exception ex){
        System.out.println(ex.getMessage());
    }

        return null;
    }
}
