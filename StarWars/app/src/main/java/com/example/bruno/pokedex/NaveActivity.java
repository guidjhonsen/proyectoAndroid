package com.example.bruno.pokedex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.bruno.pokedex.adapters.NavesAdapter;
import com.example.bruno.pokedex.adapters.PlanetsAdapter;
import com.example.bruno.pokedex.models.NaveRespuesta;
import com.example.bruno.pokedex.models.Naves;
import com.example.bruno.pokedex.models.Planeta;
import com.example.bruno.pokedex.models.PlanetsRespuesta;
import com.example.bruno.pokedex.pokeapi.PokeapiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NaveActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private static final String TAG="POKEDEX";
    private RecyclerView recyclerView;
    private NavesAdapter listaNAvesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nave_main);

        recyclerView=(RecyclerView) findViewById(R.id.recyclerView);
        listaNAvesAdapter=new NavesAdapter(this);
        recyclerView.setAdapter(listaNAvesAdapter);
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

        Call<NaveRespuesta> naveRespuestaCall=service.obtenerListaNaves();
        naveRespuestaCall.enqueue(new Callback<NaveRespuesta>() {
            @Override
            public void onResponse(Call<NaveRespuesta> call, Response<NaveRespuesta> response) {
                if (response.isSuccessful()){
                    NaveRespuesta naveRespuesta=response.body();
                    ArrayList<Naves> listaNaves= naveRespuesta.getResults();

                    for (int i=0;i<listaNaves.size();i++){
                        Naves p=listaNaves.get(i);
                        Log.i(TAG, "Pokemon: "+p.getCaption());
                    }


                    listaNAvesAdapter.adicionarListaNaves(listaNaves);


                }else{
                    Log.e(TAG, "onResponse: "+response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<NaveRespuesta> call, Throwable t) {

            }
        });

    }
}
