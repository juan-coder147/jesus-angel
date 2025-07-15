package Clases;



public class Lista_Doble {

    private Nodo_Doble primero;
    private Nodo_Doble ultimo;
    private int tamanio;

    public Lista_Doble() {
        this.primero = null;
        this.ultimo = null;
        this.tamanio = 0;
    }

    public Nodo_Doble getPrimero() {
        return primero;
    }

    public void setPrimero(Nodo_Doble primero) {
        this.primero = primero;
    }

    public Nodo_Doble getUltimo() {
        return ultimo;
    }

    public void setUltimo(Nodo_Doble ultimo) {
        this.ultimo = ultimo;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public boolean Vacia() {
        return primero == null && ultimo == null;
    }

    public void InsertarPrimero(Object dato) {
        if (Vacia()) {
            primero = ultimo = new Nodo_Doble(dato);
        } else {
            Nodo_Doble nuevo = new Nodo_Doble(dato, primero, null);
            primero.setAnterior(nuevo);
            primero = nuevo;
        }
        tamanio++;
    }

    public void InsertarUltimo(Object dato) {
        if (Vacia()) {
            primero = ultimo = new Nodo_Doble(dato);
        } else {
            Nodo_Doble nuevo = new Nodo_Doble(dato, null, ultimo);
            ultimo.setSiguiente(nuevo);
            ultimo = nuevo;
        }
        tamanio++;
    }

    public void EliminarPrimero() {
        if (!Vacia()) {
            if (primero == ultimo) {
                primero = ultimo = null;
            } else {
                primero = primero.getSiguiente();
                primero.setAnterior(null);
            }
            tamanio--;
        }
    }

    public void EliminarUltimo() {
        if (!Vacia()) {
            if (primero == ultimo) {
                primero = ultimo = null;
            } else {
                ultimo = ultimo.getAnterior();
                ultimo.setSiguiente(null);
            }
            tamanio--;
        }
    }

    public String PrimeroUltimo() {
        String l = "Lista Vacía";
        if (!Vacia()) {
            l = "";
            Nodo_Doble aux = primero;
            while (aux != null) {
                l += aux.getDato() + " \n";
                aux = aux.getSiguiente();
            }
        }
        return l;
    }

    public String UltimoPrimero() {
        String l = "Lista Vacía";
        if (!Vacia()) {
            l = "";
            Nodo_Doble aux = ultimo;
            while (aux != null) {
                l += aux.getDato() + " \n";
                aux = aux.getAnterior();
            }
        }
        return l;
    }

    public Object Buscar(Object dato) {
        if (!Vacia()) {
            Nodo_Doble aux = primero;
            while (aux != null) {
                if (dato.getClass().equals(aux.getDato().getClass())) {
                    if (dato.equals(aux.getDato())) {
                        return dato;
                    }
                }
                aux = aux.getSiguiente();
            }
        }
        return null;
    }

    public void EliminarPares() {
        if (!Vacia()) {
            Nodo_Doble aux = primero;
            while (aux != null) {
                if (((int) (primero.getDato())) % 2 == 0) {
                    EliminarPrimero();
                    aux = primero;
                } else if (((int) (aux.getDato())) % 2 == 0) {
                    if (aux == ultimo) {
                        EliminarUltimo();
                    } else {
                        aux.getAnterior().setSiguiente(aux.getSiguiente());
                        aux.getSiguiente().setAnterior(aux.getAnterior());
                        tamanio--;
                    }
                    aux = aux.getSiguiente();
                } else {
                    aux = aux.getSiguiente();
                }
            }
        }
    }

    public void InsertarOrdenado(int dato) {
        if (Vacia()) {
            InsertarPrimero(dato);
        } else {
            if (dato <= (int) (primero.getDato())) {
                InsertarPrimero(dato);
            } else if (dato >= (int) (ultimo.getDato())) {
                InsertarUltimo(dato);
            } else {
                Nodo_Doble aux = primero;
                while (((int) (aux.getSiguiente().getDato())) < dato) {
                    aux = aux.getSiguiente();
                }
                Nodo_Doble nuevo = new Nodo_Doble(dato, aux.getSiguiente(), aux);
                aux.getSiguiente().setAnterior(nuevo);
                aux.setSiguiente(nuevo);
                tamanio++;
            }
        }
    }

    public int[] sumaParesImpares() {
        int[] suma = new int[2];
        if (!Vacia()) {
            Nodo_Doble aux = primero;
            for (int i = 1; i <= tamanio; i++) {
                if (i % 2 == 0) {
                    suma[0] += (int) (aux.getDato());
                } else {
                    suma[1] += (int) (aux.getDato());
                }
                aux = aux.getSiguiente();
            }
        }
        return suma;
    }

    public void eliminarParImpar() {
        if (!Vacia()) {
            int[] n = sumaParesImpares();
            if (n[0] != n[1]) {
                EliminarPrimero();
                int t = tamanio;
                Nodo_Doble aux2 = null;
                if (t % 2 == 0) {
                    aux2 = ultimo;
                }
                Nodo_Doble aux = primero;
                while (aux.getSiguiente() != aux2) {
                    aux.setSiguiente(aux.getSiguiente().getSiguiente());
                    aux.getSiguiente().setAnterior(aux);
                    tamanio--;
                    aux = aux.getSiguiente();
                }
                ultimo = aux;
                ultimo.setSiguiente(null);
            } else {
                int t = tamanio;
                Nodo_Doble aux = primero;
                if (t % 2 == 0) {
                    while (aux.getSiguiente() != ultimo) {
                        aux.setSiguiente(aux.getSiguiente().getSiguiente());
                        aux.getSiguiente().setAnterior(aux);
                        tamanio--;
                        aux = aux.getSiguiente();
                    }
                    ultimo = aux;
                    ultimo.setSiguiente(null);
                    tamanio--;
                } else {
                    while (aux != ultimo) {
                        aux.setSiguiente(aux.getSiguiente().getSiguiente());
                        aux.getSiguiente().setAnterior(aux);
                        tamanio--;
                        aux = aux.getSiguiente();
                    }
                }

            }
        }
    }
    
    public void vaciarLista(){
        while(primero != null){
            EliminarPrimero();
        }
    }

}
