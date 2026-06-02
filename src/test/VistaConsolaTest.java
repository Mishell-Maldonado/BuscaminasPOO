package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import vista.VistaConsola;

class VistaConsolaTest {

    @Test
    void testCrearVista() {

        VistaConsola vista = new VistaConsola();

        assertNotNull(vista);
    }

    @Test
    void testObjetoVistaExiste() {

        VistaConsola vista = new VistaConsola();

        assertTrue(vista instanceof VistaConsola);
    }
}