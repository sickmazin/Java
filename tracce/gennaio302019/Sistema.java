package gennaio302019;

import java.util.ArrayList;

import IO.IO;



public class Sistema {
    private ArrayList<Autore> A;
    private ArrayList<Pubblicazione> pub;
    public Sistema(ArrayList<Autore> A, ArrayList<Pubblicazione> pub){
        this.A=A;
        this.pub=pub;
    }
    public ArrayList<String> pubblicazioniCittà(String s){//Il metodo restituisce la lista dei codici delle pubblicazioni redatte solo da autori residenti nella città s.  
        ArrayList<String> ret= new ArrayList<>();
        for (Pubblicazione pubb : pub) {
            for (Autore i : pubb.getAutori()) {
            if(i.getCitta()==s) ret.add(pubb.getCodice());
        }}
        return ret;
    }
    public ArrayList<Autore> individuali(int d1, int d2){//Il metodo restituisce la lista degli autori di pubblicazioni a singolo nome nel periodo compreso tra la data d1 e la data d2.
        ArrayList<Autore> ret= new ArrayList<>();
        for (Pubblicazione i : pub) {
        if (i.getData()>=d1 && i.getData()<=d2 && i.getAutori().size()==1) 
            ret.add(i.getAutori().get(0));
        }
        return ret;
    }
    public ArrayList<Pubblicazione> coautori(Autore a, Autore b){//Il metodo restituisce la lista delle pubblicazioni scritte congiuntamente dagli autori a e b 
        //(eventualmente insieme ad altri), ordinata secondo la data di pubblicazione dei lavori.
        ArrayList<Pubblicazione> ret= new ArrayList<>();
        for (Pubblicazione pubblicazione : pub) {
            if(pubblicazione.getAutori().contains(a)&&pubblicazione.getAutori().contains(b))
                ret.add(pubblicazione);
        }
        for (Pubblicazione pubblicazione : ret) {
            for (Pubblicazione pubblicazione2 : ret) {
                if(pubblicazione2.getData()<pubblicazione.getData())
                    pubblicazione2=pubblicazione;
            }
        }
        return ret;
    }
    public Sistema(int i,String codice, String titolo, String[] autori, int data){
        this.pub.get(i).setCodice(codice);
        this.pub.get(i).setTitolo(titolo);
        this.pub.get(i).setData(data);
        this.pub.get(i).setAutori(new ArrayList<>());
        for (String string : autori) {
            for (Autore a : A) {
            if(string==a.getNome()) pub.get(i).getAutori().add(a);
        }}
    }
    public static void main(String[] args) {
        ArrayList<Autore> A=new ArrayList<>();
        Autore a1 = new Autore("Rossi", "Roma");
        A.add(a1);
        Autore a2 = new Autore("Bianchi", "Torino");
        A.add(a2);
        Autore a3 = new Autore("Verdi","Cosenza");
        A.add(a3);
        Autore a4 = new Autore("Neri","Cosenza");
        A.add(a4);
        Autore a5 = new Autore("Marroni","Milano");
        A.add(a5);
        Autore a6 = new Autore("Gialli","Milano");
        A.add(a6);
        ArrayList<Pubblicazione> pub=new ArrayList<>();
        IO.print(pub);
    }   
}
