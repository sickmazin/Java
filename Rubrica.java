import IO.IO;

public class Rubrica {
    Persona[] array;
    int cnt;
    
    /* definire una classe rubrica . al suo interno, la classe rubrica ha un array  arrayPErsone di oggetti Persona. Quando viene creata un oggetto Rubrica, va indicato il numero massimo di persone. La classe è anche caratterizzata da un numero intero cnt che indica quante cellle di arrayPersona sono state utilizzate. La rubrica offre i seguenti metodi: 
boolean insPersona(Persona p): inserisce p nella prima cella vuota, restituisce false se non ci sono disponibili celle 
PErsona personaAt(int index): restituisce la persona in posizione index di arrayPersone ( null se tale posizione  non è occupata)
boolean rimuoviPersona(Persona p): rimuove la persona nella cella piu a destra e rende la cella disponibile ad ospitare una nuova persona

implementare un main dove viene istanziato un oggetto di tipo rubrica e viene utilizzato per ospitare persone via via inserite da input. Una volta inserite le persone visualizzare il contenuto  della rubrica provando ad effettuare rimozioni tramite rimuoviPersona()
*/
    public  Rubrica(int n,int m) {
        this.array=new Persona[n];
        for (int i = 0; i < m; i++) {
            array[i]=new Persona();
        }
        for (int i = m; i < array.length; i++) {
            this.array=null;
        }
        this.cnt=m;
    }
    public boolean insPersona(Persona p){
        for (int i = 0; i < array.length && cnt<array.length; i++) {
            if (array[i].nome==null) {
                array[i]=p;
                this.cnt++;
                return true;
            }
        }
        return false;
    }
    public Persona personaAt(int index) {
        if(this.array[index]!=null)
            return this.array[index];
        else 
            return null;
    }
    public boolean rimuoviPersona(Persona p){
        for (int i = array.length-1; i > 0 ; i++) {
            if (array[i]!=null) {
                array[i]=null;
                array[i]=p;
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int n=IO.readInt("Quante persone vuoi nella tua rubrica? ");
        Rubrica r=new Rubrica(n,2);
        for (int i = 0; i < r.array.length; i++) {
            int a=IO.readInt("0 se non hai contatti da aggiungere, 1 se vuoi aggiungere un nuovo contatto ");
            if (a==1){
            r.array[i].nome=IO.readString("Nome del contattom num "+i+" ");
            r.array[i].eta=IO.readInt("Eta' del contattom num "+i+" ");
            }
        }
        for (int i = 0; i < r.array.length; i++) {
            if (r.array[i].nome!=null) {
                IO.println("Contatto numero "+i+" = Nome: "+r.array[i].nome+" Eta': "+r.array[i].eta);
            } else {
                IO.println("il contatto numero "+i+" e' vuoto");
            }
            
        }
        
    }
}
