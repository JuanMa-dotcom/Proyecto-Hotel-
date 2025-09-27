package com.mycompany.hotelapp;
//Suite     
class Suite extends Habitacion {
    private boolean tieneJacuzzi;
    private boolean vistaMar;
    
    public Suite(int numero, double precioPorNoche, boolean tieneJacuzzi, boolean vistaMar) {
        super(numero, precioPorNoche);
        this.tieneJacuzzi = tieneJacuzzi;
        this.vistaMar = vistaMar;
    }
    
    @Override
    public void mostrarInfo() {
        System.out.println("=== SUITE DE LUJO ===");
        super.mostrarInfo();
        System.out.println("Jacuzzi: " + (tieneJacuzzi ? "Si" : "No"));
        System.out.println("Vista al mar: " + (vistaMar ? "Si" : "No"));
        System.out.println("======================");
    }
}

