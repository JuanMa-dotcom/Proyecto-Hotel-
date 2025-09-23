
package com.mycompany.hotelapp;
//habitacion doble
class HabitacionDoble extends Habitacion {
    private int camasDobles;
    
    public HabitacionDoble(int numero, double precioPorNoche, int camasDobles) {
        super(numero, precioPorNoche);
        this.camasDobles = camasDobles;
    }
    
    @Override
    public void mostrarInfo() {
        System.out.println("=== HABITACION DOBLE ===");
        super.mostrarInfo();
        System.out.println("Camas dobles: " + camasDobles);
        System.out.println("=========================");
    }
}