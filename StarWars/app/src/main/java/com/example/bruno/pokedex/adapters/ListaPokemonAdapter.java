package com.example.bruno.pokedex.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.bruno.pokedex.R;
import com.example.bruno.pokedex.models.Pokemon;

import java.util.ArrayList;

/**
 * Created by bruno on 15-09-17.
 */

public class ListaPokemonAdapter extends RecyclerView.Adapter<ListaPokemonAdapter.ViewHolder>{

    private ArrayList<Pokemon> dataset;
    private Context context;
    public ListaPokemonAdapter(Context context){
        this.context=context;
        dataset=new ArrayList<>();

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Pokemon p=dataset.get(position);
        holder.nombreTV.setText("-------------\nPersona: "+p.getCaption());
        holder.alturaTV.setText("Altura: "+p.getAltura());
        holder.pesoTV.setText("Peso: "+p.getPeso());
        holder.cabelloTV.setText("Cabello: "+p.getCabello());
        holder.ojosTV.setText("Ojos: "+p.getOjos());
        holder.generoTV.setText("Genero: "+p.getGenero());
    /*    Glide.with(context)
                .load("http://pokeapi.co/media/sprites/pokemon/"+p.getNumber()+".png")
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.fotoIV);
*/
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void adicionarListaPokemon(ArrayList<Pokemon> listaPokemon) {
        dataset.addAll(listaPokemon);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView nombreTV;
        private TextView alturaTV;

        private TextView pesoTV;
        private TextView cabelloTV;
        private TextView generoTV;
        private TextView ojosTV;


        public ViewHolder(View itemView) {
            super(itemView);

            nombreTV=(TextView)itemView.findViewById(R.id.nombreTV);
            alturaTV=(TextView)itemView.findViewById(R.id.alturaTV);
            pesoTV=(TextView)itemView.findViewById(R.id.pesoTV);
            cabelloTV=(TextView)itemView.findViewById(R.id.cabelloTV);
            generoTV=(TextView)itemView.findViewById(R.id.generoTV);
            ojosTV=(TextView)itemView.findViewById(R.id.ojosTV);

        }
    }

}
