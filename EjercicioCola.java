public class Principal {
    public static void invertirCola(Cola cola){
        if(!cola.vacia()){
            int e = cola.desencolar();
            invertirCola(cola);
            cola.encolar(e);
        }
    }

    public static int posicionEnCola (Cola cola, int dato){
        int pos = -1;
        for(int i=1; i<=cola.getNumElementos(); i++){
            int e = cola.desencolar();
            if(e==dato){
                pos = i;
            }
            cola.encolar(e);
        }
        return pos;
    }
    public static void sustituirSegmentoImpares (Cola cola){
        int n = cola.getNumElementos();
        if(n>0){
            int suma = 0;
            int e = cola.desencolar();
            n--;
            while (n>0 && e%2!=0){
                suma +=e;
                e = cola.desencolar();
                n--;
            }
            // es que he sacado un par o no hay datos en la cola
            if(suma!=0)
                cola.encolar(suma);
            if(e%2==0)
                cola.encolar(e);
            for(int i=1; i<=n;i++){
                e = cola.desencolar();
                cola.encolar(e);
            }
        }
    }

    public static Cola mezclarColas (Cola cola1, Cola cola2){
        Cola resul = new Cola();
        while (!cola1.vacia() || !cola2.vacia()){
            if(!cola1.vacia()){
                resul.encolar(cola1.desencolar());
            }
            if(!cola2.vacia()){
                resul.encolar(cola2.desencolar());
            }
        }
        return resul;
    }

    public static void main (String [] args) {

        Cola cola = new Cola();
        cola.encolar(1);
        cola.encolar(9);
        cola.encolar(3);
        cola.encolar(7);
        cola.encolar(2);
        cola.encolar(4);
        cola.encolar(5);
        cola.encolar(1);
        cola.mostrar();
        sustituirSegmentoImpares(cola);
        cola.mostrar();


    }

}
