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

    // INICIALIZACIÓN

    private void inicializarTablero() {
        tablero = new Casilla[FILAS][COLUMNAS];

        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
            	tablero[i][j] = new CasillaSegura(); 
            }
        }
    }

    // MINAS
  
    private void colocarMinas() {

        Random r = new Random();
        int colocadas = 0;

        while (colocadas < MINAS) {

            int f = r.nextInt(FILAS);
            int c = r.nextInt(COLUMNAS);

            if (!tablero[f][c].isMina()) {
                tablero[f][c] = new CasillaMina(); 
                colocadas++;
            }
        }
    }

    // NUMEROS ADYACENTES
  
    private void calcularMinasAdyacentes() {

        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {

                if (tablero[i][j].isMina()) continue;

                int contador = 0;

                for (int x = -1; x <= 1; x++) {
                    for (int y = -1; y <= 1; y++) {

                        int nf = i + x;
                        int nc = j + y;

                        if (esValida(nf, nc) && tablero[nf][nc].isMina()) {
                            contador++;
                        }
                    }
                }

                tablero[i][j].setMinasAdyacentes(contador);
            }
        }
    }

    
    // DESCUBRIR (CON RECURSIVIDAD 

    public void descubrirCasilla(int fila, int columna)
            throws CasillaYaDescubiertaException {

        if (!esValida(fila, columna)) {
            throw new ArrayIndexOutOfBoundsException("Posición fuera del tablero");
        }

        Casilla casilla = tablero[fila][columna];

        if (casilla.isDescubierta()) {
            throw new CasillaYaDescubiertaException("La casilla ya fue descubierta");
        }

        revelarRecursivo(fila, columna);
    }

    // 🔥 LO IMPORTANTE DEL EXAMEN
    private void revelarRecursivo(int fila, int columna) {

        if (!esValida(fila, columna)) return;

        Casilla casilla = tablero[fila][columna];

        if (casilla.isDescubierta() || casilla.isMina()) return;

        casilla.setDescubierta(true);

        // si tiene número, se detiene
        if (casilla.getMinasAdyacentes() > 0) return;

        // expandir vecinos
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {

                if (i != 0 || j != 0) {
                    revelarRecursivo(fila + i, columna + j);
                }
            }
        }
    }

    public void toggleBandera(int fila, int columna) throws CasillaYaDescubiertaException {

        if (!esValida(fila, columna)) return;

        Casilla c = tablero[fila][columna];

        //  Lanza la excepción si intentas poner bandera donde ya picaste
        if (c.isDescubierta()) {
            throw new CasillaYaDescubiertaException("No puedes poner una bandera en una casilla ya descubierta.");
        }

        c.setBandera(!c.isBandera());
    }
    
    // VICTORIA

    public boolean verificarVictoria() {

        int libres = 0;
        int descubiertas = 0;

        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {

                if (!tablero[i][j].isMina()) {
                    libres++;
                    if (tablero[i][j].isDescubierta()) {
                        descubiertas++;
                    }
                }
            }
        }

        return libres == descubiertas;
    }


    // VALIDACIÓN
  
    private boolean esValida(int f, int c) {
        return f >= 0 && f < FILAS && c >= 0 && c < COLUMNAS;
    }

    // GETTER
    
    public Casilla[][] getTablero() {
        return tablero;
    }

    public int contarMinas() {

        int contador = 0;

        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {

                if (tablero[i][j].isMina()) {
                    contador++;
                }
            }
        }

        return contador;
    }
}