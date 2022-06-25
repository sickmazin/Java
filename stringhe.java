import IO.*;
public class stringhe {
    public static void main(String[] args) {
        String s= "Ciao"; // come inizializzare una variabile di tipo stringa, variabile dinamica, nello stack 
        //viene creata una cella che contiene l'indirizzo di memoria.  nell' Heap corrispondente all'indirizzo 
        //contiene i singoli caratteri che formano la stringa. Stesso comportamento del'array, è definibile un array 
        //di caratteri però la stringa è un oggetto di classe. Segue quindi le regole delle classi. Con le stringhe non 
        //possiamo accedere al contenuto della stringa nella posizione precisa con s[1] non è possibile. è possibile fare
        // questo attraverso l'utilizzo dei metodi(funzioni). 
        String s1= new String("Ciao ancora"); // altro metodo per creare una stringa, non c'è differenza 
        IO.println(s); 
        //per andare a estrarre un carattere in una posizione precisa userò char at 
        IO.println(s.charAt(2));
        for (int i = 0; i < s.length() /*per le stringhe bisogna aggiungere le parentesi a lenght per ottenere la lunghezza */; i++) {
            IO.println(s.charAt(i));
        }
        String m= "abc";
        String s2 = "abc";
        IO.print("la stringa da te inserita è :");
        if (m.compareTo(s1)<0)
        IO.print("lessicograficamente minore di"+ s2);
        else    
            if (m.compareTo(s2)>0)
                IO.print("lessicograficamente maggiore di"+s2);
            else 
                if (m.equals(s1)) // verifico l'uguaglianza attraverso equals, non è possibile utilizzare
                // == poiché compara il contenuto  delle due variabili quindi compara se le 2 variabili indirizzano agli stessi caratteri nell' heap
                IO.print("uguale alla stringa"+m);
    
            /*
            un ottimizzatore di java permette al programma di capire se 2 stringhe  avranno lo stesso contenuto, 
            se è cosi allora in questo caso le 2 stringhe avranno gli stessi caratteri nell'heap. 
            Le 2 stringhe avranno lo stesso indirizzo di memoria. In questo caso l' == ci dirà che sono uguali. 
            Questa cosa vale solo quando le 2 variabili sono uguali dall'inizializzazione ma non vale se le variabili coincidono dopo.

            2 vettori non avranno mai lo stesso indirizzo di memoria, 
            poiché se assegno ad uno di loro un valore allora anche l'altro vettore va a cambiare.
             Questa cosa per le stringhe non vale poiché sono oggetti costanti e quindi non è possibile cambiarli .
            
            */
            String new_S= s.replace('a', 'b'); // va a copiare la stringa che consideriamo e 
            //cambiare l'oldChar con il newChar creando una nuova stringa e non rimpiazzandola.
            IO.print(new_S);
            s= s.replace('a', 'c'); // in questo caso vado a cambiare la variabile iniziale 
        }

        // le stringhe in java hanno già da se un metodo toString che permette di stampare
        //  direttamente il valore della variabile stringa invece di ottenere l'indirizzo di memoria
}
