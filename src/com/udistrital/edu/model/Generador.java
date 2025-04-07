package com.udistrital.edu.model;

import java.time.LocalDate;
import java.util.Random;

public class Generador {
    private static final Random random = new Random();
    double promedioTiempoBubble = 0;
    double promedioCompBubble = 0;
    double promedioInterBubble = 0;
    int numArreglos = 0;
    
    public double[] generarAleatorio(int n, double tasaCrecimiento) {
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
                ordenarArreglo(politicos);

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
        return new double [] {(promedioTiempoBubble/numArreglos), (promedioCompBubble/numArreglos), (promedioInterBubble/numArreglos)};
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
                // Valor maximo que me dejo Java con 32 GB: 155469300
                if (n>=152321) {
                	throw new OutOfMemoryError();
                }
            }
        } catch (OutOfMemoryError e) {
            System.err.println("Se ha agotado la memoria al intentar generar un arreglo de tamaño: " + n + "Numero de arrays generados: " + num);
        }
    }
    public void ordenarArreglo(Politico[] politicos) {
    	Politico[] copiaArreglo;
    	double[] forNow;
    	//Ordenar por Bubble
    	copiaArreglo = politicos.clone();
        forNow = BubbleSort.ordenar(copiaArreglo);
        promedioTiempoBubble += forNow[0];
        promedioCompBubble += forNow[1];
        promedioInterBubble += forNow[2];
        /*
        System.out.println("Tiempo: "+ forNow[0] + ", Comparaciones: "+ forNow[1] +", Intercambios: "+ forNow[2]); // Borrame soy solo una traza
        // Ordenar por SelectionSort
        copiaArreglo = politicos.clone();
        forNow = SelectionSort.ordenar(copiaArreglo);
        // Ordenar por InsertionSort
        copiaArreglo = politicos.clone();
        forNow = InsertionSort.ordenar(copiaArreglo);
        // Ordenar por MergeSort
        copiaArreglo = politicos.clone();
        forNow = MergeSort.ordenar(copiaArreglo);
        // Ordenar por QuickSort
        copiaArreglo = politicos.clone();
        forNow = QuickSort.ordenar(copiaArreglo);
        */
    }
}
