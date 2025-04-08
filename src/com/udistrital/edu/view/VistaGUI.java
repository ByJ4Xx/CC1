package com.udistrital.edu.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.udistrital.edu.controller.Controller;

public class VistaGUI extends JFrame {
    private JTextField campoTamano;
    private JTextField campoCrecimiento;
    private JButton botonGenerar;
    private Controller controlador;

    public VistaGUI(Controller controlador) {
        this.controlador = controlador;
        setTitle("Comparador de Algoritmos de Ordenamiento");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        JLabel etiquetaTamano = new JLabel("Tamaño inicial del arreglo (>10):");
        campoTamano = new JTextField("10", 10);
        
        JLabel etiquetaCrecimiento = new JLabel("Tasa de crecimiento (>1.0):");
        campoCrecimiento = new JTextField("1.2", 10);

        botonGenerar = new JButton("Generar y Ordenar");
        botonGenerar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int tamano = Integer.parseInt(campoTamano.getText());
                    double crecimiento = Double.parseDouble(campoCrecimiento.getText());
                    if (tamano < 10 || crecimiento <= 1.0) {
                        JOptionPane.showMessageDialog(null, "Tamaño debe ser >10 y crecimiento >1.0");
                        return;
                    }
                    controlador.iniciar(tamano, crecimiento);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese valores numéricos válidos.");
                }
            }
        });

        setLayout(new GridLayout(3, 2, 10, 10));
        add(etiquetaTamano);
        add(campoTamano);
        add(etiquetaCrecimiento);
        add(campoCrecimiento);
        add(new JLabel()); // espacio
        add(botonGenerar);
    }

    public void mostrar() {
        setVisible(true);
    }
}

