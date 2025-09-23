package com.mycompany.hotelapp;


class Habitacion {
    protected int numero;
    protected double precioPorNoche;
    protected boolean ocupada;
    
    // Constructor
    public Habitacion(int numero, double precioPorNoche) {
        this.numero = numero;
        this.precioPorNoche = precioPorNoche;
        this.ocupada = false; // Por defecto está libre
    }
    
    // Método para mostrar información general
    public void mostrarInfo() {
        String estado = ocupada ? "Ocupada" : "Libre";
        System.out.println("Habitacion #" + numero);
        System.out.println("Precio por noche: $" + precioPorNoche);
        System.out.println("Estado: " + estado);
    }
    
    // Método para reservar la habitación
    public void reservar() {
        if (!ocupada) {
            ocupada = true;
            System.out.println("Habitacion #" + numero + " ha sido reservada.");
        } else {
            System.out.println("La habitacion #" + numero + " ya esta ocupada.");
        }
    }
    
    // Método para liberar la habitación
    public void liberar() {
        if (ocupada) {
            ocupada = false;
            System.out.println("Habitacion #" + numero + " ha sido liberada.");
        } else {
            System.out.println("La habitacion #" + numero + " ya estaba libre.");
        }
    }
    
    // Método para calcular costo total
    public double calcularCosto(int noches) {
        return precioPorNoche * noches;
    }
    
    // Getters
    public int getNumero() {
        return numero;
    }
    
    public boolean isOcupada() {
        return ocupada;
    }
    
    public double getPrecioPorNoche() {
        return precioPorNoche;
    }
}