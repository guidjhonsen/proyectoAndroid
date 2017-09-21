package com.example.bruno.pokedex.pokeapi;

import com.example.bruno.pokedex.models.NaveRespuesta;
import com.example.bruno.pokedex.models.PlanetsRespuesta;
import com.example.bruno.pokedex.models.PokemonRespuesta;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by bruno on 14-09-17.
 */

public interface PokeapiService {
    @GET("people")
    Call<PokemonRespuesta> obtenerListaPokemon();

    @GET("planets")
    Call<PlanetsRespuesta> obtenerListaPlanetas();

    @GET("starships")
    Call<NaveRespuesta> obtenerListaNaves();


}
