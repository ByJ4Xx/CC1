package com.udistrital.edu.controller;

import com.udistrital.edu.model.EstadisticasOrdenamiento;
import com.udistrital.edu.model.ExportarEstadisticas;
import com.udistrital.edu.model.Generador;
import com.udistrital.edu.view.VistaResultados;

public class Controller {
    private Generador generador;
    private EstadisticasOrdenamiento estadisticasAleatorio;
    private EstadisticasOrdenamiento estadisticasOrdenado;
    private EstadisticasOrdenamiento estadisticasInverso;

    public Controller(Generador generador) {
        this.generador = generador;
    }

    public void iniciar(int tamano, double fCrecimiento) {
        estadisticasAleatorio = new EstadisticasOrdenamiento();
        estadisticasOrdenado = new EstadisticasOrdenamiento();
        estadisticasInverso = new EstadisticasOrdenamiento();

        generador.generarAleatorio(tamano, fCrecimiento, estadisticasAleatorio);
        generador.generarOrdenado(tamano, fCrecimiento, estadisticasOrdenado);
        generador.generarInverso(tamano, fCrecimiento, estadisticasInverso);
        ExportarEstadisticas.exportar("estadisticas.txt", estadisticasAleatorio, estadisticasOrdenado, estadisticasInverso);

        new VistaResultados(estadisticasAleatorio, estadisticasOrdenado, estadisticasInverso).setVisible(true);
    }
}