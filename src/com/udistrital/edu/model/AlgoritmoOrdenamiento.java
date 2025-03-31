package com.edu.udistrital.modelo;

public abstract class AlgoritmoOrdenamiento {

    private long tiempoTotal;
    private int comparaciones;
    private int intercambios;

    public AlgoritmoOrdenamiento() {
    }

    public AlgoritmoOrdenamiento(long tiempoTotal, int comparaciones, int intercambios) {
        this.tiempoTotal = tiempoTotal;
        this.comparaciones = comparaciones;
        this.intercambios = intercambios;
    }

    public abstract Politico[] ordenar(Politico[] arregloPoliticos);

    public long getTiempoTotal() {
        return tiempoTotal;
    }
    public void setTiempoTotal(long tiempoTotal) {
        this.tiempoTotal = tiempoTotal;
    }

    public int getComparaciones() {
        return comparaciones;
    }

    public void setComparaciones(int comparaciones) {
        this.comparaciones = comparaciones;
    }

    public int getIntercambios() {
        return intercambios;
    }

    public void setIntercambios(int intercambios) {
        this.intercambios = intercambios;
    }
}
