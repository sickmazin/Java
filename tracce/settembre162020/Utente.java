package settembre162020;

public class Utente{
    private String Nome;
    private String citta;

    public Utente(String nome, String citta){
        this.Nome= nome;
        this.citta=citta;
    }
    public String getNome(){
        return Nome;
    }
    public void setNome(String nome){
        this.Nome=nome;
    }
    public String getCitta(){
        return citta;
    }
    public void setCitta(String citta){
        this.citta=citta;
    }
    public String toString() {
        return "Utente nome: "+Nome+", citta: "+citta+".";
    }
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if(obj==this) return true;
        if(obj.getClass()!= this.getClass()) return false;
        Utente a = (Utente)obj;
        return a.Nome.equals(this.Nome);
    }
}