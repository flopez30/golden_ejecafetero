package com.golden.ejecafetero.Fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.golden.ejecafetero.Adaptadores.AdapterPoi;
import com.golden.ejecafetero.Entidades.Poi;
import com.golden.ejecafetero.Interfaces.iComunicaFragments;
import com.golden.ejecafetero.R;

import java.util.ArrayList;

public class PoiFragment extends Fragment {

    //private OnFragmentInteractionListener mListener;


    AdapterPoi adapterPoi;
    RecyclerView recyclerViewPoi;
    ArrayList<Poi> listaPoi;

    EditText txtnombre;

    //Crear referencias para poder realizar la comunicacion entre el fragment detalle
    Activity actividad;
    iComunicaFragments interfaceComunicaFragments;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.poi_fragment,container,false);
        txtnombre = view.findViewById(R.id.txtnombre);

        recyclerViewPoi = view.findViewById(R.id.recyclerView);
        listaPoi = new ArrayList<>();
        cargarLista();
        mostrarData();
        return view;
    }
    public void cargarLista(){
        listaPoi.add(new Poi("Valle del Cocora","un escenario inmejorable para los aficionados a las caminatas en medio de la naturaleza, y respirando el mejor aire puro.","El valle de Cocora es un paisaje natural localizado en la cordillera central de los Andes colombianos, específicamente en el departamento del Quindío, en el área de influencia del Parque nacional natural Los Nevados. Cuenta con algunas poblaciones del árbol nacional de Colombia, la palma de cera del Quindío (Ceroxylon quindiuense), así como de una gran variedad de flora y fauna, mucha de ella en peligro de extinción, protegida bajo el estatus de parque nacional natural. El valle de Cocora se localiza entre los cursos altos del río Quindío, el principal curso fluvial del departamento homónimo, a una altura entre los 1800 y los 2400 metros sobre el nivel del mar. El valle está ubicado a una distancia de 24 kilómetros al noreste de la capital departamental, Armenia, en jurisdicción del municipio de Salento.",R.drawable.valle_cocora));
        listaPoi.add(new Poi("Parque Nacional los Nevados","En esta reserva de 58.300 ha es posible practicar actividades como ciclomontañismo, senderismo, observación de flora y fauna, y escalada en hielo y en roca.","El parque comprende los pisos térmicos correspondientes a frío, páramo, y gélido, por lo cual sus ecosistemas principales son los bosques andinos, páramos y glaciares. Incluye además las cuencas hidrográficas de algunos ríos, como el río Otún, río Quindío, río Totarito, río Molinos, río Azufrado, río Lagunillas, río Campoalegre y río Guali, entre otros.\n" +
                "\n" +
                "En el parque se encuentran localizados los nevados del Ruiz, Tolima, Santa Isabel, el El Cisne, Quindío y el Paramillo de Santa Rosa, siendo los tres primeros Nevados permanentes y los últimos ocasionales, dada la pérdida del hielo glaciar en los mismos.",R.drawable.parque_nevados));

        listaPoi.add(new Poi("PANACA ","disfrutarás un día entero de diversión, emoción y adrenalina, y vivirás emociones fuertes en cada rincón interactuando con más de 4.500 animales","En PANACA se encuentran cultivos, procesos agropecuarios y más de 4.500 animales de la zoología doméstica, con los cuales, niños, jóvenes, adultos y personas mayores, pueden interactuar, a través de sus 8 estaciones y sus exhibiciones, diseñadas específicamente para generar diversión con propósito y aprender haciendo:\n" +
                "\n" +
                "• Estación Ganadería • Estación Especies Menores • Estación Porcicultura • Estación Agroecología • Estación Canina • Estación Sericultura • Estación Equina • Estación Agronomía.\n" +
                "\n" +
                "La mezcla de un gran talento humano, conformado por jinetes acróbatas, entrenadores y trovadores, brindan a los visitantes divertidas exhibiciones:\n" +
                "\n" +
                "• Exhibición El Asombroso Mundo de la Ganadería\n" +
                "\n" +
                "• Exhibición Sin campo no hay ciudad®.\n" +
                "\n" +
                "• Exhibición El Cerdódromo Juan Chancho Monto Yá\n" +
                "\n" +
                "• Exhibición El Amigable Mundo del Perro\n" +
                "\n" +
                "• Exhibición El Espectacular Mundo del Caballo",R.drawable.panaca));
        listaPoi.add(new Poi("Parque del cafe","es un parque temático y de atracciones sobre la cultura del cafe, recorrido cafetales, museo, shows típicos, y 26 atracciones.","Hay atracciones para todas las edades, está la montaña rusa krater, una de las montaña rusas más extremas de Latinoamérica, con giros de 360 y 180 grados, con una caída de 30 metros; para los más pequeños esta la zona de atracciones mecánicas, el lago de las fábulas dedicado al escritor Rafaél Pombo, con sus fábulas más reconocidas.\n" +
                "\n" +
                "En la segunda parte del parque pueden encontrar el teleférico y 25 nuevas atracciones que van unidas a la diversión, arquitectura, gastronomía, historia y pasado cultural del café, en este mágico lugar se puede ver la réplica de 1928 de la Plaza de Bolívar de Armenia, o las fachadas de las 15 casas quindianas con lo que se rescató el patrimonio arquitectónico de la colonización antioqueña.\n" +
                "\n" +
                "Montaña Rusa Yippe\n" +
                "Montaña Rusa Krater\n" +
                "Montaña Acuática\n" +
                "Montaña Rusa\n" +
                "Rápidos\n" +
                "Torre Cumbre\n" +
                "Ciclón\n" +
                "Karts sencillos\n" +
                "Karts Dobles\n" +
                "Teleférico Bambusario\n" +
                "Teleférico Plaza\n" +
                "Barco del café\n" +
                "Tren del Café\n" +
                "Botes chocones\n" +
                "Torre Rin-Rin\n" +
                "Pulpo\n" +
                "Rueda panorámica\n" +
                "Río lento (mini acuática)\n" +
                "Barón Rojo (mini aviones)\n" +
                "Mini chocones\n" +
                "Show El Secreto de la Naturaleza\n" +
                "Show del Café",R.drawable.parque_cafe));
        listaPoi.add(new Poi("Termales Santa Rosa de Cabal","El complejo termal tiene zona de spa y masajes, hotel, restaurante, y cuenta con rutas ecológicas y otras actividades como descenso en cuerdas por la cascada","Las aguas termales ricas en minerales son producto del influjo del sistema volcánico del parque nacional Natural Los Nevados, provenientes de aguas meteóricas que ingresan hasta lo profundo de tierra y son expulsadas hacia el exterior en esta zona, contándose con numerosos afloramientos que son aprovechadas por las infraestructuras del complejo. Brotan de la tierra a una temperatura de 70 ºC y bajan por las cascadas hasta las piscinas termales a 40 ºC.\n" +
                "\n" +
                "El complejo termal tiene zona de spa y masajes, hotel, restaurante, y cuenta con rutas ecológicas y otras actividades como descenso en cuerdas por la cascada.\n" +
                "\n" +
                "A unos 26 km desde los Termales de Santa Rosa de Cabal se encuentra otro conocido complejo termal, los Termales de San Vicente.\n" +
                "\n",R.drawable.termales_santa_rosa));
        listaPoi.add(new Poi("Ukumari zoologico","es un destino temático y de naturaleza en el cual se puede compartir una experiencia salvajemente divertida conociendo más de 60 especies de fauna silvestre y exótica que son representadas por 200 individuos. ","El Bioparque Ukumarí está ubicado  vía Pereira - Risaralda (Colombia).el más grande de su tipo en América Latina, con una extensión de 820.00 metros cuadrados. Dentro de este espacio unas 45 hectáreas estarán dedicadas a varias atracciones, entre las cuales están: la integración del Zoológico Matecaña, un jardín botánico y una clínica veterinaria. Además, un museo antropológico y un museo de ciencias naturales,  especies de África, Asia y América.\n" +
                "\n" +
                "Acuarios, aviarios y atracciones en cuarta dimensión, así como juegos interactivos y escenarios de adrenalina relacionados con la biodiversidad. UKUMARÍ se constituye en la base de la transformación de la sociedad alrededor de la Biodiversidad. El Bioparque y sus biorregiones buscarán cambiar la actitud del hombre frente al planeta, el cuidado de las especies y el Medio Ambiente. Por esa razón, para el turismo colombiano este enfoque diferencial se convierte en la gran apuesta comercial del país, dentro de la actual oferta existente.",R.drawable.ukumari));

    }
    private void mostrarData(){
        recyclerViewPoi.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterPoi = new AdapterPoi(getContext(), listaPoi);
        recyclerViewPoi.setAdapter(adapterPoi);

        adapterPoi.setOnclickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String nombre = listaPoi.get(recyclerViewPoi.getChildAdapterPosition(view)).getNombre();
               txtnombre.setText(nombre);
               Toast.makeText(getContext(), "Seleccionó: "+ listaPoi.get(recyclerViewPoi.getChildAdapterPosition(view)).getNombre(), Toast.LENGTH_SHORT).show();
                //enviar mediante la interface el objeto seleccionado al detalle
                //se envia el objeto completo
                //se utiliza la interface como puente para enviar el objeto seleccionado
                interfaceComunicaFragments.enviarPoi(listaPoi.get(recyclerViewPoi.getChildAdapterPosition(view)));
                //luego en el mainactivity se hace la implementacion de la interface para implementar el metodo enviarpersona
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //esto es necesario para establecer la comunicacion entre la lista y el detalle
        //si el contexto que le esta llegando es una instancia de un activity:
        if(context instanceof Activity){
        //voy a decirle a mi actividad que sea igual a dicho contesto. castin correspondiente:
            this.actividad= (Activity) context;
            ////que la interface icomunicafragments sea igual ese contexto de la actividad:
            interfaceComunicaFragments= (iComunicaFragments) this.actividad;
            //esto es necesario para establecer la comunicacion entre la lista y el detalle
        }

       /* if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //mListener = null;
    }

    /*
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }*/
}
