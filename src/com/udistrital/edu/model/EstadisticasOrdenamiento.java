package com.udistrital.edu.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EstadisticasOrdenamiento {
    private Map<String, ResultadoOrdenamiento> acumulados = new HashMap<>();
    private Map<String, Integer> conteos = new HashMap<>();

    public synchronized void agregarResultado(String algoritmo, ResultadoOrdenamiento resultado) {
        acumulados.putIfAbsent(algoritmo, new ResultadoOrdenamiento(0, 0, 0));
        conteos.putIfAbsent(algoritmo, 0);

        ResultadoOrdenamiento acumulado = acumulados.get(algoritmo);
        acumulado.tiempo += resultado.tiempo;
        acumulado.comparaciones += resultado.comparaciones;
        acumulado.intercambios += resultado.intercambios;

        conteos.put(algoritmo, conteos.get(algoritmo) + 1);
    }

    public ResultadoOrdenamiento obtenerPromedio(String algoritmo) {
        ResultadoOrdenamiento acumulado = acumulados.get(algoritmo);
        int conteo = conteos.getOrDefault(algoritmo, 1); // evitar división por 0

        return new ResultadoOrdenamiento(
            acumulado.tiempo / conteo,
            acumulado.comparaciones / conteo,
            acumulado.intercambios / conteo
        );
    }

    public void imprimirPromedios() {
        for (String algoritmo : acumulados.keySet()) {
            ResultadoOrdenamiento promedio = obtenerPromedio(algoritmo);
            System.out.printf("[%s] Promedio -> Tiempo: %.2f ms, Comparaciones: %d, Intercambios: %d%n",
                algoritmo, promedio.tiempo, promedio.comparaciones, promedio.intercambios);
        }
    }
    public Map<String, ResultadoOrdenamiento> getPromedios() {
        Map<String, ResultadoOrdenamiento> promedios = new HashMap<>();
        for (String algoritmo : acumulados.keySet()) {
            promedios.put(algoritmo, obtenerPromedio(algoritmo));
        }
        return promedios;
    }
}
