package gennaio272021;

public class Fornitore {
    private String nome;
    private String citta;
    public Fornitore(String nome, String citta){
        this.nome=nome;
        this.citta=citta;
    }
    public String getNome(){
        return this.nome;
    }
    public String getCitta(){
        return this.citta;
    }
    public void setCitta(String citta) {
        this.citta = citta;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String toString() {
        return "Nome: "+this.nome+" citta: "+this.citta;
    }
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o.getClass()!=this.getClass()) return false;
        Fornitore a= (Fornitore) o;
        return a.nome==this.nome && a.citta==this.citta;
    }
}
