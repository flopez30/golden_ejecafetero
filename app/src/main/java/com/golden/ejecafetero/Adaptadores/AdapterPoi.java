package com.golden.ejecafetero.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.golden.ejecafetero.Entidades.Poi;
import com.golden.ejecafetero.R;

import java.util.ArrayList;

public class AdapterPoi extends RecyclerView.Adapter<AdapterPoi.ViewHolder> implements View.OnClickListener {

    LayoutInflater inflater;
    ArrayList<Poi> model;

    private View.OnClickListener listener;

    public AdapterPoi(Context context, ArrayList<Poi> model){
        this.inflater = LayoutInflater.from(context);
        this.model = model;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.lista_poi, parent, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    public void setOnclickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String nombres = model.get(position).getNombre();
        String descripcionCorta = model.get(position).getDescripcionCorta();
        int imageid = model.get(position).getImagenid();
        holder.nombres.setText(nombres);
        holder.descripcionCorta.setText(descripcionCorta);
        holder.imagen.setImageResource(imageid);
    }


    @Override
    public int getItemCount() {
        return model.size();
    }

    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nombres, descripcionCorta;
        ImageView imagen;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            nombres = itemView.findViewById(R.id.nombres);
            descripcionCorta = itemView.findViewById(R.id.descripcion_corta);
            imagen = itemView.findViewById(R.id.imagen_poi);
        }

    }

}
