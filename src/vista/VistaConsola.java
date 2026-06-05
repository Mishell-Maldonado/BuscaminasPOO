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
        System.out.println("3. Guardar partida");
        System.out.println("4. Marcar bandera");
        System.out.println("5. Salir");
    }

    public int leerOpcion() {
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    /**
     * Lee coordenadas tipo A5
     */
    public String leerCoordenada() {
        System.out.print("Ingrese una coordenada (Ej: A5): ");
        return scanner.next().toUpperCase();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarVictoria() {
        System.out.println("¡Felicidades! Has ganado.");
    }

    public void mostrarDerrota() {
        System.out.println("¡BOOM! Has encontrado una mina.");
    }

    /**
     * Muestra una representación simple del tablero.
     */
    public void mostrarTablero(char[][] tablero) {

        System.out.println();

        System.out.print("  ");

        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
        }

        System.out.println();

        for (int fila = 0; fila < 10; fila++) {

            System.out.print((char) ('A' + fila) + " ");

            for (int columna = 0; columna < 10; columna++) {

                System.out.print(tablero[fila][columna] + " ");
            }

            System.out.println();
        }
    }
}