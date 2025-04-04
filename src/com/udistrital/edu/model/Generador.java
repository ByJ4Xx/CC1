package com.udistrital.edu.model;

import java.time.LocalDate;
import java.util.Random;

public class Generador {
    private static final Random random = new Random();
    
    public static void generarAleatorio(int n, double tasaCrecimiento) {
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
                }
                
                System.out.println("Generado arreglo de tamaño: " + n);
                
                 AlgoritmoOrdenamiento algoritmo;
                long inicio;
                long fin;
                
                //Llamado a los algoritmos
                algoritmo = new BubbleSort();
                Politico[] arregloBubble = politicos.clone();
                System.out.println("\n*****Probando BubbleSort*********");
                inicio = System.currentTimeMillis();
                algoritmo.ordenar(arregloBubble);
                fin = System.currentTimeMillis();
                long tiempoTotal = fin - inicio;
                algoritmo.setTiempoTotal(tiempoTotal);
                System.out.println(algoritmo.toString());

                algoritmo = new InsertionSort();
                Politico[] arregloInsertion = politicos.clone();
                System.out.println("\n********Probando InsertionSort***********");
                inicio = System.currentTimeMillis();
                algoritmo.ordenar(arregloInsertion);
                fin = System.currentTimeMillis();
                tiempoTotal = fin - inicio;
                algoritmo.setTiempoTotal(tiempoTotal);
                System.out.println(algoritmo.toString());

                algoritmo = new SelectionSort();
                Politico[] arregloSelection = politicos.clone();
                System.out.println("\n**********Probando SelectionSort********");
                inicio = System.currentTimeMillis();
                algoritmo.ordenar(arregloSelection);
                fin = System.currentTimeMillis();
                tiempoTotal = fin - inicio;
                algoritmo.setTiempoTotal(tiempoTotal);
                System.out.println(algoritmo.toString());

                algoritmo = new QuickSort();
                Politico[] arregloQuick = politicos.clone();
                System.out.println("\n*******Probando QuickSort*******");
                inicio = System.currentTimeMillis();
                algoritmo.ordenar(arregloQuick);
                fin = System.currentTimeMillis();
                tiempoTotal = fin - inicio;
                algoritmo.setTiempoTotal(tiempoTotal);
                System.out.println(algoritmo.toString());

                algoritmo = new MergeSort();
                Politico[] arregloMerge = politicos.clone();
                System.out.println("\n**********Probando MergeSort*********");
                inicio = System.currentTimeMillis();
                algoritmo.ordenar(arregloMerge);
                fin = System.currentTimeMillis();
                tiempoTotal = fin - inicio;
                algoritmo.setTiempoTotal(tiempoTotal);
                System.out.println(algoritmo.toString());
                
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
    public static void generarOrdenado(int n, double tasaCrecimiento) {
    	int idBase = 1000;
        Politico[] politicos = new Politico[n];
        int dineroBase = 100 + random.nextInt(5000);
        int nuevoDinero;
        
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
                if (n>=155469300) {
                	throw new OutOfMemoryError();
                }
            }
        } catch (OutOfMemoryError e) {
            System.err.println("Se ha agotado la memoria al intentar generar un arreglo de tamaño: " + n + "Numero de arrays generados: " + num);
        }
    }
}
