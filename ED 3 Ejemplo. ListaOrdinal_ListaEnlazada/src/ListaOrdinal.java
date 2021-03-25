public class ListaOrdinal {
    private Nodo inicio;
    private int numElementos;

    public ListaOrdinal() {
        inicio = null;
        numElementos = 0;
    }

    public boolean vacia() {
        return inicio == null;
    }

    /**
     * Inserta el dato en la última posición de la lista
     */
    public void insertar(int dato) {
        // Crear un nodo nuevo
        Nodo nuevo = new Nodo(dato, null);
        // Insertar el nodo al final de la lista enlazada
        if(vacia()){
            inicio = nuevo;
        }else{
            Nodo aux=inicio;
            while (aux.getSiguiente()!=null){
                aux=aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
        }

        numElementos++;
    }


    /**
     * Busca el dato que ocupa la posición recibida como parámetro,
     * en caso de existir.
     */
    public int getElemento(int posicion) {
        // Avanzar en la lista tantos elementos como el parámetro posicion
        Nodo actual = inicio;   // referencia auxiliar para recorrer la lista
        for (int i = 0; i < posicion; i++) {
            actual = actual.getSiguiente();
        }
        return actual.getDato();
    }

    /**
     * Borra el primer elemento de la lista cuyo dato coincide con el
     * parámetro recibido, si existe.
     */
    public boolean borrar(int dato) {
        Nodo actual = inicio;
        Nodo anterior = null;
        while (actual != null && actual.getDato() != dato) {
            anterior = actual;
            actual = actual.getSiguiente();
        }
        if (actual != null) {  // dato encontrado. Borrar nodo actual
            if (actual == inicio) {   // Borrar el primero de la lista
                inicio = actual.getSiguiente();
            } else {  // Borrar nodo que no es el primero
                anterior.setSiguiente(actual.getSiguiente());
            }
            numElementos--;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Devuelve la primera posición en la que se encuentra el dato,
     * en caso de existir. En caso contrario, devuelve -1
     */
    public int posicion(int dato) {
        Nodo actual = inicio;
        int pos = 0;
        while (actual != null && actual.getDato() != dato) {
            actual = actual.getSiguiente();
            pos++;
        }
        if (actual != null) {  // Dato encontrado
            return pos;
        } else {
            return -1;
        }
    }

    /**
     * Determina si el dato recibido como parámetro existe en la lista.
     */
    public boolean contiene(int dato) {
        return this.posicion(dato) >= 0;
    }

    public boolean contieneEjercicio9(int dato) {
        if(!vacia()){
            boolean retorno = contieneEjercicio9Rec(dato);
            if(retorno) {
                Nodo nuevo = new Nodo(dato, inicio);
                inicio = nuevo;
            }
            return retorno;
        }else{
            return false;
        }
    }
    // true o false y además quitae el elemento de la lista
    public boolean contieneEjercicio9Rec(int dato) {
        if(vacia()){
            return false;
        }else{
            if(inicio.getDato()==dato){
                inicio = inicio.getSiguiente();
                return true;
            }else{
                int e = inicio.getDato();
                inicio = inicio.getSiguiente();
                boolean retorno = contieneEjercicio9Rec(dato);
                Nodo nuevo = new Nodo(e, inicio);
                inicio = nuevo;
                return retorno;
            }
        }
    }
    public int getNumElementos() {
        return numElementos;
    }

    public Iterador getIterador() {
        return new Iterador(inicio);
    }

    public void mostrar() {
        if (this.vacia()) {
            System.out.println("Lista vacía");
        } else {
            Nodo actual = inicio;
            System.out.print("[");
            while (actual != null) {
                System.out.print(actual.getDato() + " ");
                actual = actual.getSiguiente();
            }
            System.out.println("]");
        }
    }

    public void duplicarParesQuitarImpares(){
        if(inicio!=null){
            int e;
            e = inicio.getDato();
            inicio = inicio.getSiguiente();
            duplicarParesQuitarImpares();
            if(e%2==0){
                Nodo nuevo1 = new Nodo(e, null);
                Nodo nuevo2 = new Nodo(e, inicio);
                nuevo1.setSiguiente(nuevo2);
                inicio=nuevo1;
            }
        }
    }
}
