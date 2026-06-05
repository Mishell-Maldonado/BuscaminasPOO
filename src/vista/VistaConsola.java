package vista;

import java.util.Scanner;
import modelo.Casilla;
import modelo.Tablero;

public class VistaConsola {

    private final Scanner scanner = new Scanner(System.in);

    public void mostrarMenuPrincipal() {
        System.out.println("\n=== BUSCAMINAS ===");
        System.out.println("1. Nueva partida");
        System.out.println("2. Cargar partida");
        System.out.println("3. Salir");
    }

    public void mostrarMenuJuego() {
        System.out.println("\nAcción:");
        System.out.println("1. Descubrir casilla");
        System.out.println("2. Colocar/Quitar bandera");
        System.out.println("3. Guardar partida");
        System.out.println("4. Salir al menú");
        System.out.print("Seleccione(1-4): ");
    }

    public int leerOpcion() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Opción inválida. Ingrese un número: ");
            }
        }
    }

    public String leerCoordenada() {
        System.out.print("Ingrese coordenada (ej. A5): ");
        return scanner.nextLine().trim().toUpperCase();
    }

    public void mostrarMensaje(String msg) {
        System.out.println(msg);
    }

    public void mostrarVictoria() {
        System.out.println("¡Felicidades! Has ganado.");
    }

    public void mostrarDerrota() {
        System.out.println("¡BOOM! Has encontrado una mina.");
    }

    public void mostrarTablero(Tablero tablero) {

        Casilla[][] c = tablero.getTablero();

        System.out.println("\n     1  2  3  4  5  6  7  8  9 10");

        for (int i = 0; i < 10; i++) {

            System.out.print((char) ('A' + i) + "   ");

            for (int j = 0; j < 10; j++) {

                Casilla casilla = c[i][j];

                String v;

                if (casilla.isBandera()) v = "⚑";
                else if (!casilla.isDescubierta()) v = "■";
                else if (casilla.isMina()) v = "X";
                else if (casilla.getMinasAdyacentes() == 0) v = "V";
                else v = String.valueOf(casilla.getMinasAdyacentes());

                System.out.printf("%-3s", v);
            }
            System.out.println();
        }
    }
}
