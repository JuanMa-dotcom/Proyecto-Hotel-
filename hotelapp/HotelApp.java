
package com.mycompany.hotelapp;
import java.util.Scanner;
//Main
public class HotelApp {
    private static Scanner scanner = new Scanner(System.in);
    private static Habitacion[] habitaciones = {
        new HabitacionSencilla(101, 800.0, 1),
        new HabitacionSencilla(102, 850.0, 2),
        new HabitacionDoble(201, 1200.0, 1),
        new HabitacionDoble(202, 1300.0, 2),
        new Suite(301, 2500.0, true, true)
    };
    
    public static void main(String[] args) {
        System.out.println(" BIENVENIDO AL SISTEMA DE RESERVACIONES DEL HOTEL ");
        System.out.println("======================================================\n");
        
        int opcion = 0;
        
        do {
            mostrarMenu();
            opcion = leerOpcion();
            
            switch (opcion) {
                case 1:
                    mostrarHabitaciones();
                    break;
                case 2:
                    reservarHabitacion();
                    break;
                case 3:
                    liberarHabitacion();
                    break;
                case 4:
                    calcularCostoEstancia();
                    break;
                case 5:
                    System.out.println("¡Gracias por usar nuestro sistema!");
                    break;
                default:
                    System.out.println("Opcion no valida. Intente de nuevo.\n");
            }
        } while (opcion != 5);
        
        scanner.close();
    }
    
    private static void mostrarMenu() {
        System.out.println("=============== MENU PRINCIPAL ===============");
        System.out.println("1. Ver todas las habitaciones");
        System.out.println("2. Reservar una habitacion");
        System.out.println("3. Liberar una habitacion");
        System.out.println("4. Calcular costo de estancia");
        System.out.println("5. Salir");
        System.out.println("==============================================");
        System.out.print("Seleccione una opcion (1-5): ");
    }
    
    private static int leerOpcion() {
        try {
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            System.out.println();
            return opcion;
        } catch (Exception e) {
            scanner.nextLine(); // Limpiar buffer
            return -1;
        }
    }
    
    private static void mostrarHabitaciones() {
        System.out.println(" LISTADO DE HABITACIONES:");
        System.out.println("===========================\n");
        
        for (int i = 0; i < habitaciones.length; i++) {
            habitaciones[i].mostrarInfo();
            System.out.println();
        }
        
        presionarEnterParaContinuar();
    }
    
    private static void reservarHabitacion() {
        System.out.println("RESERVAR HABITACION:");
        System.out.println("=======================\n");
        
        mostrarHabitacionesDisponibles();
        
        System.out.print("Ingrese el numero de habitacion que desea reservar: ");
        int numeroHabitacion = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        
        Habitacion habitacion = buscarHabitacion(numeroHabitacion);
        
        if (habitacion != null) {
            if (!habitacion.isOcupada()) {
                habitacion.reservar();
                System.out.println("Habitacion reservada exitosamente!\n");
            } else {
                System.out.println(" Lo sentimos, esta habitacion ya esta ocupada.\n");
            }
        } else {
            System.out.println("Numero de habitacion no valido.\n");
        }
        
        presionarEnterParaContinuar();
    }
    
    private static void liberarHabitacion() {
        System.out.println("LIBERAR HABITACION:");
        System.out.println("======================\n");
        
        mostrarHabitacionesOcupadas();
        
        System.out.print("Ingrese el numero de habitacion que desea liberar: ");
        int numeroHabitacion = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        
        Habitacion habitacion = buscarHabitacion(numeroHabitacion);
        
        if (habitacion != null) {
            if (habitacion.isOcupada()) {
                habitacion.liberar();
                System.out.println(" Habitacion liberada exitosamente!\n");
            } else {
                System.out.println("Esta habitacion ya estaba libre.\n");
            }
        } else {
            System.out.println(" Numero de habitacipn no valido.\n");
        }
        
        presionarEnterParaContinuar();
    }
    
    private static void calcularCostoEstancia() {
        System.out.println(" CALCULAR COSTO DE ESTANCIA:");
        System.out.println("==============================\n");
        
        System.out.print("Ingrese el numero de habitacion: ");
        int numeroHabitacion = scanner.nextInt();
        
        System.out.print("Ingrese el numero de noches: ");
        int noches = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        
        Habitacion habitacion = buscarHabitacion(numeroHabitacion);
        
        if (habitacion != null && noches > 0) {
            double costoTotal = habitacion.calcularCosto(noches);
            System.out.println("\n DESGLOSE DEL COSTO:");
            System.out.println("Habitacion #" + habitacion.getNumero());
            System.out.println("Precio por noche: $" + habitacion.getPrecioPorNoche());
            System.out.println("Numero de noches: " + noches);
            System.out.println("COSTO TOTAL: $" + costoTotal + "\n");
        } else {
            System.out.println(" Datos no validos.\n");
        }
        
        presionarEnterParaContinuar();
    }
    
    private static void mostrarHabitacionesDisponibles() {
        System.out.println("Habitaciones disponibles:");
        boolean hayDisponibles = false;
        
        for (Habitacion h : habitaciones) {
            if (!h.isOcupada()) {
                System.out.println("- Habitacion #" + h.getNumero() + 
                                 " ($" + h.getPrecioPorNoche() + "/noche)");
                hayDisponibles = true;
            }
        }
        
        if (!hayDisponibles) {
            System.out.println(" No hay habitaciones disponibles.");
        }
        System.out.println();
    }
    
    private static void mostrarHabitacionesOcupadas() {
        System.out.println("Habitaciones ocupadas:");
        boolean hayOcupadas = false;
        
        for (Habitacion h : habitaciones) {
            if (h.isOcupada()) {
                System.out.println("- Habitacion #" + h.getNumero());
                hayOcupadas = true;
            }
        }
        
        if (!hayOcupadas) {
            System.out.println(" No hay habitaciones ocupadas.");
        }
        System.out.println();
    }
    
    private static Habitacion buscarHabitacion(int numero) {
        for (Habitacion h : habitaciones) {
            if (h.getNumero() == numero) {
                return h;
            }
        }
        return null;
    }
    
    private static void presionarEnterParaContinuar() {
        System.out.print("Presione Enter para continuar...");
        scanner.nextLine();
        System.out.println();
    }
}