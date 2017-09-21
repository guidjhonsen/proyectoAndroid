package com.example.bruno.pokedex.models;

import com.google.gson.annotations.SerializedName;

public class Foto {

    private String nombre;
    @SerializedName("foto_url")
    private String fotoURL;

    public Foto(String nombre, String fotoURL) {
        this.nombre = nombre;
        this.fotoURL = fotoURL;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFotoURL() {
        return fotoURL;
    }

    public void setFotoURL(String fotoURL) {
        this.fotoURL = fotoURL;
    }
}
