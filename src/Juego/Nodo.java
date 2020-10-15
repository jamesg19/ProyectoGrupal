package Juego;

/**
 *
 * @author hectoradolfo
 */
public class Nodo {
    
    private String dato;
    private Nodo arriba;
    private Nodo abajo;

    /**
     * @return the dato
     */
    public String getDato() {
        return dato;
    }

    /**
     * @param dato the dato to set
     */
    public void setDato(String dato) {
        this.dato = dato;
    }

    /**
     * @return the arriba
     */
    public Nodo getArriba() {
        return arriba;
    }

    /**
     * @param arriba the arriba to set
     */
    public void setArriba(Nodo arriba) {
        this.arriba = arriba;
    }

    /**
     * @return the abajo
     */
    public Nodo getAbajo() {
        return abajo;
    }

    /**
     * @param abajo the abajo to set
     */
    public void setAbajo(Nodo abajo) {
        this.abajo = abajo;
    }
    
}
