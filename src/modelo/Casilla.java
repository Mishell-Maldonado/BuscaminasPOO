package modelo;

import java.io.Serializable;

public abstract class Casilla implements Serializable, IDescubrible {
    private static final long serialVersionUID = 1L;
    
    private boolean descubierta;
    private boolean bandera;

    public Casilla() {
        this.descubierta = false;
        this.bandera = false;
    }

    public boolean isDescubierta() { return descubierta; }
    public void setDescubierta(boolean descubierta) { this.descubierta = descubierta; }
    public boolean isBandera() { return bandera; }
    public void setBandera(boolean bandera) { this.bandera = bandera; }

    // Métodos abstractos
    public abstract boolean isMina();
    public abstract int getMinasAdyacentes();
    public abstract void setMinasAdyacentes(int minasAdyacentes);
}