package com.udistrital.edu.model;

public class InsertionSort {

    public static ResultadoOrdenamiento ordenar(Politico[] arregloPoliticos) {

        long comparaciones=0, intercambios=0;
        long inicio = System.nanoTime();
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
        long comparaciones=0, intercambios=0;
        for (int i = 1; i < arregloPoliticos.length; i++) {
            Politico temp = arregloPoliticos[i];
            int j = i - 1;

            // Aumentamos el contador de comparaciones
            while (j >= 0 && arregloPoliticos[j].getEdad() > temp.getEdad()) {
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
