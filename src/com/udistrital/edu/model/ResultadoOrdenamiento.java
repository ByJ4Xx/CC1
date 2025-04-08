package com.udistrital.edu.model;

public class ResultadoOrdenamiento {
    public double tiempo;
    public int comparaciones;
    public int intercambios;

    public ResultadoOrdenamiento(double tiempo, int comparaciones, int intercambios) {
        this.tiempo = tiempo;
        this.comparaciones = comparaciones;
        this.intercambios = intercambios;
    }
}
