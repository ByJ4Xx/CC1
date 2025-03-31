package com.edu.udistrital.modelo;

public class InsertionSort extends AlgoritmoOrdenamiento{
    public InsertionSort() {
    }

    public InsertionSort(long tiempoTotal, int comparaciones, int intercambios) {
        super(tiempoTotal, comparaciones, intercambios);
    }

    @Override
    public Politico[] ordenar (Politico[] listaPoliticos) {
        int n = listaPoliticos.length;
        for (int i = 1; i < n; i++) {
            long indice = listaPoliticos[i].getDinero();
            int j = i - 1;

            while (j >= 0 && listaPoliticos[j].getDinero() > indice) {
                listaPoliticos[j + 1] = listaPoliticos[j];
                j--;
            }
            listaPoliticos[j + 1].setDinero(indice);
        }
        return listaPoliticos;
    }

}
