public class Principal {

    public static void repetirN (Pila pila, int n){
        if(!pila.vacia()){
            int e = pila.desapilar();
            repetirN(pila,n);
            for(int i=1; i<=n; i++){
                pila.apilar(e);
            }
        }
    }

    public static void borrarElemento(Pila pila, int dato){
        if(!pila.vacia()){
            int e = pila.desapilar();
            borrarElemento(pila,dato);
            if(e!=dato){
                pila.apilar(e);
            }
        }
    }
    public static void apilarReorganizable (Pila pila, int dato){
        borrarElemento(pila,dato);
        pila.apilar(dato);
    }

    private static int comprobarFondo (Pila pila, int contador){
        int resultado = 0;
        if(!pila.vacia()){
            int e = pila.desapilar();
            contador++;
            if(pila.vacia()){
                if(e<contador)
                    resultado=-1;
                else if(e>contador)
                    resultado=1;
            }else{
                resultado=comprobarFondo(pila, contador);
            }
            pila.apilar(e);
        }
        return resultado;
    }
    public static int comprobarFondo (Pila pila){
        return comprobarFondo(pila, 0);
    }

    public static void sumergir (Pila pila, int dato){
        if(!pila.vacia()){
            int e = pila.desapilar();
            sumergir(pila, dato);
            pila.apilar(e);
        }else{
            pila.apilar(dato);
        }
    }
    public static void hacerPilaCapicua (Pila pila){
        if(!pila.vacia()){
            int e = pila.desapilar();
            hacerPilaCapicua(pila);
            pila.apilar(e);
            sumergir(pila,e);
        }
    }
    public static void main (String [] args) {
        Pila pila = new Pila();
        for(int i=1; i<=3; i++){
            pila.apilar(i);
        }
        hacerPilaCapicua(pila);
        pila.mostrar();
        /*
        System.out.println("Practica ED Pilas y Colas de Alumno" + "------Nombre y Apellidos Alumnos---------");
        System.out.println("Numero Matricula:" +"XXXXXXXXX");

        AlgoritmosPila algoritmosPila = new AlgoritmosPila ();
        Pila pila = algoritmosPila.crearPila();
        algoritmosPila.pruebaCopiaPilaRecursivo (pila);
        algoritmosPila.pruebaSumaEnFondo (pila);
        algoritmosPila.pruebaSegunNumQuitar (pila);

        AlgoritmosCola algoritmosCola = new AlgoritmosCola ();
        Cola cola = algoritmosCola.crearCola();
        algoritmosCola.pruebaCopiaCola (cola);
        algoritmosCola.pruebaMediaEnPrimeroCola (cola);
        algoritmosCola.pruebaNumParesImpares(cola);
           */
    }

}
