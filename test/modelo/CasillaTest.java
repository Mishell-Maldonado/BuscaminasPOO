package modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CasillaTest {

    @Test
    void testCasillaInicialComun() {
        Casilla c = new CasillaSegura(); // Usamos CasillaSegura porque Casilla es abstracta
        assertFalse(c.isDescubierta(), "Al inicio no debe estar descubierta");
        assertFalse(c.isBandera(), "Al inicio no debe tener bandera");
    }

    @Test
    void testSetDescubierta() {
        Casilla c = new CasillaSegura();
        c.setDescubierta(true);
        assertTrue(c.isDescubierta());
    }

    @Test
    void testSetBandera() {
        Casilla c = new CasillaSegura();
        c.setBandera(true);
        assertTrue(c.isBandera());
    }
}