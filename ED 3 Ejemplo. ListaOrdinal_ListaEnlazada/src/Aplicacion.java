public class Aplicacion {

    public static int comprobarUltimo(ListaOrdinal lista){
        if(lista.vacia()) return 0;
        int cont=0, ultimo=0;
        Iterador it = lista.getIterador();
        while (it.hasNext()){
            ultimo = it.next();
            cont++;
        }
        if(ultimo == cont)
            return 0;
        else if(ultimo > cont)
            return 1;
        else return -1;
    }

    public static ListaOrdinal interseccion(ListaOrdinal lista1, ListaOrdinal lista2){
        ListaOrdinal inter = new ListaOrdinal();
        if(!lista1.vacia() && !lista2.vacia()){
            Iterador it = lista1.getIterador();
            while(it.hasNext()){
                int e = it.next();
                if(lista2.contiene(e) && !inter.contiene(e) ){
                    inter.insertar(e);
                }
            }
        }
        return inter;
    }

    public static void main(String[] args) {
        ListaOrdinal lista1 = new ListaOrdinal();
        lista1.insertar(1);
        lista1.insertar(3);
        lista1.insertar(5);
        lista1.insertar(7);

        lista1.mostrar();
        System.out.println(lista1.contieneEjercicio9(8));
        lista1.mostrar();




        //System.out.println("Después de insertar " + lista.getNumElementos() + " elementos:");


    }

}
