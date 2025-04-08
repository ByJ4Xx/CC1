package com.udistrital.edu.controller;

import com.udistrital.edu.model.EstadisticasOrdenamiento;
import com.udistrital.edu.model.Generador;

public class Controller {
	private Generador generador;
	private EstadisticasOrdenamiento estadisticas;

    public Controller(Generador generador, EstadisticasOrdenamiento estadisticas) {
        this.generador = generador;
        this.estadisticas = estadisticas;
    }

    public void iniciar() {
    	int tamano = 10;
    	double fCrecimiento = 1.2;
        generador.generarAleatorio(10, 1.2, estadisticas);
        estadisticas.imprimirPromedios();
    }
}
