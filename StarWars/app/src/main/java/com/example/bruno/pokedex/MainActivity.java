package com.example.bruno.pokedex;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.bruno.pokedex.adapters.FotosAdapter;
import com.example.bruno.pokedex.models.Album;
import com.example.bruno.pokedex.util.Util;
import com.google.gson.Gson;


public class MainActivity extends AppCompatActivity {

    private static final Gson gson = new Gson();

    private RecyclerView fotosRecyclerView;
    private FotosAdapter fotosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configuración de la lista de fotos
        fotosRecyclerView = (RecyclerView) findViewById(R.id.fotosRecyclerView);
        fotosRecyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        fotosRecyclerView.setLayoutManager(layoutManager);

        fotosAdapter = new FotosAdapter(this);
        fotosRecyclerView.setAdapter(fotosAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();

        cargarDatos();
    }

    private void cargarDatos() {

        String json = Util.leerJSON(this);

        Album album = gson.fromJson(json, Album.class);

        fotosAdapter.setDataset(album.getFotos());
    }
    public void personajes(View view) {
        Intent i = new Intent(this, PersonajeActivity.class );
        startActivity(i);
    }
    public void planetas(View view) {
        Intent i = new Intent(this, PlanetaActivity.class );
        startActivity(i);
    }
    public void naves(View view) {
        Intent i = new Intent(this, NaveActivity.class );
        startActivity(i);
    }
}
