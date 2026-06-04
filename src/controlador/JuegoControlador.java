package controlador;

import java.util.Scanner;
import excepciones.CasillaYaDescubiertaException;
import modelo.Tablero;
import persistencia.GestorArchivos;

public class JuegoControlador {

    private final Tablero tablero;
    private final Scanner scanner;
    private final GestorArchivos gestorArchivos;
    
    public JuegoControlador() {
        tablero = new Tablero();
        scanner = new Scanner(System.in);
        gestorArchivos = new GestorArchivos();
    }

    public void iniciarJuego() {

        boolean juegoTerminado = false;

        System.out.println("===== BUSCAMINAS =====");
        
        while (!juegoTerminado) {

            try {

                System.out.println("\n1. Jugar");
                System.out.println("2. Guardar partida");

                int opcion = scanner.nextInt();

                if (opcion != 1 && opcion != 2) {

                    System.out.println("Opción inválida.");
                    continue;
                }

                if (opcion == 2) {

                    gestorArchivos.guardarPartida(
                            tablero,
                            "partida.dat");

                    System.out.println("Partida guardada.");

                    continue;
                }
                System.out.print("Ingrese fila (0-9): ");
                int fila = scanner.nextInt();

                System.out.print("Ingrese columna (0-9): ");
                int columna = scanner.nextInt();

                tablero.descubrirCasilla(fila, columna);

                if (tablero.getTablero()[fila][columna].isMina()) {

                    System.out.println("¡BOOM! Encontraste una mina.");
                    juegoTerminado = true;

                } else if (tablero.verificarVictoria()) {

                    System.out.println("¡Felicidades! Has ganado.");
                    juegoTerminado = true;

                } else {

                    System.out.println("Casilla descubierta correctamente.");
                }

            } catch (CasillaYaDescubiertaException e) {

                System.out.println(e.getMessage());

            } catch (ArrayIndexOutOfBoundsException e) {

                System.out.println("Posición inválida.");

            } catch (Exception e) {

                System.out.println("Entrada incorrecta.");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    public Tablero getTablero() {
        return tablero;
    }
}
