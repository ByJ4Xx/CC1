package com.udistrital.edu.model;

public class SelectionSort extends AlgoritmoOrdenamiento {

    public SelectionSort() {
    }

    public SelectionSort(long tiempoTotal, int comparaciones, int intercambios) {
        super(tiempoTotal, comparaciones, intercambios);
    }

    @Override
    public Politico[] ordenar (Politico[] listaPoliticos) {
        int n = listaPoliticos.length;
        for (int i = 0; i < n - 1; i++) {
            int minimo = i;
            for (int j = i + 1; j < n; j++) {
                if (listaPoliticos[j].getDinero() < listaPoliticos[minimo].getDinero()) {
                    minimo = j;
                }
            }

            Politico intercambiador = listaPoliticos[minimo];
            listaPoliticos[minimo] = listaPoliticos[i];
            listaPoliticos[i] = intercambiador;
        }
        return listaPoliticos;
    }
}
