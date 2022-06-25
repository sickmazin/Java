import IO.IO;

public class tipidiClassi {
    //GENERIX(costrutto), rende la classe parametrica ad un determinato tipo.

    private static coppiaStringhe estremi(String[] arrays) {
        if (arrays == null || arrays.length==0) {
            return null;
        }
        coppiaStringhe res= new coppiaStringhe(arrays[0], arrays[arrays.length-1]);
        return res;
    }
    private static coppiaPersone estremi(Persona[] arrays) {
        if (arrays == null|| arrays.length==0) {
            return null;
        }
        coppiaPersone res= new coppiaPersone(arrays[0], arrays[arrays.length-1]);
        return res;
    }
    //abbiamo scritto lo stesso metodo però cambiando soltato l'oggetto che è ovviamente diverso. Possiamo andare a scrivere questo metodo in maniera parametrica, cioè senza definire di che tipo è realmente. 
    public static <T>Coppia<T> estremiGenerico(T[] array) {
        if (array == null|| array.length==0) {
            return null;
        }
        Coppia<T> res= new Coppia<>(array[0], array[array.length-1]);
        return res;
    }
    //WRAPPER CLASS, sono delle classi che avvolgono al loro intorno i tipi di base.
    /*
    int n=5 è compreso nello stack
    mentre se vado a scrivere 
    Integer n=5; questo verra contenuto all'interno dell'heap poiche INTEGER è una wrapper class che contiene i vari tipi di numeri e nello stack la variabile legata conterra l'indirizzo che nell'heap contiene il valore di essa.
    */

   
    public static void main(String[] args) {
        String[] array=new String[3];
        array[0]="aaa";
        array[1]="bbb";
        array[2]="ccc";
        coppiaStringhe cs=estremi(array);
        IO.println(cs);
        Coppia<String> c= estremiGenerico(array);
        IO.println(c);
        Coppia<Persona> cp= new Coppia<Persona>(new Persona(), new Persona());
        IO.println(cp);
        Persona[] p=new Persona[2];
        estremi(p);
    }
}
