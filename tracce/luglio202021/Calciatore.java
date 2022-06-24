package luglio202021;

public class Calciatore {
    private String nome;
    private String  squadra;

    
    public Calciatore(String nome, String squadra) {
        this.nome = nome;
        this.squadra = squadra;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSquadra() {
        return squadra;
    }
    public void setSquadra(String squadra) {
        this.squadra = squadra;
    }
    public boolean equals(Object o){
        if (o == null) return false;
        if(o==this) return true;
        if(o.getClass()!=this.getClass()) return false;
        Calciatore a= (Calciatore) o;
        return a.nome.equals(this.nome) ;

    }
    
}
