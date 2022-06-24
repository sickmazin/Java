package febbraio212018;

public class Fiore {
    private String nome;
    private double costo;
    public Fiore(String nome, double costo) {
        this.nome = nome;
        this.costo = costo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getCosto() {
        return costo;
    }
    public void setCosto(double costo) {
        this.costo = costo;
    }
    public String toString() {
        return "Fiore "+ nome;
    }
    public boolean equals(Object o){
        if(o==null) return false;
        if(o==this) return true;
        if(o.getClass()!= this.getClass()) return false;
        Fiore a= (Fiore) o;
        return a.nome==nome;
    }
}
