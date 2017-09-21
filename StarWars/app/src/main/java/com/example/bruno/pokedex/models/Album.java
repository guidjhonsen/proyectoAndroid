package com.example.bruno.pokedex.models;

import java.util.List;

public class Album {

    private List<Foto> fotos;

    public Album(List<Foto> fotos) {
        this.fotos = fotos;
    }

    public List<Foto> getFotos() {
        return fotos;
    }

    public void setFotos(List<Foto> fotos) {
        this.fotos = fotos;
    }
}
