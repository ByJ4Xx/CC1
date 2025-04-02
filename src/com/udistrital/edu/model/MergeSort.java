package com.udistrital.edu.model;

import java.util.Arrays;

public class MergeSort extends AlgoritmoOrdenamiento {

    public MergeSort() {
    }

    public MergeSort(long tiempoTotal, int comparaciones, int intercambios) {
        super(tiempoTotal, comparaciones, intercambios);
    }
    @Override
    public Politico[] ordenar(Politico[] arregloPoliticos) {
        if (arregloPoliticos.length <= 1) return arregloPoliticos;
        return implementarRecursividad(arregloPoliticos, 0, arregloPoliticos.length - 1);
    }
        private Politico[] implementarRecursividad(Politico[] arr, int inicio, int fin) {
            if (inicio < fin) {
                int medio = (inicio + fin) / 2;

                implementarRecursividad(arr, inicio, medio);
                implementarRecursividad(arr, medio + 1, fin);

                combinar(arr, inicio, medio, fin);
            }
            return arr;
        }

        private static void combinar(Politico[] arr, int inicio, int medio, int fin) {
            int n1 = medio - inicio + 1;
            int n2 = fin - medio;

            Politico[] izquierda = new Politico[n1];
            Politico[] derecha = new Politico[n2];

            System.arraycopy(arr, inicio, izquierda, 0, n1);
            System.arraycopy(arr, medio + 1, derecha, 0, n2);

            int i = 0, j = 0, k = inicio;

            while (i < n1 && j < n2) {
                if (izquierda[i].getDinero() <= derecha[j].getDinero()) {
                    arr[k] = izquierda[i];
                    i++;
                } else {
                    arr[k] = derecha[j];
                    j++;
                }
                k++;
            }

            while (i < n1) {
                arr[k] = izquierda[i];
                i++;
                k++;
            }

            while (j < n2) {
                arr[k] = derecha[j];
                j++;
                k++;
            }
        }
    }