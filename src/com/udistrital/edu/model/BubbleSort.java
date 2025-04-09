package com.udistrital.edu.model;

public class BubbleSort {

    public static ResultadoOrdenamiento ordenar(Politico[] arregloPoliticos) {
        int n = arregloPoliticos.length;
        long comparaciones = 0;
        long intercambios = 0;
        long inicio = System.nanoTime();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                comparaciones++;  // Incrementar comparaciones
                if (arregloPoliticos[j].getDinero() > arregloPoliticos[j + 1].getDinero()) {
                    // Intercambiar
                    Politico temp = arregloPoliticos[j];
                    arregloPoliticos[j] = arregloPoliticos[j + 1];
                    arregloPoliticos[j + 1] = temp;
                    intercambios++;  // Incrementar intercambios
                }
            }
        }

        long fin = System.nanoTime();
        double tiempoMs = (fin - inicio) / 1_000_000.0;

        return new ResultadoOrdenamiento(tiempoMs, comparaciones, intercambios);
    }
}
