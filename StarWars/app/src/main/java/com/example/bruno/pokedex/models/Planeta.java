package com.example.bruno.pokedex.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by bruno on 14-09-17.
 */

public class Planeta {
    @SerializedName("name")
    private String caption;
    @SerializedName("rotation_period")
    private String rotacion;
    @SerializedName("orbital_period")
    private String orbita;
    @SerializedName("diameter")
    private String diametro;
    @SerializedName("climate")
    private String clima;
    @SerializedName("gravity")
    private String gravedad;
    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getRotacion() {
        return rotacion;
    }

    public void setRotacion(String rotacion) {
        this.rotacion = rotacion;
    }

    public String getOrbita() {
        return orbita;
    }

    public void setOrbita(String orbita) {
        this.orbita = orbita;
    }

    public String getDiameter() {
        return diametro;
    }

    public void setDiameter(String diameter) {
        this.diametro = diameter;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public String getGravedad() {
        return gravedad;
    }

    public void setGravedad(String gravedad) {
        this.gravedad = gravedad;
    }
    /*
    private int number;
    private String name;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getNumber() {
        String[] urlPartes=url.split("/");
        return Integer.parseInt(urlPartes[urlPartes.length - 1]);
    }

    public void setNumber(int number) {
        this.number = number;
    }*/
}
