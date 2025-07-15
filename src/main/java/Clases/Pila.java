package Clases;

public class Pila {

    private Nodo cima;
    private int tamanio;

    public Pila() {
        this.cima = null;
        this.tamanio = 0;
    }

    public Nodo getCima() {
        return cima;
    }

    public void setCima(Nodo cima) {
        this.cima = cima;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    @Override
    public String toString() {
        return "Pila{" + "cima=" + cima + ", tamanio=" + tamanio + '}';
    }

    boolean Vacia() {
        return cima == null && tamanio == 0;
    }

    public void Apilar(Object dato) {
        Nodo nuevo = new Nodo(dato, cima);
        cima = nuevo;
        tamanio++;
    }
    public void Apilarpersona(Object dato) {
        Nodo nuevo = new Nodo(dato, cima);
        cima = nuevo;
        tamanio++;
    }

    public void Desapilar() {
        if (!Vacia()) {
            cima = cima.getSiguiente();
            tamanio--;
        }
    }

    public String Mostrar() {
        String pila = "Vacia";
        if (!Vacia()) {
            pila = "";
            Nodo aux = cima;
            while (aux != null) {
                pila += aux.getDato() + "\n";
                aux = aux.getSiguiente();
            }
        }
        return pila;
    }

    public int Sumatoria() {
        int suma = 0;
        if (!Vacia()) {
            Nodo aux = cima;
            while (aux != null) {
                suma += (int) (aux.getDato());
                aux = aux.getSiguiente();
            }
        }
        return suma;
    }

    double Promedio() {
        double promedio = Sumatoria() / (double) (tamanio);
        return promedio;
    }

    String Suma_Promedio() {
        double suma = 0;
        double promedio = 0;
        if (!Vacia()) {
            Nodo aux = cima;
            while (aux != null) {
                suma += (int) (aux.getDato());
                aux = aux.getSiguiente();
                promedio = suma / tamanio * 1.0;
            }
        }
        String mostrar = "Sumatoria " + suma + "\nPromedio: " + promedio;
        return mostrar;
    }

    String Suma_Posiciones() {
        int sumaImpar = 0;
        int sumaPar = 0;
        if (!Vacia()) {
            Nodo aux = cima;
            for (int i = 0; i < tamanio; i++) {
                if (i % 2 == 0) {
                    sumaPar += (int) (aux.getDato());
                } else {
                    sumaImpar += (int) (aux.getDato());
                }
                aux = aux.getSiguiente();
            }
        }
        String calculo = "Suma Par: " + sumaPar + "\nSuma Impar: " + sumaImpar;
        return calculo;
    }

    boolean Buscar(Object x) {
        if (!Vacia()) {
            Nodo aux = cima;
            while (aux != null) {
                if (aux.getDato().equals(x)) {
                    return true;
                }
                aux = aux.getSiguiente();
            }
        }
        return false;
    }

    Object[] BuscarV2(Object x) {
        Object[] dato = new Object[2];
        if (!Vacia()) {
            Pila pila_aux = new Pila();
            while (!Vacia()) {
                if (cima.getDato().equals(x)) {
                    dato[0] = true;
                    dato[1] = pila_aux;
                    return dato;
                }
                pila_aux.Apilar(cima.getDato());
                Desapilar();
            }
        }
        return dato;
    }

    void Eliminar(Object x) {
        if (!Vacia()) {
            if (Buscar(x)) {
                Pila pila_aux = new Pila();
                while (!cima.getDato().equals(x)) {
                    pila_aux.Apilar(cima.getDato());
                    Desapilar();
                }
                Desapilar();
                while (!pila_aux.Vacia()) {
                    Apilar(pila_aux.getCima().getDato());
                    pila_aux.Desapilar();
                }
            }
        }
    }

//    void EliminarV2(Object x){
//        if (!Vacia()) {
//            Nodo aux = cima;
//            Object datos[] = BuscarV2(x);
//            if ((boolean)datos[0]) {
//                Desapilar();
//                pila.
//            }
//        }
//    }
    Pila invertirPila(Pila p) {
        Pila pilaAux = new Pila();
        if (!p.Vacia()) {
            while (!p.Vacia()) {
                pilaAux.Apilar(p.getCima().getDato());
                p.Desapilar();
            }
        }
        return pilaAux;
    }

    Pila CombinarDosPilas(Pila p1, Pila p2) {
        Pila resultado = new Pila();
        if (!p1.Vacia() && !p2.Vacia()) {
            Nodo aux1 = p1.getCima();
            Nodo aux2 = p2.getCima();
            while (aux1 != null || aux2 != null) {
                if (aux1 != null) {
                    resultado.Apilar(aux1.getDato());
                    aux1 = aux1.getSiguiente();
                }
                if (aux2 != null) {
                    resultado.Apilar(aux2.getDato());
                    aux2 = aux2.getSiguiente();
                }
            }
        }
        return resultado.invertirPila(resultado);
    }

    void Ejercicio1_Repeticion(int x) {
        if (!Vacia()) {
            Pila pila_Invertida = invertirPila(this);
            while (!pila_Invertida.Vacia()) {
                for (int i = 0; i < x; i++) {
                    Apilar(pila_Invertida.getCima().getDato());
                }
                pila_Invertida.Desapilar();
            }
        }
    }

    int MenorPila() {
        int menor = 0;
        if (!Vacia()) {
            menor = (int) (cima.getDato());
            Nodo aux = (cima.getSiguiente());
            while (aux != null) {
                if ((int) aux.getDato() < menor) {
                    menor = (int) (aux.getDato());
                }
                aux = aux.getSiguiente();
            }
        }
        return menor;
    }

    void Ejercicio2_BuscarMenor() {
        if (!Vacia()) {
            int menor = MenorPila();
            Pila pi = invertirPila(this);
            Apilar(menor);
            while (!pi.Vacia()) {
                int n = (int) (pi.getCima().getDato());
                if (n != menor) {
                    Apilar(n);
                }
                pi.Desapilar();
            }
        }
    }
    
    public void vaciarpila(){
        while(!Vacia()){
            Desapilar();
        }
    }
}
