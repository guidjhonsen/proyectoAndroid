package com.example.bruno.pokedex.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bruno.pokedex.R;
import com.example.bruno.pokedex.models.Planeta;

import java.util.ArrayList;

/**
 * Created by bruno on 15-09-17.
 */

public class PlanetsAdapter extends RecyclerView.Adapter<PlanetsAdapter.ViewHolder>{

    private ArrayList<Planeta> dataset;
    private Context context;
    public PlanetsAdapter(Context context){
        this.context=context;
        dataset=new ArrayList<>();

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_planeta, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Planeta p=dataset.get(position);
        holder.nombreTV.setText("-------------\nPlaneta: "+p.getCaption());
        holder.diametroTV.setText("Diametro: "+p.getDiameter());
        holder.climaTV.setText("Clima: "+p.getClima());
        holder.gravedadTV.setText("Gravedad: "+p.getGravedad());
        holder.orbitaTV.setText("Orbita: "+p.getOrbita());
        holder.rotacionTV.setText("Rotacion: "+p.getRotacion());
    /*    Glide.with(context)
                .load("http://pokeapi.co/media/sprites/Planeta/"+p.getNumber()+".png")
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

    public void adicionarListaPlaneta(ArrayList<Planeta> listaPlaneta) {
        dataset.addAll(listaPlaneta);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView nombreTV;
        private TextView rotacionTV;
        private TextView orbitaTV;

        private TextView diametroTV;
        private TextView climaTV;
        private TextView gravedadTV;


        public ViewHolder(View itemView) {
            super(itemView);

            nombreTV=(TextView)itemView.findViewById(R.id.nombreTV);
            rotacionTV=(TextView)itemView.findViewById(R.id.rotacionTV);
            orbitaTV=(TextView)itemView.findViewById(R.id.orbitaTV);
            climaTV=(TextView)itemView.findViewById(R.id.climaTV);
            diametroTV=(TextView)itemView.findViewById(R.id.diametroTV);
            gravedadTV=(TextView)itemView.findViewById(R.id.gravedadTV);
        }
    }

}
