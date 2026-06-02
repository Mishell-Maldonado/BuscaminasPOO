package pruebas;

import modelo.Casilla;
import persistencia.GestorArchivos;

public class PruebaCargar {

    public static void main(String[] args) {
        GestorArchivos gestor = new GestorArchivos();

        // Cargamos el archivo que creamos en la prueba anterior
        Casilla casilla = (Casilla) gestor.cargarPartida("partida.dat");

        if (casilla != null) {
            System.out.println("¿Tiene mina?: " + casilla.isMina());
        }
    }
}