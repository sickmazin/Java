package Traccia20180717;
import java.util.*;
public class Gestione{
    private ArrayList<Attore> attori;
    private ArrayList<Spettacolo> spettacoli;

    
    public Gestione(ArrayList<Attore> attori, ArrayList<Spettacolo> spettacoli) {
        this.attori = attori;
        this.spettacoli = spettacoli;
    }
    public int spettacoliRicchi(String t){
        /*Il metodo restituisce il 
        numero massimo di attori recitanti
        in uno spettacolo di tipologia t; */
        int max=-1;
        for(Spettacolo s: spettacoli){
            if (s.getTipologia()==t && s.getAttori().size()>max) max=s.getAttori().size(); 
        }
        return max;
    }
    public ArrayList<Spettacolo> spettacoliGiovani(){
        ArrayList<Spettacolo> ret= new ArrayList<>();
        int etaminima= spettacoloPiuGiovane();
        for(Spettacolo s: spettacoli){
            if(etaSpettacolo(s)==etaminima && !ret.contains(s)) ret.add(s); 
        }
        return ret;
    }
    private int spettacoloPiuGiovane() {
        int min=1001;
        for(Spettacolo s: spettacoli){
            if(etaSpettacolo(s)<min) min= etaSpettacolo(s);
        }
        return min;
    }
    private int etaSpettacolo(Spettacolo s) {
        int etaS=0;
        for (String nomeAT : s.getAttori()) {
            Attore attore= getAttore(nomeAT);
            etaS+=attore.getEta();
        }
        return (etaS/s.getAttori().size());
    }
    
    private Attore getAttore(String nomeAT) {
        for (Attore attore : attori) {
            if(attore.getNome()==nomeAT) return attore;
        }
        return null;
    }
    public ArrayList<Attore> attoriEclettici(){
        ArrayList<Attore> ret= new ArrayList<>();
        ArrayList<String> tipologie= tipologie();
        for (Attore at: attori){
            if(partecipato(at,tipologie) && !ret.contains(at)) ret.add(at);
        }
        return ret;
    }
    private ArrayList<String> tipologie() {
        ArrayList<String> ret= new ArrayList<>();
        for (Spettacolo s : spettacoli) {
            if(!ret.contains(s.getTipologia())) ret.add(s.getTipologia());
        }
        return ret;
    }
    private boolean partecipato(Attore at, ArrayList<String> tipologie) {
        ArrayList<String> tip= new ArrayList<>();
        int c=0;
        for (Spettacolo s : spettacoli) {
            String nome= at.getNome();
            if(!tip.contains(s.getTipologia()) && (s.getAttori().contains(nome))) c++;
        }
        if(c==tipologie.size()) return true;
        return false;
    }
    
    public static void main(String[] args) {

        ArrayList<Attore> attori = new ArrayList<>();
        attori.add(new Attore("Sara", 27));
        attori.add(new Attore("Laura",  28));
        attori.add(new Attore("Andrea",  37));
        attori.add(new Attore("Francesco",  32));
        attori.add(new Attore("Maria",  40));


        ArrayList<Spettacolo> spettacoli = new ArrayList<>();
        spettacoli.add(new Spettacolo(0, "storico", new ArrayList<String>(List.of("Sara", "Francesco"))));
        spettacoli.add(new Spettacolo(1, "musicale", new ArrayList<String>(List.of("Andrea", "Maria"))));
        spettacoli.add(new Spettacolo(2, "storico", new ArrayList<String>(List.of("Sara", "Laura"))));
        spettacoli.add(new Spettacolo(3, "sperimentale", new ArrayList<String>(List.of("Laura", "Maria", "Andrea"))));
        spettacoli.add(new Spettacolo(4, "commedia", new ArrayList<String>(List.of("Laura", "Maria", "Sara", "Andrea"))));
        spettacoli.add(new Spettacolo(5, "storico", new ArrayList<String>(List.of("Andrea", "Francesco", "Sara", "Maria"))));
        spettacoli.add(new Spettacolo(6, "commedia", new ArrayList<String>(List.of("Laura"))));
        spettacoli.add(new Spettacolo(7, "sperimentale", new ArrayList<String>(List.of("Sara", "Laura"))));

        Gestione g = new Gestione(attori, spettacoli);

        System.out.println(g.spettacoliRicchi("storico")); //4
        System.out.println(g.spettacoliGiovani()); //[s2, s7]
        System.out.println(g.attoriEclettici()); //[a3, a5]

    }
}