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

    public static ResultadoOrdenamiento ordenarMatriz(Politico[][] matriz){
        comparaciones = 0;
        intercambios = 0;
        long inicio = System.nanoTime();
        ordenarColumnas (ordenarFilas(matrizPoliticos));
        long fin = System.nanoTime();
        double tiempoMs = (fin - inicio) / 1_000_000.0;
        
        return new ResultadoOrdenamiento(tiempoMs, comparaciones, intercambios);
    }

    private static void ordenarPorEdad (Politico[] arregloPoliticos) {
        int n = arregloPoliticos.length;
        long comparaciones = 0;
        long intercambios = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                comparaciones++;  // Incrementar comparaciones
                if (arregloPoliticos[j].getEdad() > arregloPoliticos[j + 1].getEdad()) {
                    // Intercambiar
                    Politico temp = arregloPoliticos[j];
                    arregloPoliticos[j] = arregloPoliticos[j + 1];
                    arregloPoliticos[j + 1] = temp;
                    intercambios++;  // Incrementar intercambios
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
