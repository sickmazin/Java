import java.util.*;
import IO.IO;
public class COLLECTION {
     //COLLECTION, permettono di collezzionare dati, strutture dati dinamiche(oggetti di classe). 
     //Queste collezzioni di informazioni si espandono se devono contenere più informazioni e si restringono se devono eliminare. 

    /*
    ARRAYLIST,struttura dati a memoria quasi infinita. struttura omogenea, cioè contiene oggetti dello stesso tipo. Infatti viene definita prima di che tipo di oggetti sarà composta la lista.
    Nello stack la variabile avrà l'indirizzo dove nell'heap sono presenti l'array che contiene a sua volta un'altro indirizzo e poi la variabile size che contiene il numero di celle dell'array.
    il metodo add ci permette di aggiungere all'array un oggetto anche se esso ha tutte le celle occupate e vogliamo continuare ad aggiungere, infatti esso aumenterà la sua capienza istanziando un nuovo array più grande.
    quando vado ad aggiungere qualcosa in una determinata posizione si effettua lo shifting, le altre celle si spostano verso destra.
    */
    public static void main(String[] args) {
        ArrayList<String> collezzioneStrings= new ArrayList<>(2); // se non vado a specificare nel costruttore il numero di celle che deve contenere, sarà inizializzato a 0
        collezzioneStrings.add("Prima Stringa");
        collezzioneStrings.add("Seconda Stringa");
        collezzioneStrings.add("Terza Stringa");// 2 cellette con bastano, così per aggiungere la terza stringa aumenta la sua capienza.
        IO.println(collezzioneStrings);// esiste un metodo toString() all'interno di ArrayList. 
        collezzioneStrings.add(1,"Nuova Stringa"); // non rimpiazza il valore ma la aggiunge in quella posizione e sposta le altre
        IO.println(collezzioneStrings.get(2));
        int n=IO.readInt("Numero di interi nell'array? ");
        ArrayList<Integer> numInt= new ArrayList<>(n);
        for (int i = 0; i < numInt.size(); i++) {
            numInt.add(IO.readInt("numero in posizione ")+i);
        }
        IO.println(sottoArraypari(numInt));
        rimuoviDispari(numInt);
        IO.print(numInt);
    }
    

    //creare un arraylist di integer , popolarlo di interi presi da input. stampare l'array con le posizioni pari e quello senza le posizioni dispari
    //2) scrivere un metodo che restituisca un arralist di integer in posizioni pari.
    //3) scrivere un metodo che rimuove gli oggetti in posizione dispari.
    private static ArrayList<Integer> sottoArraypari(ArrayList<Integer> l) {
        if (l == null) { return null;}
        ArrayList<Integer> res= new ArrayList<>();
        for (int i = 0; i < l.size(); i++) {
            if (i%2==0) {
                res.add(l.get(i));
            }
        }
        return res;
    }
    private static void rimuoviDispari(ArrayList<Integer> l) {
        if (l == null || l.size()<2) {     return;   }
        for (int i = 1; i < l.size(); i++) {
            l.remove(i);
        }
    }
    // esiste un oggetto che è l'iteratore della collezione definito come Iterator ottenuto con i= l.iterator(); su di esso esistono diversi metodi utili. con i.hasNext(); posso sapere se la celletta successiva esiste. invece con i.Next() ottengo l'elemento successivo e sposto l'iteratore alla cella successiva. i.remove() elimina l'ultimo elemento che l'iteratore ha preso con l'ultimo next invocato.
}