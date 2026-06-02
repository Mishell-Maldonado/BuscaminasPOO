package modelo;

import java.io.Serializable;
/*Representa una casilla individual en el tablero del Buscaminas.
 Implementa Serializable para permitir guardar y cargar la partida en archivos.
*/
public class Casilla implements Serializable {
	  private static final long serialVersionUID = 1L;
	  
    private boolean mina;
    private boolean descubierta;
    private boolean bandera;
    private int minasAdyacentes;
    
    //Constructor por defecto. Inicializa la casilla vacía, oculta y sin minas.
    public Casilla() {
        this.mina = false;
        this.descubierta = false;
        this.bandera = false;
        this.minasAdyacentes = 0;
    }

    public boolean isMina() {
        return mina;
    }

    public void setMina(boolean mina) {
        this.mina = mina;
    }

    public boolean isDescubierta() {
        return descubierta;
    }

    public void setDescubierta(boolean descubierta) {
        this.descubierta = descubierta;
    }

    public boolean isBandera() {
        return bandera;
    }

    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }

    public int getMinasAdyacentes() {
        return minasAdyacentes;
    }

    public void setMinasAdyacentes(int minasAdyacentes) {
        this.minasAdyacentes = minasAdyacentes;
    }
}