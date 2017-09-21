package com.example.bruno.pokedex.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bruno.pokedex.R;
import com.example.bruno.pokedex.models.Foto;

import java.util.ArrayList;
import java.util.List;


public class FotosAdapter extends RecyclerView.Adapter<FotosAdapter.ViewHolder> {

    private List<Foto> dataset;
    private Context context;

    public FotosAdapter(Context context) {
        this.context = context;
        this.dataset = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_foto, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Foto f = dataset.get(position);
        holder.nombreTextView.setText(f.getNombre());

        // TODO: Usar Glide para descargar la imagen y colocarla en el fotoImageView
        Glide.with(context)
                .load(f.getFotoURL())
                .into(holder.fotoImageView);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView fotoImageView;
        private TextView nombreTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            fotoImageView = (ImageView) itemView.findViewById(R.id.fotoImageView);
            nombreTextView = (TextView) itemView.findViewById(R.id.nombreTextView);
        }
    }


    public void setDataset(List<Foto> fotos) {
        if (fotos != null) {
            dataset.addAll(fotos);
        }
        notifyDataSetChanged();
    }

}
