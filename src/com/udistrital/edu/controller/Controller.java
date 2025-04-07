package com.udistrital.edu.controller;

import com.udistrital.edu.model.Generador;

public class Controller {
	private Generador generador;

    public Controller(Generador generador) {
        this.generador = generador;
    }

    public void iniciar() {
    	int tamano = 10;
    	double fCrecimiento = 1.2;
        double [] resultados = generador.generarAleatorio(10, 1.2);
        System.out.println("Mostrando los promedio a continuacion:");
        System.out.println("Tiempo: "+ resultados[0] + ", Comparaciones: "+ resultados[1] +", Intercambios: "+ resultados[2]);
    }
}
