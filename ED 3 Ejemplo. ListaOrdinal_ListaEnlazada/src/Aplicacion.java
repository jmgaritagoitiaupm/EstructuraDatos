public class Aplicacion {

    public static void main(String[] args) {
        ListaOrdinal lista = new ListaOrdinal();
        lista.insertar(1);
        lista.insertar(2);
        lista.insertar(1);
        lista.insertar(3);
        lista.insertar(6);
        lista.insertar(7);
        lista.mostrar();
        
        lista.duplicarParesQuitarImpares();
        lista.mostrar();
        System.out.println("Después de insertar " + lista.getNumElementos() + " elementos:");


    }

}
