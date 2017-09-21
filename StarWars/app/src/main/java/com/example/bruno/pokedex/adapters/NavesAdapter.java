package com.example.bruno.pokedex.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bruno.pokedex.R;
import com.example.bruno.pokedex.models.Naves;
import com.example.bruno.pokedex.models.Planeta;

import java.util.ArrayList;

/**
 * Created by bruno on 15-09-17.
 */

public class NavesAdapter extends RecyclerView.Adapter<NavesAdapter.ViewHolder>{

    private ArrayList<Naves> dataset;
    private Context context;
    public NavesAdapter(Context context){
        this.context=context;
        dataset=new ArrayList<>();

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_naves, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Naves p=dataset.get(position);
        holder.nombreTV.setText("-------------\nNave: "+p.getCaption());
        holder.manofacturaTV.setText("Manofactura: "+p.getManofactura());
        holder.pasajerosTV.setText("Pasajeros: "+p.getPasajeros());
        holder.claseTV.setText("Clase: "+p.getClase());
        holder.modeloTV.setText("Modelo: "+p.getModelo());
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

    public void adicionarListaNaves(ArrayList<Naves> listaNaves) {
        dataset.addAll(listaNaves);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView nombreTV;
        private TextView modeloTV;
        private TextView manofacturaTV;
        private TextView claseTV;
        private TextView pasajerosTV;


        public ViewHolder(View itemView) {
            super(itemView);

            nombreTV=(TextView)itemView.findViewById(R.id.nombreTV);
            modeloTV=(TextView)itemView.findViewById(R.id.modeloTV);
            manofacturaTV=(TextView)itemView.findViewById(R.id.manufacturaTV);
            claseTV=(TextView)itemView.findViewById(R.id.claseTV);
            pasajerosTV=(TextView)itemView.findViewById(R.id.pasajeroTV);
        }
    }

}
