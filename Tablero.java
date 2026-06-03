public class Tablero {

    private Casilla[][] tablero;
    private final int FILAS = 10;
    private final int COLUMNAS = 10;
    private final int MINAS = 10;

    public Tablero() {}

    public void inicializarTablero() {}

    public void colocarMinas() {}

    public void calcularMinasAdyacentes() {}

    public void descubrirCasilla(int fila, int columna)
            throws CasillaYaDescubiertaException {}

    public void marcarCasilla(int fila, int columna) {}

    public boolean verificarVictoria() {}

    public Casilla[][] getTablero() {}
}