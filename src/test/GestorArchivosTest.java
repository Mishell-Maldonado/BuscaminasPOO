package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Casilla;
import persistencia.GestorArchivos;

class GestorArchivosTest {

    @Test
    void testGuardarPartida() {

        Casilla casilla = new Casilla();

        GestorArchivos gestor = new GestorArchivos();

        assertDoesNotThrow(() ->
                gestor.guardarPartida(casilla, "test.dat"));
    }

    @Test
    void testCargarPartida() {

        Casilla casilla = new Casilla();

        GestorArchivos gestor = new GestorArchivos();

        gestor.guardarPartida(casilla, "test.dat");

        Object objeto =
                gestor.cargarPartida("test.dat");

        assertNotNull(objeto);
    }
}