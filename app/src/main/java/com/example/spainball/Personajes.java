package com.example.spainball;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Personajes implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private Integer id;
    private String nombre;
    private String raza;
    private Integer nivelPoder;
    private String imagen;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Integer getNivelPoder() {
        return nivelPoder;
    }

    public void setNivelPoder(Integer nivelPoder) {
        this.nivelPoder = nivelPoder;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @NonNull
    @Override
    public String toString() {
        return "Personajes{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", raza='" + raza + '\'' +
                ", nivelPoder=" + nivelPoder +
                ", imagen='" + imagen + '\'' +
                '}';
    }
}
