package com.udistrital.edu.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generador {
    private static final Random random = new Random();
    double promedioTiempoBubble = 0;
    double promedioCompBubble = 0;
    double promedioInterBubble = 0;
    int numArreglos = 0;
    
    public void generarAleatorio(int n, double tasaCrecimiento, EstadisticasOrdenamiento estadisticas) {
        int idBase = 1000;
        int num = 0;
        Politico[] politicos = null;
        
        try {
            while (true) {
                politicos = new Politico[n];
                int dineroBase = 100 + random.nextInt(1_000_000 - 100);
                LocalDate fechaBase = LocalDate.of(random.nextInt(60) + 1940, random.nextInt(12) + 1, random.nextInt(28) + 1);
                Politico prototipo = new Politico(idBase, dineroBase, fechaBase);
                
                for (int i = 0; i < n; i++) {
                	politicos[i] = prototipo.clone();
                	politicos[i].setId(idBase + i);
                	politicos[i].setDinero(100 + random.nextInt(1_000_000 - 100));
                    politicos[i].setFechaNacimiento(LocalDate.of(random.nextInt(60) + 1940, random.nextInt(12) + 1, random.nextInt(28) + 1));
                    //System.out.println(politicos[i]);
                }
                
                System.out.println("Generado arreglo de tamaño: " + n);
                numArreglos += 1;
                
                // Llamamos al metodo para que los ordene
                ordenarArreglo(politicos, estadisticas);

                // Eliminar referencia al arreglo
                politicos = null;
                System.gc(); // Liberar memoria
                
                n = (int) Math.round(n * tasaCrecimiento);
                if (n>=152321) {
                	throw new OutOfMemoryError();
                }
            }
        } catch (OutOfMemoryError e) {
            System.err.println("Se ha agotado la memoria al intentar generar un arreglo de tamaño: " + n);
        }
    }
    public static void generarOrdenado(int n, double tasaCrecimiento) {
    	int idBase = 1000;
        Politico[] politicos = new Politico[n];
        int dineroBase = 100 + random.nextInt(5000);
        
        try {
            while (true) {
                politicos = new Politico[n];
                LocalDate fechaBase = LocalDate.of(random.nextInt(60) + 1940, random.nextInt(12) + 1, random.nextInt(28) + 1);
                Politico prototipo = new Politico(idBase, dineroBase, fechaBase);
                
                for (int i = 0; i < n; i++) {
                	politicos[i] = prototipo.clone();
                	politicos[i].setId(idBase + i);
                	politicos[i].setDinero(dineroBase);
                	dineroBase += random.nextInt(5000);
                    politicos[i].setFechaNacimiento(LocalDate.of(random.nextInt(60) + 1940, random.nextInt(12) + 1, random.nextInt(28) + 1));
                    
                    System.out.println(politicos[i]);
                }
                
                System.out.println("Generado arreglo de tamaño: " + n);
                
                // Burbuja(poltiicos)
                // ElQueSigue(Politicos)
                
                // Eliminar referencia al arreglo
                politicos = null;
                System.gc(); // Liberar memoria
                
                n = (int) Math.round(n * tasaCrecimiento);
                if (n>=155469300) {
                	throw new OutOfMemoryError();
                }
            }
        } catch (OutOfMemoryError e) {
            System.err.println("Se ha agotado la memoria al intentar generar un arreglo de tamaño: " + n);
        }
    }
    public static void generarInverso(int n, double tasaCrecimiento) {
    	int idBase = 1000;
        Politico[] politicos = new Politico[n];
        int dineroBase = 100 + random.nextInt(5000);
        int num = 0;
        try {
            while (true) {
            	if (n>10) {
                	throw new OutOfMemoryError();
                }
                politicos = new Politico[n];
                num +=1;
                LocalDate fechaBase = LocalDate.of(random.nextInt(60) + 1940, random.nextInt(12) + 1, random.nextInt(28) + 1);
                Politico prototipo = new Politico(idBase, dineroBase, fechaBase);
                
                for (int i = n - 1; i >= 0; i--) {
                	politicos[i] = prototipo.clone();
                	politicos[i].setId(idBase + i);
                	politicos[i].setDinero(dineroBase);
                	dineroBase += random.nextInt(5000);
                    politicos[i].setFechaNacimiento(LocalDate.of(random.nextInt(60) + 1940, random.nextInt(12) + 1, random.nextInt(28) + 1));
                    
                    //System.out.println(politicos[i]);
                }
                
                System.out.println("Generado arreglo de tamaño: " + n);
                
                // Burbuja(poltiicos)
                // ElQueSigue(Politicos)
                
                // Eliminar referencia al arreglo
                politicos = null;
                System.gc(); // Liberar memoria
                idBase = 1000;
                n = (int) Math.round(n * tasaCrecimiento);
                // Valor maximo que me dejo Java con 32 GB: 155469300
                if (n>=152321) {
                	throw new OutOfMemoryError();
                }
            }
        } catch (OutOfMemoryError e) {
            System.err.println("Se ha agotado la memoria al intentar generar un arreglo de tamaño: " + n + "Numero de arrays generados: " + num);
        }
    }
    public void ordenarArreglo(Politico[] politicos, EstadisticasOrdenamiento estadisticas) {
        List<Thread> hilos = new ArrayList<>();

        Runnable tareaBubble = () -> {
            Politico[] copia = clonarArreglo(politicos);
            estadisticas.agregarResultado("BubbleSort", BubbleSort.ordenar(copia));
            copia = null;
        };
        Runnable tareaSelection = () -> {
            Politico[] copia = clonarArreglo(politicos);
            estadisticas.agregarResultado("SelectionSort", SelectionSort.ordenar(copia));
            copia = null;
        };
        Runnable tareaInsertion = () -> {
            Politico[] copia = clonarArreglo(politicos);
            estadisticas.agregarResultado("InsertionSort", InsertionSort.ordenar(copia));
            copia = null;
        };
        Runnable tareaMerge = () -> {
            Politico[] copia = clonarArreglo(politicos);
            estadisticas.agregarResultado("MergeSort", MergeSort.ordenar(copia));
            copia = null;
        };
        Runnable tareaQuick = () -> {
            Politico[] copia = clonarArreglo(politicos);
            estadisticas.agregarResultado("QuickSort", QuickSort.ordenar(copia));
            copia = null;
        };

        hilos.add(new Thread(tareaBubble));
        hilos.add(new Thread(tareaSelection));
        hilos.add(new Thread(tareaInsertion));
        hilos.add(new Thread(tareaMerge));
        hilos.add(new Thread(tareaQuick));

        // Iniciar todos los hilos
        for (Thread hilo : hilos) {
            hilo.start();
        }

        // Esperar a que todos terminen
        for (Thread hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.gc(); // Limpiar
    }
    private Politico[] clonarArreglo(Politico[] original) {
        Politico[] copia = new Politico[original.length];
        for (int i = 0; i < original.length; i++) {
            copia[i] = original[i].clone();
        }
        return copia;
    }
}
