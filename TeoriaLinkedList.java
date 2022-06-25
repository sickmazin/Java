import IO.*;
import java.util.*;

public class TeoriaLinkedList{
    /*Nuova collection, collezione di oggetti. è più effecciente per l'inserimento di oggetti in posizione casuale.
    Composta da una concatenazione di NODE che contengono i valori e il puntatore al valore successivo e al valore precedente.
    Una linkedList nello stack contiene l'indirizzo che punta nell'heap Head e alla Tail che ha sua volta punta ad oggetto di tipo NODE che contiene 
    un info(puntatore per il valore della variabile), un next(indirizzo per il node successivo)e un precedente(indirizzo del NODE precedente).
    Quando si vuole inserire un valore tra 2 NODE allora si va cambiare il next dell'elemento prima e collegarlo all'elemento aggiungo e collegare esso al successivo.
    LinkedList non è ottimizzata per il get perché deve scandire tutta la lista nel caso peggiore.
    
    */
    public static void main(String[] args) {
        LinkedList<Integer> ll=new LinkedList<>(); // non bisogna definire la grandezza poiché non 
        ll.add(3);
        ll.add(4);
        ll.add(5);
        
        IO.println("Lista normale: "+ll);

        LinkedList<Integer> llCopiaCostruttore= new LinkedList<>(ll); // questa non è una copia profonda ma bensi una copia attraverso costruttore quindi non possiamo saperlo.
        IO.println("Lista copia attraverso costruttore: "+llCopiaCostruttore);

        LinkedList<Integer> llAlias=ll;
        IO.println("Lista copia ShalloW: "+llAlias);
        ll.add(100);
        IO.println("\n Cambiamento: ");
        IO.println("Lista normale: "+ll);
        IO.println("Lista copia profonda: "+llCopiaCostruttore); // il cambio valore della lista che copio si ripercuote anche sulla nuova lista ottenuta, ma non l'inserimento di un nuovo valore
        IO.println("Lista copia ShalloW: "+llAlias);
    }
    public static Integer massimo(LinkedList<Integer> ll) {
        if (ll == null || ll.size()==0) return null;
        Integer max=ll.peek();
        ListIterator<Integer> i=ll.listIterator();
        while (i.hasNext()) {
            Integer curr=i.next();
            if (curr!=null && curr.compareTo(max)>0) { // dobbiamo sapere se sono comparabili, cioè se esiste un massimo tra questi oggetti.
                max=curr;
            }
        }
        return max;
    }
/*
la copia attraverso il costruttore va a creare dei nuovi NODE ottenuti da una copia NON PROFONDA della LinkedList che voglio copiare. Per la copia Profonda non esiste un metodo già pronto.
*/
}