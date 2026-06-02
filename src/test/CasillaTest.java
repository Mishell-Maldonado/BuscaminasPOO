package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Casilla;

class CasillaTest {

    @Test
    void testCasillaInicialmenteSinMina() {

        Casilla casilla = new Casilla();

        assertFalse(casilla.isMina());
    }

    @Test
    void testSetMina() {

        Casilla casilla = new Casilla();

        casilla.setMina(true);

        assertTrue(casilla.isMina());
    }

    @Test
    void testSetBandera() {

        Casilla casilla = new Casilla();

        casilla.setBandera(true);

        assertTrue(casilla.isBandera());
    }

    @Test
    void testMinasAdyacentes() {

        Casilla casilla = new Casilla();

        casilla.setMinasAdyacentes(3);

        assertEquals(3, casilla.getMinasAdyacentes());
    }
}