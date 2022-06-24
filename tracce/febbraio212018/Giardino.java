package febbraio212018;

public class Giardino {
    private int codice;
    private Proprietario proprietario;
    private String indirizzo;
    private int dimensione;
    private Fiore[] fiori;
    private int[] quantita;
    public Giardino(int codice, Proprietario proprietario, String indirizzo, int dimensione, Fiore[] fiori,
            int[] quantita) {
        this.codice = codice;
        this.proprietario = proprietario;
        this.indirizzo = indirizzo;
        this.dimensione = dimensione;
        this.fiori = fiori;
        this.quantita = quantita;
    }
    public int getCodice() {
        return codice;
    }
    public void setCodice(int codice) {
        this.codice = codice;
    }
    public Proprietario getProprietario() {
        return proprietario;
    }
    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }
    public String getIndirizzo() {
        return indirizzo;
    }
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }
    public int getDimensione() {
        return dimensione;
    }
    public void setDimensione(int dimensione) {
        this.dimensione = dimensione;
    }
    public Fiore[] getFiori() {
        return fiori;
    }
    public void setFiori(Fiore[] fiori) {
        this.fiori = fiori;
    }
    public int[] getQuantita() {
        return quantita;
    }
    public void setQuantita(int[] quantita) {
        this.quantita = quantita;
    }
    public String toString() {
        return "Giardino " + codice ;
    }
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Giardino other = (Giardino) obj;
        if (codice != other.codice)
            return false;
        return true;
    }
    
}
