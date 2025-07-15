package Clases;

public class Cola {

    private Nodo primero;
    private Nodo ultimo;
    private int tamanio;

    public Cola() {
        this.primero = null;
        this.ultimo = null;
        this.tamanio = 0;
    }

    public Nodo getPrimero() {
        return primero;
    }

    public void setPrimero(Nodo primero) {
        this.primero = primero;
    }

    public Nodo getUltimo() {
        return ultimo;
    }

    public void setUltimo(Nodo ultimo) {
        this.ultimo = ultimo;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    @Override
    public String toString() {
        return "Cola{" + "primero=" + primero + ", ultimo=" + ultimo + ", tamanio=" + tamanio + '}';
    }

    public String mostrar() {
        String cola = "Cola Vacia";
        if (!Vacia()) {
            cola = "";
            Nodo aux = primero;
            while (aux != null) {
                cola += aux.getDato() + "\n";
                aux = aux.getSiguiente();
            }
        }
        return cola;
    }

    public boolean Vacia() {
        return primero == null && ultimo == null && tamanio == 0;
    }

    public void Encolar(Object dato) {
        Nodo nuevo = new Nodo(dato);
        if (Vacia()) {
            primero = nuevo;
        } else {
            ultimo.setSiguiente(nuevo);
        }
        ultimo = nuevo;
        tamanio++;
    }

    public void Desacolar() {
        if (!Vacia()) {
            if (primero == ultimo) {
                primero = ultimo = null;
            } else {
                primero = primero.getSiguiente();
            }
            tamanio--;
        }
    }

    void Eliminar_E(Object dato) {
        if (!Vacia()) {
            int t = tamanio;
            for (int i = 1; i <= t; i++) {
                if (!primero.getDato().equals(dato)) {
                    Encolar(primero.getDato());
                }
                Desacolar();
            }
        }
    }

    void Eliminar_Pos(int posicion) {
        if (!Vacia()) {
            int t = tamanio;
            for (int i = 1; i <= t; i++) {
                if (posicion != i) {
                    Encolar(primero.getDato());
                }
                Desacolar();
            }
        }
    }

    Object BuscarPos(int posicion) {
        if (!Vacia()) {
            Nodo aux = primero;
            for (int i = 1; i <= tamanio; i++) {
                if (i == posicion) {
                    return (aux.getDato());
                }
                aux = aux.getSiguiente();
            }
        }
        return null;
    }

    void UbicarPrimero(int x) {
        if (!Vacia()) {
            int t = tamanio;
            if (x <= t) {
                Object dato = BuscarPos(x);
                Eliminar_Pos(x);
                Nodo nuevo = new Nodo(dato, primero);
                primero = nuevo;
            }
        }
    }
    
    public void EncolarPrioridad(Object dato) {
        if (Vacia()) {
            primero = ultimo = new Nodo(dato);
        } else if ((((Paciente) (dato)).getPrioridad()) < ((Paciente) (primero.getDato())).getPrioridad()) {
            primero = new Nodo(dato, primero);
        } else if (((Paciente) (dato)).getPrioridad() >= ((Paciente) (ultimo.getDato())).getPrioridad()) {
            Encolar(dato);
            tamanio--;
        } else {
            Nodo aux = primero;
            while (((Paciente) (aux.getSiguiente().getDato())).getPrioridad() <= ((Paciente) (dato)).getPrioridad()) {
                aux = aux.getSiguiente();
            }
            Nodo nuevo = new Nodo(dato, aux.getSiguiente());
            aux.setSiguiente(nuevo);
        }
        tamanio++;
    }

}
