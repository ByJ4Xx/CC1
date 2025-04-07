package com.udistrital.edu.model;

import java.util.Arrays;

public class MergeSort {

    private static int comparaciones = 0;
    private static int intercambios = 0;
    private static double tiempoTotal;

    public static double[] ordenar(Politico[] arr) {
    	long inicio = System.currentTimeMillis();
        mergeSort(arr, 0, arr.length - 1);
        long fin = System.currentTimeMillis();
        tiempoTotal = fin - inicio;
        return new double[] {tiempoTotal, comparaciones, intercambios };
    }

    private static void mergeSort(Politico[] arr, int leftStart, int rightEnd) {
        int middle = (leftStart + rightEnd) / 2;
        mergeSort(arr, leftStart, middle); // Ordena la mitad izquierda
        mergeSort(arr, middle + 1, rightEnd); // Ordena la mitad derecha
        mergeHalves(arr, leftStart, rightEnd); // Fusiona ambas mitades
    }

    private static void mergeHalves(Politico[] arr, int leftStart, int rightEnd) {
        int leftEnd = (rightEnd + leftStart) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        // Fusionamos las mitades de manera ordenada en el mismo arreglo
        Politico[] temp = new Politico[size];  // Arreglo temporal para la fusión
        int tempIndex = 0;

        // Primero, fusionamos los elementos de las mitades
        while (left <= leftEnd && right <= rightEnd) {
            comparaciones++;  // Se ha hecho una comparación
            if (arr[left].getDinero() <= arr[right].getDinero()) {
                temp[tempIndex] = arr[left];
                left++;
            } else {
                temp[tempIndex] = arr[right];
                right++;
                intercambios++; // Se realiza un intercambio
            }
            tempIndex++;
        }

        // Si quedaron elementos en la mitad izquierda, los copiamos
        while (left <= leftEnd) {
            temp[tempIndex] = arr[left];
            left++;
            tempIndex++;
        }

        // Si quedaron elementos en la mitad derecha, los copiamos
        while (right <= rightEnd) {
            temp[tempIndex] = arr[right];
            right++;
            tempIndex++;
        }

        // Copiamos los elementos fusionados de vuelta al arreglo original
        for (int i = 0; i < size; i++) {
            arr[leftStart + i] = temp[i];
        }
    }
}