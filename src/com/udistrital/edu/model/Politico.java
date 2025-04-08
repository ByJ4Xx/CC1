package com.udistrital.edu.model;

import java.time.LocalDate;

public class Politico {
	private int id;
    private int dinero;
    private LocalDate fechaNacimiento;
    
    public Politico(int id, int dinero, LocalDate fechaNacimiento) {
        this.id = id;
        this.dinero = dinero;
        this.fechaNacimiento = fechaNacimiento;
    }
    public int compareTo(Politico otro) {
        // Si quieres ordenar por dinero ascendente:
        return Integer.compare(this.dinero, otro.dinero);
    }
    
    public int getId() { return id; }
    public int getDinero() { return dinero; }
    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    
    public void setId(int id) { this.id = id; }
    public void setDinero(int dinero) { this.dinero = dinero; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
    
    @Override
    protected Politico clone() {
        return new Politico(this.id, this.dinero, this.fechaNacimiento);
    }
    
    @Override
    public String toString() {
        return "Politico{ID=" + id + ", Dinero=" + dinero + ", Nacimiento=" + fechaNacimiento + "}";
    }
}
