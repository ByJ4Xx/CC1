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
        generador.generarAleatorio(10, 1.2);
    }
}
