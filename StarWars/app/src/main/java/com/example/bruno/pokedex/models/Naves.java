package com.example.bruno.pokedex.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by bruno on 14-09-17.
 */

public class Naves {
    @SerializedName("name")
    private String caption;
    @SerializedName("model")
    private String modelo;
    @SerializedName("manufacturer")
    private String manofactura;
    @SerializedName("starship_class")
    private String clase;
    @SerializedName("passengers")
    private String pasajeros;

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getManofactura() {
        return manofactura;
    }

    public void setManofactura(String manofactura) {
        this.manofactura = manofactura;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(String pasajeros) {
        this.pasajeros = pasajeros;
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
