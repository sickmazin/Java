
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import IO.IO;
public class esercitazione0804 {
    /*
scrivere un metodo che prende in input un arraylist<Persona> e restituisce un arraylist<Persona> che contiene le persone in input con età>25;
    */
    private static ArrayList<Persona> eta25(ArrayList<Persona> al) {
        if (al == null || al.size()==0) {
            return null;
        }
        ArrayList<Persona> ris=new ArrayList<>();
        Iterator<Persona> it=al.iterator();
        while (it.hasNext()) {
            Persona p=it.next();
            if (p.getEta()>25) {
                ris.add(p);
            }
        }
        return ris;
    }
    /*
    scrivere un metodo che prende in input un arraylist<Persona> e restituisce un arraylist<Persona> che contiene le persone in input con età massima rispetto a tutte le altre;
 */
    private static ArrayList<Persona> etaMax(ArrayList<Persona> persone) {
        if (persone == null || persone.size()==0) {
            return null;
        }
        ArrayList<Persona> ris = new ArrayList<>();
        Iterator<Persona> it=persone.iterator();
        Persona maxP=it.next();
        ris.add(maxP);
        while (it.hasNext()) {
            Persona p=it.next();
            if (maxP.getEta()<p.getEta()) {
                maxP=p;
                ris.clear();
                ris.add(p);
            }else if (maxP.getEta()==p.getEta()) {
                ris.add(p);
            }
        }
        return ris;
    }
    /*
    scrivere un metodo che prende in input un arraylist<String> e ne stampa il contenuto in ordine inverso;
 */
    private static void stampaInverso(ArrayList<String> as) {
        if (as == null || as.size()==0) {
            IO.print("non ci sono elementi da stampare") ;
        }
        else{
            IO.print("[");
            ListIterator<String> lIterator= as.listIterator(as.size());
            while (lIterator.hasPrevious()) {
                IO.print(lIterator.previous()+" ");
            }
        }
        IO.print("]");
    }
    
    private static <T> void stampavettore(ArrayList<T> r) {
        IO.print("[");
        for (Iterator<T> i = r.iterator(); i.hasNext(); ) {
            T value= i.next();
            IO.print(value+" ");
        }
        IO.print("]");
    }


/*
    scrivere un metodo che prende in input un arraylist<String> e lo modifica inserendo dopo ogni strinfa una nuova stringa "PIPPO";
    ["a","b","c"] -->["a","PIPPO","b","PIPPO",c"] 
 */
    private static void modificaLista(ArrayList<String> as, String parola) {
        if (as == null || as.size()==0) {
            IO.print("non ci sono modifiche da eseguire");
        }
        else {
            ListIterator<String> it= as.listIterator();
            while (it.hasNext()) {
                it.next();
                it.add(parola);
            }
        }
    }
    private static void eliminaParola(ArrayList<String> as, String parola ) {
        if (as == null || as.size()==0)   {
            IO.print("non c'e niente da eliminare");
        }else{
            ListIterator<String> it=as.listIterator();
            while (it.hasNext()) {
                String value= it.next();
                if (value.equals(parola)) {
                    it.remove();
                }
                
            }
        }
    }
    
/*
    scerivere un metodo ricorsivo che calcola il massimo in un arraylist<Integer>, usare l'iterator come parametro nelle chiamate ricorsive.
*/
    private static int massimoList(ArrayList<Integer> ar) {
        if (ar == null || ar.size()==0) {
            IO.print("lista vuota o nulla");
            return -1;
        }
        else{
            Iterator<Integer> it=ar.iterator();
            int firstValue=it.next();
            int max= cercamax(ar,it,firstValue);
        return max;
        }
    }
    private static int cercamax(ArrayList<Integer> ar, Iterator<Integer> it, int max) {
        if (!it.hasNext()) {
            return max;
        }
        int value=it.next();
        if (max<value) {
            max=value;            
        }
        return cercamax(ar, it, max);
    }
    public static void main(String[] args) {
        int n=IO.readInt("n= ");
        ArrayList<Persona> persone= new ArrayList<>();
        for (int i = 0; i<n; i++) {
            persone.add(new Persona(IO.readString("Nome Persona "+i+": "),IO.readInt("Eta Persona "+i+": ")));
        }
        stampavettore(persone);

        IO.println("Persone con eta maggiore di 25: ");
        stampavettore(eta25(persone));

        IO.println("Persone con eta maggiore: ");
        stampavettore(etaMax(persone));

        ArrayList<String> parole= new ArrayList<>();
        for (int i = 0; i <n; i++) {
            parole.add(IO.readString("Parola "+i+": "));
        }
        stampavettore(parole);
        IO.println("Vettore al contrario: ");
        stampaInverso(parole);

        IO.println("modificaLista: ");
        modificaLista(parole,  "PIPPO");
    
        IO.println("Cancelliamo la parola: ");
        eliminaParola(parole, "PIPPO");

        n=IO.readInt("n= ");
        ArrayList<Integer> numeri=new ArrayList<>();
        for (int i = 0; i <n; i++) {
            numeri.add(IO.readInt("numero "+i+": "));
        }
        stampavettore(numeri);

        IO.print("max value: ");
        IO.println(massimoList(numeri));
    }
}