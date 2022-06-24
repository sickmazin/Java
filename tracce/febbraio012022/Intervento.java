package febbraio012022;

import java.util.LinkedList;

public class Intervento {
    private String NomeTecnico;
    LinkedList<String> tipiOperazione;
    private int data,durata;
    public Intervento(String nomeTecnico, LinkedList<String> tipiOperazione, int data, int durata) {
        NomeTecnico = nomeTecnico;
        this.tipiOperazione = new LinkedList<>(tipiOperazione) ;
        this.data = data;
        this.durata = durata;
    }
    public String getNomeTecnico() {
        return NomeTecnico;
    }
    public void setNomeTecnico(String nomeTecnico) {
        NomeTecnico = nomeTecnico;
    }
    public LinkedList<String> getTipiOperazione() {
        return tipiOperazione;
    }
    public void setTipiOperazione(LinkedList<String> tipiOperazione) {
        this.tipiOperazione = tipiOperazione;
    }
    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }
    public int getDurata() {
        return durata;
    }
    public void setDurata(int durata) {
        this.durata = durata;
    }
    public boolean equals(Object o){
        if (o==null) return false;
        if(this==o) return true;
        if(o.getClass()!= this.getClass()) return false;
        Intervento a= (Intervento)o ;
        return a.NomeTecnico.equals(NomeTecnico) && a.durata== durata && a.data==data && a.tipiOperazione.equals(tipiOperazione);
    }
}
