package febbraio172021;

import java.util.LinkedList;

public class Articolo {
    private String Nome;
    private float prezzo;
    private LinkedList<String> componenti;
    
    public Articolo(String nome, float prezzo, LinkedList<String> componenti) {
        this.Nome = nome;
        this.prezzo = prezzo;
        this.componenti = new LinkedList<String>(componenti);
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public LinkedList<String> getComponenti() {
        return new LinkedList<String>(componenti);
    }

    public void setComponenti(LinkedList<String> componenti) {
        this.componenti = new LinkedList<String>(componenti);
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Articolo other = (Articolo) obj;
        return Nome.equals(other.Nome);
    }

    public String toString() {
        return "Articolo [Nome=" + Nome + ", componenti=" + componenti + ", prezzo=" + prezzo + "]";
    }

    

}
