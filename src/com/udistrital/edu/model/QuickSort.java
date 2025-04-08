package com.udistrital.edu.model;

public class QuickSort {

    private static int comparaciones = 0;
    private static int intercambios = 0;

    public static ResultadoOrdenamiento ordenar(Politico[] arr) {
    	long inicio = System.nanoTime();
        quickSort(arr, 0, arr.length - 1);
        long fin = System.nanoTime();
        double tiempoMs = (fin - inicio) / 1000000.0;
        return new ResultadoOrdenamiento(tiempoMs, comparaciones, intercambios);
    }

    private static void quickSort(Politico[] arr, int low, int high) {
        if (low < high) {
            // Particion y obtenemos el indice del pivote
            int pivotIndex = partition(arr, low, high);
            // Ordenamos las sublistas de forma recursiva
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(Politico[] arr, int low, int high) {
        // Elegimos el ultimo elemento como pivote
        Politico pivot = arr[high];
        int i = low - 1;

        // Comenzamos la comparacion desde el inicio hasta el penultimo elemento
        for (int j = low; j < high; j++) {
            comparaciones++; // Se hace una comparacion
            if (arr[j].getDinero() <= pivot.getDinero()) {
                i++;
                intercambios++; // Realizamos un intercambio
                // Intercambiamos los elementos arr[i] y arr[j]
                Politico temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Colocamos el pivote en su posicion final
        Politico temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        intercambios++; // Intercambio del pivote con su posicion correcta
        return i + 1; // Indice de la posicion del pivote
    }
}
