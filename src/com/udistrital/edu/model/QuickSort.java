package com.udistrital.edu.model;

public class QuickSort {

    private static long comparaciones = 0;
    private static long intercambios = 0;

    public static ResultadoOrdenamiento ordenar(Politico[] arr) {
        comparaciones = 0;
        intercambios = 0;
    	long inicio = System.nanoTime();
        quickSort(arr, 0, arr.length - 1);
        long fin = System.nanoTime();
        double tiempoMs = (fin - inicio) / 1000000.0;
        return new ResultadoOrdenamiento(tiempoMs, comparaciones, intercambios);
    }

     public static ResultadoOrdenamiento ordenarMatriz(Politico[][] matriz) {
        comparaciones = 0;
        intercambios = 0;
    	long inicio = System.nanoTime();
        ordenarColumnas(ordenarFilas(matriz));
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

    private static void quickSortEdad(Politico[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partitionEdad(arr, low, high);
            quickSortEdad(arr, low, pivotIndex - 1);
            quickSortEdad(arr, pivotIndex + 1, high);
        }
    }

    private static int partitionEdad(Politico[] arr, int low, int high) {
        // Pivote aleatorio
        int randomIndex = low + (int)(Math.random() * (high - low + 1));
        Politico temp = arr[randomIndex];
        arr[randomIndex] = arr[high];
        arr[high] = temp;

        Politico pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            comparaciones++;
            if (arr[j].getEdad() <= pivot.getEdad()) {
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

    public static Politico[][] ordenarFilas (Politico[][] matriz){
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

            // Ordenar la columna con Quicksort
            columna = quickSortEdad(columna);

            // Devolver los valores ordenados a la matriz original
            for (int fila = 0; fila < totalFilas; fila++) {
                matriz[fila][col] = columna[fila];
            }
        }
    }
}
