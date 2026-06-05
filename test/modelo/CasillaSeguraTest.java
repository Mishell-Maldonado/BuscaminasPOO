package modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CasillaSeguraTest {

    @Test
    void testIsMina() {
        CasillaSegura segura = new CasillaSegura();
        assertFalse(segura.isMina(), "Una CasillaSegura nunca debe devolver true en isMina()");
    }

    @Test
    void testMinasAdyacentes() {
        CasillaSegura segura = new CasillaSegura();
        assertEquals(0, segura.getMinasAdyacentes(), "Al inicio debe tener 0 adyacentes");
        
        segura.setMinasAdyacentes(3);
        assertEquals(3, segura.getMinasAdyacentes(), "Debería tener 3 adyacentes después del set");
    }
}