package com.udistrital.edu.controller;

import com.udistrital.edu.model.Generador;
import com.udistrital.edu.view.VistaGUI;

import javax.swing.SwingUtilities;

import com.udistrital.edu.model.EstadisticasOrdenamiento;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Generador generador = new Generador();
            Controller controller = new Controller(generador);
            VistaGUI vista = new VistaGUI(controller);
            vista.mostrar();
        });
    }
}