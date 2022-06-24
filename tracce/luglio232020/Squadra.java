package luglio232020;

public class Squadra {
    private String nome;
    private String citta;

    public Squadra(String nome, String citta){
        this.nome=nome;
        this.citta=citta;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome=nome;
    }
    public String getCitta(){
        return citta;
    }
    public void setCitta(String citta){
        this.citta=citta;
    }
    public boolean equals(Object o){
        if(o==null) return false;
        if(o==this) return true;
        if(o.getClass() != this.getClass()) return false;
        Squadra a= (Squadra) o;
        return a.nome==this.nome;   
    }
    public String toString() {
        return "Squadra [citta=" + citta + ", nome=" + nome + "]";
    }
}
