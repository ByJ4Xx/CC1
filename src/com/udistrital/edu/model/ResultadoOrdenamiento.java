package com.udistrital.edu.model;

public class ResultadoOrdenamiento {
    public double tiempo;
    public long comparaciones;
    public long intercambios;

    public ResultadoOrdenamiento(double tiempo, long comparaciones, long intercambios) {
        this.tiempo = tiempo;
        this.comparaciones = comparaciones;
        this.intercambios = intercambios;
    }
}
