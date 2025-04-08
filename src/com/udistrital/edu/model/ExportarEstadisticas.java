package com.udistrital.edu.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class ExportarEstadisticas {

    public static void exportar(String nombreArchivo,
                                            EstadisticasOrdenamiento estadisticasAleatorio,
                                            EstadisticasOrdenamiento estadisticasOrdenado,
                                            EstadisticasOrdenamiento estadisticasInverso) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            // Escribir encabezado para cada tipo de arreglo
            escribirSeccion(writer, "Arreglo Aleatorio", estadisticasAleatorio);
            escribirSeccion(writer, "Arreglo Ordenado", estadisticasOrdenado);
            escribirSeccion(writer, "Arreglo Inverso", estadisticasInverso);
            System.out.println("Estadísticas exportadas a " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }
    }

    private static void escribirSeccion(BufferedWriter writer, String titulo, EstadisticasOrdenamiento estadisticas) throws IOException {
        writer.write(titulo);
        writer.newLine();
        writer.write("Tamaño de arreglo,Algoritmo,Tiempo (ms),Comparaciones,Intercambios");
        writer.newLine();

        Map<Integer, Map<String, ResultadoOrdenamiento>> datos = estadisticas.getDatos();
        for (Map.Entry<Integer, Map<String, ResultadoOrdenamiento>> entryTamanio : datos.entrySet()) {
            int tamanio = entryTamanio.getKey();
            Map<String, ResultadoOrdenamiento> algoritmos = entryTamanio.getValue();

            for (Map.Entry<String, ResultadoOrdenamiento> entryAlgoritmo : algoritmos.entrySet()) {
                String algoritmo = entryAlgoritmo.getKey();
                ResultadoOrdenamiento r = entryAlgoritmo.getValue();
                writer.write(String.format("%d,%s,%.4f,%d,%d",
                        tamanio,
                        algoritmo,
                        r.tiempo,
                        r.comparaciones,
                        r.intercambios));
                writer.newLine();
            }
        }

        writer.newLine(); // Separador entre secciones
    }

}