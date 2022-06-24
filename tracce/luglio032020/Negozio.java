package luglio032020;

public class Negozio{
    private String nome;
    private String citta;
    public  Negozio(String nome, String citta) {
        this.nome=nome;
        this.citta=citta;
    }
    public String getCitta() {
        return citta;
    }
    public String getNome() {
        return nome;
    }
    public String toString() {
        return "Nome negozio: "+nome+" città: "+citta;
    }
    public boolean equals(Object o) {
        if (o == null) return false;
        if(o==this) return true;
        if(o.getClass()!=this.getClass()) return false;
        Negozio n= (Negozio)o;
        return this.nome.equals(n.nome) && this.citta.equals(n.citta);
    }

}