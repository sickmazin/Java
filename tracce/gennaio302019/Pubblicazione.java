package gennaio302019;

import java.util.ArrayList;

public class Pubblicazione {
    private String codice;
    private String titolo;
    private ArrayList<Autore> autori; 
    private ArrayList<String> keywords;
    private int data;
    public Pubblicazione(){
        this.codice="";
        this.titolo= "";
        this.autori= null;
        this.keywords=null;
        this.data=0;
    }
    public Pubblicazione(String codice, String titolo, ArrayList<Autore> autori, int data){
        this.codice=codice;
        this.titolo= titolo;
        this.autori= autori;
        this.keywords=null;
        this.data=data;
    }
    public ArrayList<Autore> getAutori() {
        return autori;
    }
    public String getCodice() {
        return codice;
    }
    public int getData() {
        return data;
    }
    public ArrayList<String> getKeywords() {
        return keywords;
    }
    public String getTitolo() {
        return titolo;
    }
    public void setAutori(ArrayList<Autore> autori) {
        this.autori = autori;
    }
    public void setCodice(String codice) {
        this.codice = codice;
    }
    public void setData(int data) {
        this.data = data;
    }
    public void setKeywords(ArrayList<String> keywords) {
        this.keywords = keywords;
    }
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
}
