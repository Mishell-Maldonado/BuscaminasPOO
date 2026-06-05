package modelo;

public class CasillaSegura extends Casilla {
    private static final long serialVersionUID = 1L;
    
    private int minasAdyacentes;

    public CasillaSegura() {
        super();
        this.minasAdyacentes = 0;
    }

    @Override
    public boolean isMina() {
        return false;
    }

    @Override
    public int getMinasAdyacentes() {
        return minasAdyacentes;
    }

    @Override
    public void setMinasAdyacentes(int minasAdyacentes) {
        this.minasAdyacentes = minasAdyacentes;
    }
}