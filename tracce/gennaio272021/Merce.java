package gennaio272021;

import java.util.ArrayList;
import java.util.LinkedList;

public class Merce {
    private  String nome;
    private String marca;
    public ArrayList<Fornitore> fornitori;
    public Merce(String nome, String marca, ArrayList<Fornitore> fornitori){
        this.nome=nome;
        this.fornitori=fornitori;
        this.marca=marca;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public void setFornitori(ArrayList<Fornitore> fornitori) {
        this.fornitori = fornitori;
    }
    public LinkedList<String> getFornitori(){
        LinkedList<String> ret= new LinkedList<>();
        for (Fornitore fornitore : fornitori) {
            ret.add(fornitore.getNome());
        }
        return ret;
    }
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if(obj.getClass()!=this.getClass()) return false;
        Merce a= (Merce)obj;
        if(a.nome!=this.nome &&a.marca!=this.marca) return false;
        for (int i=0; i<this.fornitori.size(); i++) {
            if(a.fornitori.get(i)!=this.fornitori.get(i)) return false;
        }
        return true;
    }
    public String toString() {
        return "Merce [fornitori=" + fornitori + ", marca=" + marca + ", nome=" + nome + "]";
    }
    
}   
