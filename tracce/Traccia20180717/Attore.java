package Traccia20180717;

public class Attore {
    private String nome;
    private int eta;

    public Attore(String nome, int eta){
        this.nome=nome;
        this.eta=eta;
    }

    public String getNome(){
        return nome;
    }
    public int getEta(){
        return eta;
    }

    public boolean equals(Object o){
        if(o==null) return false;
        if(this==o) return true;
        if(o.getClass()!= this.getClass()) return false;
        Attore a =(Attore)o;
        return a.nome == this.nome && a.eta==eta;
    }

    public String toString() {
        return "Attore " + nome;
    }
    
}
