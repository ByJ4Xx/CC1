package com.udistrital.edu.model;

public class QuickSort {

    private static int comparaciones = 0;
    private static int intercambios = 0;

    public static ResultadoOrdenamiento ordenar(Politico[] arr) {
        comparaciones = 0;
        intercambios = 0;
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
        // Elegir índice aleatorio y moverlo al final
        int randomIndex = low + (int)(Math.random() * (high - low + 1));
        Politico temp = arr[randomIndex];
        arr[randomIndex] = arr[high];
        arr[high] = temp;

        Politico pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            comparaciones++;
            if (arr[j].getDinero() <= pivot.getDinero()) {
                i++;
                intercambios++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        intercambios++;
        temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
