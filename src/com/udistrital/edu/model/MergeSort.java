package com.udistrital.edu.model;

public class MergeSort {

    private static long comparaciones = 0;
    private static long intercambios = 0;

    public static ResultadoOrdenamiento ordenar(Politico[] arr) {
        comparaciones = 0;
        intercambios = 0;
        long inicio = System.nanoTime();
        mergeSort(arr, 0, arr.length - 1);
        long fin = System.nanoTime();
        double tiempoMs = (fin - inicio) / 1_000_000.0;
        return new ResultadoOrdenamiento(tiempoMs, comparaciones, intercambios);
    }

    private static void mergeSort(Politico[] arr, int left, int right) {
        if (left >= right) return;

        int middle = left + (right - left) / 2;
        mergeSort(arr, left, middle);
        mergeSort(arr, middle + 1, right);
        merge(arr, left, middle, right);
    }

    private static void merge(Politico[] arr, int left, int middle, int right) {
        int size = right - left + 1;
        Politico[] temp = new Politico[size];

        int i = left;       // inicio de la izquierda
        int j = middle + 1; // inicio de la derecha
        int k = 0;          // índice en temp

        while (i <= middle && j <= right) {
            comparaciones++;
            if (arr[i].getDinero() <= arr[j].getDinero()) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                intercambios++;
            }
        }

        while (i <= middle) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // Copiar de vuelta a arr
        for (int m = 0; m < size; m++) {
            arr[left + m] = temp[m];
        }
    }
}
