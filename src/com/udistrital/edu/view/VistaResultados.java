package com.udistrital.edu.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.udistrital.edu.model.EstadisticasOrdenamiento;
import com.udistrital.edu.model.ResultadoOrdenamiento;

import java.awt.*;
import java.util.Map;

public class VistaResultados extends JFrame {
    public VistaResultados(EstadisticasOrdenamiento aleatorio,
                           EstadisticasOrdenamiento ordenado,
                           EstadisticasOrdenamiento inverso) {
        setTitle("Resultados de Ordenamiento");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(1, 3));

        add(crearPanelTabla("Aleatorio", aleatorio));
        add(crearPanelTabla("Ordenado", ordenado));
        add(crearPanelTabla("Inverso", inverso));
    }

    private JPanel crearPanelTabla(String titulo, EstadisticasOrdenamiento estadisticas) {
        String[] columnas = {"Algoritmo", "Prom. Tiempo (ms)", "Prom. Comparaciones", "Prom. Intercambios"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
        for (Map.Entry<String, ResultadoOrdenamiento> entry : estadisticas.getPromedios().entrySet()) {
            ResultadoOrdenamiento r = entry.getValue();
            modelo.addRow(new Object[]{
                entry.getKey(),
                String.format("%.4f", r.tiempo),
                r.comparaciones,
                r.intercambios
            });
        }

        JTable tabla = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabla);
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder(titulo));
        panel.add(scroll, BorderLayout.CENTER);
        return panel;
    }
}

