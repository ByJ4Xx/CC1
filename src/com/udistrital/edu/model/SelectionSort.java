package com.udistrital.edu.model;

public class SelectionSort {

    private static long comparaciones = 0;
    private static long intercambios = 0;

    public static ResultadoOrdenamiento ordenar(Politico[] arr) {
        comparaciones = 0;
        intercambios = 0;
        int n = arr.length;
        long inicio = System.nanoTime();
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
        long fin = System.nanoTime();
        double tiempoMs = (fin - inicio) / 1000000.0;
        return new ResultadoOrdenamiento(tiempoMs, comparaciones, intercambios);
    }

    public static ResultadoOrdenamiento ordenarMatriz(Politico[][] matriz){
        comparaciones = 0;
        intercambios = 0;
        long inicio = System.nanoTime();
        ordenarColumnas (ordenarFilas(matrizPoliticos));
        long fin = System.nanoTime();
        double tiempoMs = (fin - inicio) / 1_000_000.0;
        
        return new ResultadoOrdenamiento(tiempoMs, comparaciones, intercambios);
    }

    private static void ordenarPorEdad (Politico[] arregloPoliticos){
        comparaciones = 0;
        intercambios = 0;
        int n = arr.length;
        // Recorrido del arreglo para encontrar el mínimo elemento en el resto del arreglo
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Buscar el mínimo en el arreglo sin ordenar
            for (int j = i + 1; j < n; j++) {
                comparaciones++; // Se realiza una comparación
                if (arr[j].getEdad() < arr[minIndex].getEdad()) {
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

            // Ordenar la columna con Bubblesort
            columna = ordenarPorEdad(columna);

            // Devolver los valores ordenados a la matriz original
            for (int fila = 0; fila < totalFilas; fila++) {
                matriz[fila][col] = columna[fila];
            }
        }
    }
}
