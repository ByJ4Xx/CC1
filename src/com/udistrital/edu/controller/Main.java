package com.udistrital.edu.controller;

import com.udistrital.edu.model.Generador;

public class Main {
    public static void main(String[] args) {
        // Crear el modelo, vista y controlador
        Generador generador = new Generador();
        Controller controller = new Controller(generador);

        // Iniciar el controlador para interactuar con la vista y el modelo
        controller.iniciar();
    }
}