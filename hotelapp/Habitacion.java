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
    
    // Metodo para mostrar informacion general
    public void mostrarInfo() {
        String estado = ocupada ? "Ocupada" : "Libre";
        System.out.println("Habitacion #" + numero);
        System.out.println("Precio por noche: $" + precioPorNoche);
        System.out.println("Estado: " + estado);
    }
    
    // Metodo para reservar la habitacion
    public void reservar() {
        if (!ocupada) {
            ocupada = true;
            System.out.println("Habitacion #" + numero + " ha sido reservada.");
        } else {
            System.out.println("La habitacion #" + numero + " ya esta ocupada.");
        }
    }
    
    // Metodo para liberar la habitacion
    public void liberar() {
        if (ocupada) {
            ocupada = false;
            System.out.println("Habitacion #" + numero + " ha sido liberada.");
        } else {
            System.out.println("La habitacion #" + numero + " ya estaba libre.");
        }
    }
    
    // Metodo para calcular costo total
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

