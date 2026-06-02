package vista;

import java.util.Scanner;

public class VistaConsola {

    private Scanner scanner;

    public VistaConsola() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("\n=== BUSCAMINAS ===");
        System.out.println("1. Nueva partida");
        System.out.println("2. Cargar partida");
        System.out.println("3. Salir");
    }

    public int leerOpcion() {
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    public String leerCoordenada() {
        System.out.print("Ingrese una coordenada (Ej: A5): ");
        return scanner.next();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarVictoria() {
        System.out.println("¡Felicidades! Has ganado.");
    }

    public void mostrarDerrota() {
        System.out.println("¡Boom! Has encontrado una mina.");
    }
}