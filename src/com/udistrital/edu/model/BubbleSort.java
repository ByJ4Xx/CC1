package com.udistrital.edu.model;

public class BubbleSort {

    public static ResultadoOrdenamiento ordenar(Politico[] arregloPoliticos) {
        int n = arregloPoliticos.length;
        int comparaciones=0, intercambios=0;
        boolean seIntercambio;
        long inicio = System.nanoTime();
        for (int i = 0; i < n - 1; i++) {
            seIntercambio = false;
            for (int j = 0; j < n - i - 1; j++) {
                comparaciones++;  // Incrementar el contador de comparaciones
                if (arregloPoliticos[j].getDinero() > arregloPoliticos[j + 1].getDinero()) {
                    // Intercambiar elementos
                    Politico intercambiador = arregloPoliticos[j];
                    arregloPoliticos[j] = arregloPoliticos[j + 1];
                    arregloPoliticos[j + 1] = intercambiador;
                    intercambios++;  // Incrementar el contador de intercambios
                    seIntercambio = true;
                }
            }
            if (!seIntercambio) break;
        }
        long fin = System.nanoTime();
        double tiempoMs = (fin - inicio) / 1_000_000.0;
        /*
        for (int i = 0; i < arregloPoliticos.length; i++) {
            System.out.println(arregloPoliticos[i]);
        }
        */
        return new ResultadoOrdenamiento(tiempoMs, comparaciones, intercambios);
    }
}
