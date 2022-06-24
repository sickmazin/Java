package gennaio302018;

public class Articolo {
    private String codice;
    private  String nome;
    private double prezzo;
    public Articolo(String codice, String nome, double prezzo) {
        this.codice = codice;
        this.nome = nome;
        this.prezzo = prezzo;
    }
    public String getCodice() {
        return codice;
    }
    public String getNome() {
        return nome;
    }
    public double getPrezzo() {
        return prezzo;
    }
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Articolo other = (Articolo) obj;
        if (codice != other.codice)
            return false;
        return true;
    }
    @Override
    public String toString() {
        return " " + codice;
    }
    
}
