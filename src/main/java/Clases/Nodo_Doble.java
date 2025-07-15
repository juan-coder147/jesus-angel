package Clases;

public class Nodo_Doble {
    private Object dato;
    private Nodo_Doble siguiente;
    private Nodo_Doble anterior;

    public Nodo_Doble(Object dato, Nodo_Doble siguiente, Nodo_Doble anterior) {
        this.dato = dato;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }

    public Nodo_Doble(Object dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public Nodo_Doble getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo_Doble siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo_Doble getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo_Doble anterior) {
        this.anterior = anterior;
    }
 
    
}
