package com.golden.ejecafetero.Entidades;

import java.io.Serializable;

public class Poi implements Serializable {
    private String nombre;
    private String descripcioncorta;
    private String descripcionlarga;
    private int imagenid;

    public Poi(){}

    public Poi(String nombre, String descripcioncorta, String descripcionlarga, int imagenid) {
        this.nombre = nombre;
        this.descripcioncorta = descripcioncorta;
        this.descripcionlarga = descripcionlarga;
        this.imagenid = imagenid;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcionCorta() {
        return descripcioncorta;
    }

    public void setDescripcioncorta(String descripcioncorta) {
        this.descripcioncorta = descripcioncorta; }

        public String getDescripcionLarga() {return descripcionlarga;}

        public  void setDescripcionlarga(String descripcionlarga) {
         this.descripcionlarga = descripcionlarga;  }

    public int getImagenid() {
        return imagenid;
    }

    public void setImagenid(int imagenid) {
        this.imagenid = imagenid;
    }
}
