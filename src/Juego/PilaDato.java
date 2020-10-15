package Juego;

/**
 *
 * @author hectoradolfo
 */
public class PilaDato {

    protected int contador = 0;
    private Nodo inicio;

    /**
     * @return the contador
     */
    public int getContador() {
        return contador;
    }

    /**
     * @return the inicio
     */
    public Nodo getInicio() {
        return inicio;
    }

    public void apilar(Nodo nuevo) {
        contador++;

        if (inicio == null) {
            inicio = nuevo;
        } else {
            nuevo.setAbajo(inicio);
            inicio.setArriba(nuevo);
            inicio = nuevo;
        }
    }

    public void desapilar() {

        if (contador > 0) {
            contador--;
            inicio = inicio.getAbajo();
        }
    }

    public String devolverNodo() {
        return inicio.getDato();
    }
}
