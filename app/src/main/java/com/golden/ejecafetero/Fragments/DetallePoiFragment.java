package com.golden.ejecafetero.Fragments;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.golden.ejecafetero.Entidades.Poi;
import com.golden.ejecafetero.R;

public class DetallePoiFragment extends Fragment {
    TextView nombre, descripcion;
    ImageView imagen;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detalle_poi_fragment,container,false);
        nombre = view.findViewById(R.id.nombre_detalle);
        descripcion = view.findViewById(R.id.descripcion_larga);
descripcion.setMovementMethod(new ScrollingMovementMethod());

        imagen = view.findViewById(R.id.imagen_detalleid);
        //Crear bundle para recibir el objeto enviado por parametro.
        Bundle objetoPersona = getArguments();
        Poi poi = null;;
        //validacion para verificar si existen argumentos para mostrar
        if(objetoPersona !=null){
            poi = (Poi) objetoPersona.getSerializable("objeto");
            imagen.setImageResource(poi.getImagenid());
            nombre.setText(poi.getNombre());
            descripcion.setText(poi.getDescripcionLarga());
        }
        return view;
    }
}
