package com.udistrital.edu.model;

public class InsertionSort {

    public static double[] ordenar(Politico[] arregloPoliticos) {
        double tiempoTotal, comparaciones=0, intercambios=0;
        long inicio = System.currentTimeMillis();
        for (int i = 1; i < arregloPoliticos.length; i++) {
            Politico temp = arregloPoliticos[i];
            int j = i - 1;

            // Aumentamos el contador de comparaciones
            while (j >= 0 && arregloPoliticos[j].getDinero() > temp.getDinero()) {
                comparaciones++; // Comparación realizada
                arregloPoliticos[j + 1] = arregloPoliticos[j];
                j--;
                intercambios++; // Se ha realizado un intercambio
            }
            arregloPoliticos[j + 1] = temp;

            // Si no entró al while, aumentamos las comparaciones que no resultaron en un intercambio
            if (j >= 0) {
                comparaciones++;
            }
        }
        long fin = System.currentTimeMillis();
        tiempoTotal = fin - inicio;
        return new double[] {tiempoTotal, comparaciones, intercambios };
    }
}
