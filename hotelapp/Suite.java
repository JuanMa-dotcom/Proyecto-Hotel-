package com.mycompany.hotelapp;
//Suite     
class Suite extends Habitacion {
    private boolean tieneJacuzzi;
    private boolean tieneVistaMar;
    
    public Suite(int numero, double precioPorNoche, boolean tieneJacuzzi, boolean tieneVistaMar) {
        super(numero, precioPorNoche);
        this.tieneJacuzzi = tieneJacuzzi;
        this.tieneVistaMar = tieneVistaMar;
    }
    
    @Override
    public void mostrarInfo() {
        System.out.println("=== SUITE DE LUJO ===");
        super.mostrarInfo();
        System.out.println("Jacuzzi: " + (tieneJacuzzi ? "Si" : "No"));
        System.out.println("Vista al mar: " + (tieneVistaMar ? "Si" : "No"));
        System.out.println("======================");
    }
}

