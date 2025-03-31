package com.edu.udistrital.modelo;

public class BubbleSort extends AlgoritmoOrdenamiento {

    public BubbleSort() {
    }

    public BubbleSort(long tiempoTotal, int comparaciones, int intercambios) {
        super(tiempoTotal, comparaciones, intercambios);
    }

    @Override
    public Politico[] ordenar(Politico[] arregloPoliticos) {
        int n = arregloPoliticos.length;
        boolean seIntercambio;
        for (int i = 0; i < n - 1; i++) {
            seIntercambio = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arregloPoliticos[j].getDinero() > arregloPoliticos[j + 1].getDinero()) {
                    // Intercambiar elementos
                    Politico intercambiador = arregloPoliticos[j];
                    arregloPoliticos[j] = arregloPoliticos[j + 1];
                    arregloPoliticos[j + 1] = intercambiador;
                    seIntercambio = true;
                }
            }
            if (!seIntercambio) break;
        }
        return arregloPoliticos;
    }
    }
