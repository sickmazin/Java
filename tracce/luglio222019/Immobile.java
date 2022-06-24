package luglio222019;

import java.util.ArrayList;

public class Immobile {
    private String codice;
    private String via;
    private String città;
    private int dimensione;
    private int valore;
    private ArrayList<Proprietà> proprietari;
    public String getCodice() {
        return codice;
    }
    public void setCodice(String codice) {
        this.codice = codice;
    }
    public String getVia() {
        return via;
    }
    public void setVia(String via) {
        this.via = via;
    }
    public String getCittà() {
        return città;
    }
    public void setCittà(String città) {
        this.città = città;
    }
    public int getDimensione() {
        return dimensione;
    }
    public void setDimensione(int dimensione) {
        this.dimensione = dimensione;
    }
    public int getValore() {
        return valore;
    }
    public void setValore(int valore) {
        this.valore = valore;
    }
    public ArrayList<Proprietà> getProprietari() {
        return proprietari;
    }
    public void setProprietari(ArrayList<Proprietà> proprietari) {
        this.proprietari = proprietari;
    }
    
}
