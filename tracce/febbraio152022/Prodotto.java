package febbraio152022;

public class Prodotto {
    private String Nome;
    private String Marca;
    private float prezzo;
    public Prodotto(String nome, String marca, int prezzo) {
        this.Nome = nome;
        this.Marca = marca;
        this.prezzo = prezzo;
    }
    public String getNome() {
        return Nome;
    }
    public void setNome(String nome) {
        Nome = nome;
    }
    public String getMarca() {
        return Marca;
    }
    public void setMarca(String marca) {
        Marca = marca;
    }
    public float getPrezzo() {
        return prezzo;
    }
    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }
    public String toString() {
        return "Prodotto [Marca=" + Marca + ", Nome=" + Nome + ", prezzo=" + prezzo + "]";
    }
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj==this) return true;
        if(!(obj instanceof Prodotto)) return false;
        Prodotto a= (Prodotto)obj;
        return a.getNome()==this.getNome();
    }
    
}
