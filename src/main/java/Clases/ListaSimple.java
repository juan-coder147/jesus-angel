package Clases;



public class ListaSimple {

    private Nodo primero;
    private Nodo ultimo;
    private int tamanio;

    public ListaSimple() {
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
        return "ListaSimple{" + "primero=" + primero + ", ultimo=" + ultimo + ", tamanio=" + tamanio + '}';
    }

    boolean Vacia() {
        return primero == null && ultimo == null && tamanio == 0;
    }

    public void InsertarP(Object dato) {
        Nodo nuevo = new Nodo(dato, primero);
        if (Vacia()) {
            ultimo = nuevo;
        }
        primero = nuevo;
        tamanio++;
    }

    public void InsertarU(Object dato) {
        Nodo nuevo = new Nodo(dato);
        if (Vacia()) {
            primero = ultimo = nuevo;
        }
        ultimo.setSiguiente(nuevo);
        ultimo = nuevo;
        tamanio++;
    }

    public String Mostrar() {
        String lista = "Lista Vacia";
        if (!Vacia()) {
            lista = "";
            Nodo aux = primero;
            while (aux != null) {
                lista += aux.getDato() + "\n";
                aux = aux.getSiguiente();
            }
        }
        return lista;
    }

    public void EliminarP() {
        if (!Vacia()) {
            if (primero == ultimo) {
                primero = ultimo = null;
            } else {
                primero = primero.getSiguiente();
            }
        }
        tamanio--;
    }

    public void ELiminarU() {
        if (!Vacia()) {
            if (primero == ultimo) {
                primero = ultimo = null;
            } else {
                Nodo aux = primero;
                while (aux.getSiguiente() != ultimo) {
                    aux = aux.getSiguiente();
                }
                ultimo = aux;
                ultimo.setSiguiente(null);
            }
            tamanio--;
        }
    }

    public void InsertarOrdenado(int dato) {
        if (Vacia()) {
            InsertarP(dato);
        } else {
            if (dato <= (int)(primero.getDato())) {
                InsertarP(dato);
            } else if (dato >= (int)(ultimo.getDato())){
                InsertarU(dato);
            }else{
                Nodo aux = primero;
                while(((int)(aux.getSiguiente().getDato())) < dato){
                    aux = aux.getSiguiente();
                }
                Nodo nuevo = new Nodo(dato, aux.getSiguiente());
                aux.setSiguiente(nuevo);
                tamanio++;
            }
        }
    }
    

    
    public int[] SumaParesImpares(){
        int[] suma = new int[2];
        int sumaPar = 0;
        int sumaImpar = 0;
        if (!Vacia()) {
            Nodo aux = primero;
            for (int i = 1; i <= tamanio; i++) {
                if (i%2== 0) {
                    sumaPar+= (int)(aux.getDato());
                }else{
                    sumaImpar += (int)(aux.getDato());
                }
                aux = aux.getSiguiente();
            }
            suma[0] = sumaPar;
            suma[1] = sumaImpar;
        }
        return suma;
    }
    
    public void eliminarPorResultado(int sumaPar, int sumaImpar){
        if (!Vacia()) {
            if (sumaPar == sumaImpar) {
                
            }
        }
    }

}
