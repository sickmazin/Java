import IO.*;
public class Persona {
    public String nome; // vengono inizializzate di default con null le variabili dinamiche
    public int eta;// in questo caso la variabile viene inizializzata a 0 e non rimane non iniz.
   // int[] numeriFortunati;
    public Persona amica; // dato ricorsivo

    public Persona(){ // Posso andare a definire cosa deve fare il costruttore, in questo caso vado a inizializzare le variabili come voglio io prima che esse vengano definite. Utilizzo this per indicare quale variabile va cambiata. 
        this.nome="";
        this.eta=0;
        /* non puo essere inizializzato un array in questo modo this.numeriFortunati = {1,2,3}; bensi va fatto cosi:
        this.numeriFortunati=new int[3];
        numeriFortunati[0]=0;
        numeriFortunati[1]=1;
        numeriFortunati[2]=2; */
        this.amica= null;
    }

    public Persona(String nome, int eta){
        
        this.nome=nome;
        this.eta=eta;
        this.amica=null;
    }
    public String toString() {
        //qui scrivo la stringa che voglio far comparire ogni volta che converto l'oggetto della classe in Stringa:
        String s= "Nome: "+this.nome+" Eta': "+this.eta;
        return s;
        /* s+=" NF: [ ";
         questo ci permette di stampare direttamente tutto in una stringa ed evitare di ricevere in stampa il contenuto della celletta dell'oggetto che sarebbe stato soltanto un indirizzo di memoria che indirizzava alle variabili nell'heap. 
        for (int i = 0; this.numeriFortunati != null && i < this.numeriFortunati.length; i++) {
            s+=this.numeriFortunati[i]+ " ";
        }
        if (this.amica.getNome()!= null) 
            return s+"], Nome persona amica: "+this.amica.getNome();
        else 
            return s+"], Nome persona amica: nome non specificato";*/
    }
    // METODI GETTERS dato un oggetto restituisce il quello che vogliamo,  associato all'oggetto tipo this.nome
    public String getNome() {
        return this.nome;
    }
    
    public int getEta() {
        return this.eta;
    }
    // METODO SETTERS metodo per andare a cambiare la variabile che noi vogliam
    public void setNome(String nome) {
        this.nome=nome;
    }
    public void setEta(int eta) {
        this.eta=eta;
    }
    public Persona getAmica(){
        return this.amica;
    }
    public void setAmica(Persona amica){
        this.amica= amica;
    }

    
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Persona other = (Persona) obj;
        if (this.eta != other.eta)
            return false;
        if(this.nome!= null)
            return this.nome.equals(other.nome);
        else
            return other.nome == null;
    }

    public void leggidaInput() {
        // leggo il nome e l'eta da input
        this.nome=IO.readString("Nome della persona: ");
        this.eta=IO.readInt("Eta' della persona: ");
        
    }
    public  Persona(Persona p) { /*
        costruttore della COPIA PROFONDA, copia che restituisce un oggetto che contiene copie dei valori dell'oggetto principale.
        Si ha un disaccoppiamento tra i 2 oggetti, non è possibile variare i valori dell'oggetto principale attraverso l'oggetto copia 
        Assicura la separazione dei 2 oggetti uguali ma soltanto al primo livello dell'heap,
        infatti se è presente un array uguale per tutti e andiamo a cambiare un valore per un solo oggetto cambierà anche per l'altro.*/
        this.nome=p.nome;
        this.eta=p.eta;
        /*this.numeriFortunati=p.numeriFortunati; 
         COPIA SHALLOW, copia che è solo al primo livello un cambio valore da parte di un oggetto porta il cambiamento anche all'altro. 
         per evitare questo si esegue una copia del genere:
         
        this.numeriFortunati=new int[p.numeriFortunati.length];
        for (int i = 0; i < numeriFortunati.length; i++) {
            this.numeriFortunati[i]=p.numeriFortunati[i];
        */
        }
    }
  
