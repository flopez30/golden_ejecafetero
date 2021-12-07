package com.golden.ejecafetero.Interfaces;

import com.golden.ejecafetero.Entidades.Poi;

public interface iComunicaFragments {
    //esta interface se encarga de realizar la comunicacion entre la lista de personas y el detalle
    public void enviarPoi(Poi poi); //se transportara un objeto de tipo poi
    //(En la clase Poi se implementa Serializable para poder transportar un objeteo a otro)
}
