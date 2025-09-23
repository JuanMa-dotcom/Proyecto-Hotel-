
package com.mycompany.hotelapp;

//Habitacion sencilla 

class HabitacionSencilla extends Habitacion {
    private int camasIndividuales;
    
    public HabitacionSencilla(int numero, double precioPorNoche, int camasIndividuales) {
        super(numero, precioPorNoche);
        this.camasIndividuales = camasIndividuales;
    }
    
    @Override
    public void mostrarInfo() {
        System.out.println("=== HABITACION SENCILLA ===");
        super.mostrarInfo();
        System.out.println("Camas individuales: " + camasIndividuales);
        System.out.println("===========================");
    }
}