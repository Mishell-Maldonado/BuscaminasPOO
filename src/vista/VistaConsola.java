package vista;

import java.util.Scanner;
import modelo.Casilla;
import modelo.Tablero;

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

    public void mostrarTablero(Tablero tablero) {

        Casilla[][] casillas = tablero.getTablero();

        System.out.println();

        System.out.print("    ");

        for (int i = 1; i <= 10; i++) {
            System.out.printf("%2d ", i);
        }

        System.out.println();

        for (int fila = 0; fila < 10; fila++) {

            char letraFila = (char) ('A' + fila);

            System.out.print(letraFila + "   ");

            for (int columna = 0; columna < 10; columna++) {

                Casilla casilla = casillas[fila][columna];

                String valor;

            if (casilla.isBandera()) {

                valor = "⚑";

                } else if (!casilla.isDescubierta()) {

                valor = "■";

                } else if (casilla.isMina()) {

                valor = "X";

                } else if (casilla.getMinasAdyacentes() == 0) {

                valor = "V";

                } else {

                valor = String.valueOf(casilla.getMinasAdyacentes());
                }

            System.out.printf("%-3s", valor);            
        }

            System.out.println();
        }
    }

    public void cerrarScanner() {
        scanner.close();
    }
}
