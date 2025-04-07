package com.udistrital.edu.model;

public class SelectionSort {

    private static int comparaciones = 0;
    private static int intercambios = 0;
    private static double tiempoTotal;

    public static double[] ordenar(Politico[] arr) {
        int n = arr.length;
        long inicio = System.currentTimeMillis();
        // Recorrido del arreglo para encontrar el mínimo elemento en el resto del arreglo
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Buscar el mínimo en el arreglo sin ordenar
            for (int j = i + 1; j < n; j++) {
                comparaciones++; // Se realiza una comparación
                if (arr[j].getDinero() < arr[minIndex].getDinero()) {
                    minIndex = j;
                }
            }

            // Si encontramos un elemento más pequeño, lo intercambiamos
            if (minIndex != i) {
                intercambios++; // Se realiza un intercambio
                Politico temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        long fin = System.currentTimeMillis();
        tiempoTotal = fin - inicio;
        return new double[] {tiempoTotal, comparaciones, intercambios };
    }
}
