package Traccia20180717;
import java.util.ArrayList;

public class Spettacolo {
    private int codice;
    private String tipologia;
    private ArrayList<String>attori;

    public Spettacolo(int c, String t, ArrayList<String> at){
        this.codice=c;this.attori=at;this.tipologia=t;
    }

    public int getCodice() {
        return codice;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public ArrayList<String> getAttori() {
        return attori;
    }

    public void setAttori(ArrayList<String> attori) {
        this.attori = attori;
    }
    public boolean equals(Object o){
        if(o==null) return false;
        if(o==this) return true;
        if(o.getClass()!=this.getClass()) return false;
        Spettacolo a= (Spettacolo)o;
        return a.codice==codice ;
    }

    public String toString() {
        return "Spettacolo "+ codice ;
    }

}
