package febbraio172021;

public class Componente {
    private String codice;
    private float prezzo;
    public Componente(String codice, int prezzo) {
        this.codice = codice;
        this.prezzo = prezzo;
    }
    public String toString() {
        return "Componente [codice=" + codice + ", prezzo=" + prezzo + "]";
    }
    public String getCodice() {
        return codice;
    }
    public void setCodice(String codice) {
        this.codice = codice;
    }
    public float getPrezzo() {
        return prezzo;
    }
    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Componente other = (Componente) obj;
        return codice.equals(other.codice);
    }
    
}
