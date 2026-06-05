package modelo;

import excepciones.CasillaYaDescubiertaException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TableroTest {

    private Tablero tablero;

    @BeforeEach
    void setUp() {
        tablero = new Tablero();
    }

    @Test
    void testMinasColocadas() {
        assertEquals(10, tablero.contarMinas(), "Debe haber exactamente 10 minas en el tablero");
    }

    @Test
    void testDescubrirCasilla() throws CasillaYaDescubiertaException {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (!tablero.getTablero()[i][j].isMina()) {
                    tablero.descubrirCasilla(i, j);
                    assertTrue(tablero.getTablero()[i][j].isDescubierta());
                    return;
                }
            }
        }
    }

    @Test
    void testExcepcionCasillaYaDescubierta() throws CasillaYaDescubiertaException {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (!tablero.getTablero()[i][j].isMina()) {
                    tablero.descubrirCasilla(i, j);
                    
                    // 👉 SOLUCIÓN: Guardamos i y j en variables fijas para la lambda
                    final int filaFinal = i;
                    final int columnaFinal = j;
                    
                    assertThrows(CasillaYaDescubiertaException.class, () -> {
                        tablero.descubrirCasilla(filaFinal, columnaFinal);
                    });
                    return;
                }
            }
        }
    }

    @Test
    // 👉 SOLUCIÓN: Añadimos el throws CasillaYaDescubiertaException aquí
    void testToggleBandera() throws CasillaYaDescubiertaException {
        tablero.toggleBandera(5, 5);
        assertTrue(tablero.getTablero()[5][5].isBandera());
        
        tablero.toggleBandera(5, 5);
        assertFalse(tablero.getTablero()[5][5].isBandera());
    }
}