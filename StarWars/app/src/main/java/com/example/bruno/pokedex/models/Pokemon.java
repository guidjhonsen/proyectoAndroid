package com.example.bruno.pokedex.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by bruno on 14-09-17.
 */

public class Pokemon {
    @SerializedName("name")
    private String caption;
    @SerializedName("height")
    private String altura;
    @SerializedName("mass")
    private String peso;
    @SerializedName("hair_color")
    private String cabello;
    @SerializedName("eye_color")
    private String ojos;
    @SerializedName("gender")
    private String genero;

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getCabello() {
        return cabello;
    }

    public void setCabello(String cabello) {
        this.cabello = cabello;
    }

    public String getOjos() {
        return ojos;
    }

    public void setOjos(String ojos) {
        this.ojos = ojos;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
