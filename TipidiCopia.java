import IO.IO;

public class TipidiCopia { // LEZIONE 24-03 REGISTRATA INIZIA A 45:00
    public static void main(String[] args) {
        Persona p = new Persona();
        p.leggidaInput();
        // Persona q;  in questo modo contiene un valore indefinito
        Persona q=p; //ALIASING
        IO.print(q);
        /* vado a definire q dandogli lo stesso indirizzo di p. Cosi facendo però non va bene poiché se vado a cambiare una variabile a q cheè una copia di p, vado a cambiare anche la variabile di p. Questa cosa accade solo per i tipi OGGETTI, per i tipi normali tipo int non accade.  */

        // Quando voglio andare a copiare un oggetto e ho definito una classe per esso, allora vado ad aggiungere nella sua classe un nuovo costruttore che mi permette di fare la copia del parametro che inserisco. Va a creare un nuovo oggetto di quel tipo proprio perché si crea attraverso il new.

    }
}
