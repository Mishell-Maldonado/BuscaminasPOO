package controlador;

import excepciones.CasillaYaDescubiertaException;
import modelo.Tablero;
import vista.VistaConsola;
import persistencia.GestorArchivos;

public class JuegoControlador {

	private Tablero tablero = new Tablero();
    private final VistaConsola vista = new VistaConsola();
    private final GestorArchivos archivo = new GestorArchivos();
    
    public void iniciarJuego() {

        while (true) {

            vista.mostrarMenuPrincipal();
            int opcion = vista.leerOpcion();

            if (opcion == 3) {
                vista.mostrarMensaje("Saliendo...");
                return;
            }
            if (opcion == 2) {
                Tablero cargado = (Tablero) archivo.cargarPartida("partida.dat");

                if (cargado != null) {
                    this.tablero = cargado;
                    vista.mostrarMensaje("Partida cargada correctamente.");
                    jugar(); 
                }
            }
            if (opcion == 1) {
                tablero = new Tablero(); // NUEVA PARTIDA
                jugar();
            }
        }
    }

    private void jugar() {

        boolean fin = false;

        while (!fin) {

            vista.mostrarTablero(tablero);
            vista.mostrarMenuJuego();

            int op = vista.leerOpcion();

            try {

                if (op == 1) {
                    String coord = vista.leerCoordenada();

                    // Validación para que no explote si escriben "5A" o "Z20"
                    if (!coord.matches("[A-J](10|[1-9])")) {
                        vista.mostrarMensaje("Coordenada inválida. Use formato como A5, B10, etc.");
                        continue; 
                    }

                    int f = coord.charAt(0) - 'A';
                    int c = Integer.parseInt(coord.substring(1)) - 1;

                    //  Si tiene bandera, no deja descubrir
                    if (tablero.getTablero()[f][c].isBandera()) {
                        vista.mostrarMensaje("¡Casilla con bandera! Quítala antes de descubrirla.");
                        continue;
                    }

                    if (tablero.getTablero()[f][c].isMina()) {
                        tablero.getTablero()[f][c].setDescubierta(true); // OBLIGA A MOSTRAR LA X
                        vista.mostrarTablero(tablero); 
                        vista.mostrarDerrota();
                        fin = true;

                    } else {
                        tablero.descubrirCasilla(f, c);
                        
                        if (tablero.verificarVictoria()) {
                            vista.mostrarTablero(tablero);
                            vista.mostrarVictoria();
                            fin = true;
                        }
                    }
                }

                if (op == 2) {
                    String coord = vista.leerCoordenada();

                    if (!coord.matches("[A-J](10|[1-9])")) {
                        vista.mostrarMensaje("Coordenada inválida. Use formato como A5, B10, etc.");
                        continue;
                    }

                    int f = coord.charAt(0) - 'A';
                    int c = Integer.parseInt(coord.substring(1)) - 1;

                    tablero.toggleBandera(f, c);
                }
                
                if (op == 3) {
                    archivo.guardarPartida(tablero, "partida.dat");
                    vista.mostrarMensaje("Partida guardada.");
                }

                if (op == 4) {
                    fin = true;
                }

            } catch (CasillaYaDescubiertaException e) {
                vista.mostrarMensaje(e.getMessage());
            } 
            catch (ArrayIndexOutOfBoundsException e) {
                vista.mostrarMensaje("Coordenada fuera del tablero");
            }
        }
    }
}