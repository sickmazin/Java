import IO.IO;

public class tipiDiDati {
    // un tipo di dato in java si chiama classe, il main è quello che serve per eseguire il codice. Possono essere definite anche per definire dei dati specifici come può essere una rubrica.  al suo interno contiene la lsita dei dati che servono.

    public static void main(String[] args) {
        Persona p= new Persona(); // inizializzazione, sfrutto la classe creata dove vado a dividere i vari dati. in questo p è un oggetto della classe , new... è il processo di costruzione e Persona() è il costruttore.

        IO.println("variabili prima di essere definite, esse però sono già inizializzate come= Nome:  "+p.nome+" ed eta: "+p.eta);

        p.nome= "Mattia";
        p.eta= 19;
        IO.println("Le variabili dopo essere state definite= Nome: "+p.nome+" ed eta: "+p.eta);
    }
}

/* creare un vettore di persone.
 leggere da input la persona in posizione i (nome e eta) per ogni posizione del vettore . Visualizzare le persone inserite in ordine inverso. */

//matrice int [][] m= new int [10][10]