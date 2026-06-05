package modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CasillaMinaTest {

    @Test
    void testIsMina() {
        CasillaMina mina = new CasillaMina();
        assertTrue(mina.isMina(), "Una CasillaMina siempre debe devolver true en isMina()");
    }

    @Test
    void testGetMinasAdyacentes() {
        CasillaMina mina = new CasillaMina();
        assertEquals(-1, mina.getMinasAdyacentes(), "Las minas devuelven -1");
    }
}