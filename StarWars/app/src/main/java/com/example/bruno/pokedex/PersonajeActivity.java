package com.example.bruno.pokedex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.bruno.pokedex.adapters.ListaPokemonAdapter;
import com.example.bruno.pokedex.models.Pokemon;
import com.example.bruno.pokedex.models.PokemonRespuesta;
import com.example.bruno.pokedex.pokeapi.PokeapiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PersonajeActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private static final String TAG="POKEDEX";
    private RecyclerView recyclerView;
    private ListaPokemonAdapter listaPokemonAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personaje_main);

        recyclerView=(RecyclerView) findViewById(R.id.recyclerView);
        listaPokemonAdapter=new ListaPokemonAdapter(this);
        recyclerView.setAdapter(listaPokemonAdapter);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager=new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(layoutManager);

        retrofit=new Retrofit.Builder()
                .baseUrl("https://swapi.co/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        obtenerDatos();

    }
    public void obtenerDatos(){
        PokeapiService service=retrofit.create(PokeapiService.class);

        Call<PokemonRespuesta> pokemonRespuestaCall=service.obtenerListaPokemon();

        pokemonRespuestaCall.enqueue(new Callback<PokemonRespuesta>() {
            @Override
            public void onResponse(Call<PokemonRespuesta> call, Response<PokemonRespuesta> response) {
                if (response.isSuccessful()){
                    PokemonRespuesta pokemonRespuesta=response.body();
                    ArrayList<Pokemon> listaPokemon= pokemonRespuesta.getResults();

                    for (int i=0;i<listaPokemon.size();i++){
                        Pokemon p=listaPokemon.get(i);
                        Log.i(TAG, "Pokemon: "+p.getCaption());
                    }


                    listaPokemonAdapter.adicionarListaPokemon(listaPokemon);


                }else{
                    Log.e(TAG, "onResponse: "+response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<PokemonRespuesta> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.getMessage());
            }
        });
    }
}
