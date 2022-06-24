package settembre242018;

public class Produttore {
    private int codice;
    private String nome;
    private String nazione;
    public Produttore(int codice, String nome, String nazione) {
        this.codice = codice;
        this.nome = nome;
        this.nazione = nazione;
    }
    public int getCodice() {
        return codice;
    }
    public String getNome() {
        return nome;
    }
    public String getNazione() {
        return nazione;
    }
    public String toString() {
        return "Produttore " + codice;
    }
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Produttore other = (Produttore) obj;
        if (codice != other.codice)
            return false;
        return true;
    }
    
}
