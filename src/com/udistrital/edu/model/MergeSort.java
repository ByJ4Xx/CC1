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


public static ResultadoOrdenamiento ordenarMatriz(Politico[][] matrizPoliticos) {
    comparaciones = 0;
    intercambios = 0;
    long inicio = System.nanoTime();
    ordenarColumnas (ordenarFilas(matrizPoliticos));
    long fin = System.nanoTime();
    double tiempoMs = (fin - inicio) / 1_000_000.0;
    return new ResultadoOrdenamiento(tiempoMs, comparaciones, intercambios);
    }
    
    private static Politico[] mergeSortPorEdad(Politico[] arr, int inicio, int fin) {
        if (inicio < fin) {
            int medio = (inicio + fin) / 2;

            mergeSortPorEdad(arr, inicio, medio);
            mergeSortPorEdad(arr, medio + 1, fin);

            mergePorEdad(arr, inicio, medio, fin);
        }
        return arr;
    }

    private static void mergePorEdad(Politico[] arr, int inicio, int medio, int fin) {
        int size = right - left + 1;
        Politico[] temp = new Politico[size];

        int i = left;       // inicio de la izquierda
        int j = middle + 1; // inicio de la derecha
        int k = 0;          // índice en temp

        while (i <= middle && j <= right) {
            comparaciones++;
            if (arr[i].getEdad() <= arr[j].getEdad()) {
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

    private static Politico[][] ordenarFilas(Politico[][] matrizPoliticos) {
        for (int i = 0; i < matrizPoliticos.length; i++) {
            matrizPoliticos[i] = ordenar(matrizPoliticos[i]);
        }
        return matrizPoliticos;
    }

    private static void ordenarColumnas(Politico[][] matriz) {
        if (matriz == null || matriz.length == 0) return matriz;

        int totalFilas = matriz.length;
        int totalColumnas = matriz[0].length;

        // Iterar sobre cada columna
        for (int col = 0; col < totalColumnas; col++) {
            // Extraer la columna actual como un arreglo unidimensional
            Politico[] columna = new Politico[totalFilas];
            for (int fila = 0; fila < totalFilas; fila++) {
                columna[fila] = matriz[fila][col];
            }

            // Ordenar la columna con MergeSort
            columna = ordenarPorEdad(columna);

            // Devolver los valores ordenados a la matriz original
            for (int fila = 0; fila < totalFilas; fila++) {
                matriz[fila][col] = columna[fila];
            }
        }

        return matriz;
    }

    public Politico[] ordenarPorEdad(Politico[] arregloPoliticos) {
        if (arregloPoliticos.length <= 1) return arregloPoliticos;
        return mergeSortPorEdad(arregloPoliticos, 0, arregloPoliticos.length - 1);
    }

}