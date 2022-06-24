package febbraio212018;

public class Proprietario {
    private String nome;
    private String citta;
    public Proprietario(String nome, String citta) {
        this.nome = nome;
        this.citta = citta;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCitta() {
        return citta;
    }
    public void setCitta(String citta) {
        this.citta = citta;
    }
    public String toString() {
        return "Proprietario "+ nome;
    }
    public boolean equals(Object o){
        if(o==null) return false;
        if(o==this) return true;
        if(o.getClass()!=this.getClass()) return false;
        Proprietario a= (Proprietario)o;
        return a.nome==nome && a.citta==citta;
    }
}
