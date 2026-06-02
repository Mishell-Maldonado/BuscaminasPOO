package pruebas;

import modelo.Casilla;
import persistencia.GestorArchivos;

public class PruebaGuardar {

    public static void main(String[] args) {
        // 1. Creamos una casilla de prueba
        Casilla casilla = new Casilla();
        casilla.setMina(true); // Le ponemos una mina para probar el setter

        // 2. Creamos el gestor de archivos
        GestorArchivos gestor = new GestorArchivos();

        // 3. Intentamos guardar la casilla en un archivo llamado "partida.dat"
        gestor.guardarPartida(casilla, "partida.dat");
    }
}