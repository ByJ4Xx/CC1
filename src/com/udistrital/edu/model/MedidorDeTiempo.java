package com.udistrital.edu.model;

// Por el momento no estoy utilizando esto para ni mrd jsjsjsjs

class MedidorDeTiempo implements Runnable {
    private Runnable tarea;

    public MedidorDeTiempo(Runnable tarea) {
        this.tarea = tarea;
    }

    @Override
    public void run() {
        long inicio = System.nanoTime(); // o System.currentTimeMillis()
        tarea.run();
        long fin = System.nanoTime();
        System.out.println("Tiempo de ejecución: " + ((fin - inicio) / 1_000_000.0) + " ms");
    }
}

