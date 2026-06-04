package modelo;

import excepciones.CasillaYaDescubiertaException;
import java.io.Serializable;
import java.util.Random;


public class Tablero implements Serializable {

    private static final long serialVersionUID = 1L;

    private final int FILAS = 10;
    private final int COLUMNAS = 10;
    private final int MINAS = 10;

    private Casilla[][] tablero;

    public Tablero() {
        inicializarTablero();
        colocarMinas();
        calcularMinasAdyacentes();
    }

    private void inicializarTablero() {

        tablero = new Casilla[FILAS][COLUMNAS];

        for (int fila = 0; fila < FILAS; fila++) {
            for (int columna = 0; columna < COLUMNAS; columna++) {
                tablero[fila][columna] = new Casilla();
            }
        }
    }

    private void colocarMinas() {

        Random random = new Random();
        int minasColocadas = 0;

        while (minasColocadas < MINAS) {

            int fila = random.nextInt(FILAS);
            int columna = random.nextInt(COLUMNAS);

            if (!tablero[fila][columna].isMina()) {

                tablero[fila][columna].setMina(true);
                minasColocadas++;
            }
        }
    }

    private void calcularMinasAdyacentes() {

        for (int fila = 0; fila < FILAS; fila++) {

            for (int columna = 0; columna < COLUMNAS; columna++) {

                if (tablero[fila][columna].isMina()) {
                    continue;
                }

                int contador = 0;

                for (int i = -1; i <= 1; i++) {

                    for (int j = -1; j <= 1; j++) {

                        int nuevaFila = fila + i;
                        int nuevaColumna = columna + j;

                        if (esValida(nuevaFila, nuevaColumna)
                                && tablero[nuevaFila][nuevaColumna].isMina()) {

                            contador++;
                        }
                    }
                }

                tablero[fila][columna].setMinasAdyacentes(contador);
            }
        }
    }

    public void descubrirCasilla(int fila, int columna)
        throws CasillaYaDescubiertaException {

    if (!esValida(fila, columna)) {
        throw new ArrayIndexOutOfBoundsException(
                "Posición fuera del tablero");
    }

    Casilla casilla = tablero[fila][columna];

    if (casilla.isDescubierta()) {
        throw new CasillaYaDescubiertaException(
                "La casilla ya fue descubierta");
    }

    casilla.setDescubierta(true);
}

    public void marcarBandera(int fila, int columna) {

        if (esValida(fila, columna)) {

            Casilla casilla = tablero[fila][columna];

            casilla.setBandera(!casilla.isBandera());
        }
    }

    public boolean verificarVictoria() {

        int descubiertas = 0;

        for (int fila = 0; fila < FILAS; fila++) {
            for (int columna = 0; columna < COLUMNAS; columna++) {

                if (!tablero[fila][columna].isMina()
                        && tablero[fila][columna].isDescubierta()) {

                    descubiertas++;
                }
            }
        }

        return descubiertas == (FILAS * COLUMNAS - MINAS);
    }

    private boolean esValida(int fila, int columna) {

        return fila >= 0 && fila < FILAS
                && columna >= 0 && columna < COLUMNAS;
    }

    public Casilla[][] getTablero() {
        return tablero;
    }

    public int contarMinas() {

        int contador = 0;

        for (int fila = 0; fila < FILAS; fila++) {
            for (int columna = 0; columna < COLUMNAS; columna++) {

                if (tablero[fila][columna].isMina()) {
                    contador++;
                }
            }
        }

        return contador;
    }
}