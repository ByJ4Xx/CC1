package com.edu.udistrital.modelo;

public class QuickSort extends AlgoritmoOrdenamiento {

    public QuickSort() {
    }

    public QuickSort(long tiempoTotal, int comparaciones, int intercambios) {
        super(tiempoTotal, comparaciones, intercambios);
    }

    @Override
    public Politico[] ordenar(Politico[] arregloPoliticos) {
        aplicarRecursividad(arregloPoliticos, 0, arregloPoliticos.length - 1);
        return arregloPoliticos;
    }

    private void aplicarRecursividad(Politico[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = particion(arr, low, high);
            aplicarRecursividad(arr, low, pivotIndex - 1);
            aplicarRecursividad(arr, pivotIndex + 1, high);
        }
    }

    private static int particion(Politico[] arr, int low, int high) {
        Politico pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j].getDinero() <= pivot.getDinero()) {
                i++;
                // Intercambiar elementos
                Politico intercambiador = arr[i];
                arr[i] = arr[j];
                arr[j] = intercambiador;
            }
        }
        // Colocar el pivote en su posición correcta
        Politico intercambiador = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = intercambiador;
        return i + 1;
    }
}
