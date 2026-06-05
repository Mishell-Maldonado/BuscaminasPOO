package modelo;

public class CasillaMina extends Casilla {
    private static final long serialVersionUID = 1L;

    @Override
    public boolean isMina() {
        return true; // 👉 POLIMORFISMO: ¡Soy una mina!
    }

    @Override
    public int getMinasAdyacentes() {
        return -1; // Una mina no tiene números adyacentes, retornamos -1 por defecto
    }

    @Override
    public void setMinasAdyacentes(int minasAdyacentes) {
        // Una mina no necesita guardar cuántas minas tiene alrededor, no hacemos nada aquí.
    }
}