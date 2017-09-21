package com.example.bruno.pokedex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.bruno.pokedex.adapters.PlanetsAdapter;
import com.example.bruno.pokedex.models.Planeta;
import com.example.bruno.pokedex.models.PlanetsRespuesta;

import com.example.bruno.pokedex.pokeapi.PokeapiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PlanetaActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private static final String TAG="POKEDEX";
    private RecyclerView recyclerView;
    private PlanetsAdapter listaPlanetasAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.planeta_main);

        recyclerView=(RecyclerView) findViewById(R.id.recyclerView);
        listaPlanetasAdapter=new PlanetsAdapter(this);
        recyclerView.setAdapter(listaPlanetasAdapter);
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

        Call<PlanetsRespuesta> planetsRespuestaCall=service.obtenerListaPlanetas();
        planetsRespuestaCall.enqueue(new Callback<PlanetsRespuesta>() {
            @Override
            public void onResponse(Call<PlanetsRespuesta> call, Response<PlanetsRespuesta> response) {
                if (response.isSuccessful()){
                    PlanetsRespuesta planetaRespuesta=response.body();
                    ArrayList<Planeta> listaPlanetas= planetaRespuesta.getResults();

                    for (int i=0;i<listaPlanetas.size();i++){
                        Planeta p=listaPlanetas.get(i);
                        Log.i(TAG, "Pokemon: "+p.getCaption());
                    }


                    listaPlanetasAdapter.adicionarListaPlaneta(listaPlanetas);


                }else{
                    Log.e(TAG, "onResponse: "+response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<PlanetsRespuesta> call, Throwable t) {

            }
        });

    }
}
