package gennaio302019;

public class Autore {
    private String nome;
    private String citta;
    public Autore(){
        this.nome="";
        this.citta="";

    }
    public Autore(String nome, String citta){
        this.nome=nome;
        this.citta=citta;
    }
    public String getCitta() {
        return citta;
    }
    public String getNome() {
        return nome;
    }
    public void setCitta(String citta) {
        this.citta = citta;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String toString() {
        return "Autore: "+this.nome+" citta: "+this.citta+".";
    }
}
