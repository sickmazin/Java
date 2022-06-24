package gennaio302018;
import java.util.*;

public class Supermercato {
    ArrayList<Articolo> articoli;
    ArrayList<Cliente> clienti;
    ArrayList<Acquisto> acquisti;
    public Supermercato(ArrayList<Articolo> articoli, ArrayList<Cliente> clienti, ArrayList<Acquisto> acquisti) {
        this.articoli = articoli;
        this.clienti = clienti;
        this.acquisti = acquisti;
    }
    public ArrayList<String> articoliCittà (String s){
        //Il metodo restituisce la lista dei nomi degli articoli che sono stati acquistati da almeno due clienti residenti nella città s. 
        ArrayList<String> ret= new ArrayList<>();
        for (Articolo a : articoli) {
            if(acquistatoDa(s,a)>=2) ret.add(a.getNome());
        }
        return ret;
    }
    private int acquistatoDa(String s,Articolo art) {
        int c=0; 
        ArrayList<Articolo> ret = new ArrayList<>(); 
        for (Acquisto a : acquisti) {
            if(a.getCliente().getCitta()==s) ret.addAll(a.getAcquisti());
        }
        for (Articolo articolo : ret) {
            if(articolo.equals(art)) c++;
        }
        return c;
    }
    public ArrayList<Articolo> articoliCostosi (int d, double p){
        //Il metodo restituisce la lista degli articoli che costano più di p euro e che sono stati venduti in data d.  
        ArrayList<Articolo> ret = new ArrayList<>();
        for (Acquisto a : acquisti) {
            if (a.getData()==d) {
                for (Articolo art : a.getAcquisti()) {
                    if(art.getPrezzo()>=p && !ret.contains(art)) ret.add(art);
                }
            }
        }
        return ret;
    }
    public ArrayList<Cliente> clientiTop (int di, int df){
        //Il metodo restituisce la lista ordinata (in senso decrescente) dei 3 migliori clienti nel periodo 
        //compreso tra la data di e la data df, cioè la lista dei clienti che hanno effettuato la spesa 
        //complessiva più alta in quel periodo di tempo. (N.B. per “spesa complessiva” di un cliente si intende 
        //la somma dei prezzi di tutti gli articoli che ha acquistato). 
        ArrayList<Cliente> ret = new ArrayList<>();
        ArrayList<Integer> speseCompl= new ArrayList<>();
        for (Acquisto a : acquisti) {
            if(a.getData()>=di && a.getData()<=df) speseCompl.add(spesacomplessiva(a.getAcquisti()));
        }   

        for (Integer s : speseCompl) {
            if(max(s,speseCompl)) {ret.add(clienteDaSpesa(s,di,df)); speseCompl.remove(s);}
        }
        return ret;
    }
    private Cliente clienteDaSpesa(Integer s, int di, int df) {
        for (Acquisto a : acquisti) {
            if(a.getData()>=di && a.getData()<=df && spesacomplessiva(a.getAcquisti())==s ) return a.getCliente();
        }
        return null;
    }
    private boolean max(Integer s, ArrayList<Integer> speseCompl) {
        int max=-1;
        for (Integer i : speseCompl) {
            if(i>max) max= i;
        }
        return max==s;
    }
    private Integer spesacomplessiva(ArrayList<Articolo> acquisti) {
        Integer c=0;
        for (Articolo a : acquisti) {
            c= (int) (c+a.getPrezzo());
        }
        return c;
    }
    public static void main(String[] args) {
        Cliente c1 = new Cliente("RSS", "Rossi", "Roma");
        Cliente c2 = new Cliente("BNC", "Bianchi", "Torino");
        Cliente c3 = new Cliente("VER", "Verdi", "Cosenza");
        Cliente c4 = new Cliente("NER", "Neri", "Cosenza");
        Cliente c5 = new Cliente("MAR", "Marroni", "Milano");
        Cliente c6 = new Cliente("GIA", "Gialli", "Milano");

        Articolo a1 = new Articolo("art1", "Pasta", 0.50);
        Articolo a2 = new Articolo("art2", "Legumi", 1.30);
        Articolo a3 = new Articolo("art3", "Pane", 2.90);
        Articolo a4 = new Articolo("art4", "Cereali", 1.52);
        Articolo a5 = new Articolo("art5", "Salsa", 1.89);
        Articolo a6 = new Articolo("art6", "Caffè", 4.36);
        Articolo a7 = new Articolo("art7", "Tè",  1.99);
        Articolo a8 = new Articolo("art8", "Latte", 2.19);

        Acquisto b1 = new Acquisto(c1, 1, new ArrayList<>(Arrays.asList(a1, a1, a3)));
        Acquisto b2 = new Acquisto(c2, 1, new ArrayList<>(Arrays.asList(a1, a4)));
        Acquisto b3 = new Acquisto(c1, 2, new ArrayList<>(Arrays.asList(a2, a5)));
        Acquisto b4 = new Acquisto(c2, 3, new ArrayList<>(Arrays.asList(a3, a6, a8)));
        Acquisto b5 = new Acquisto(c3, 3, new ArrayList<>(Arrays.asList(a1, a2, a3)));
        Acquisto b6 = new Acquisto(c4, 4, new ArrayList<>(Arrays.asList(a2, a6, a6)));
        Acquisto b7 = new Acquisto(c5, 5, new ArrayList<>(Arrays.asList(a4, a8)));
        Acquisto b8 = new Acquisto(c4, 6, new ArrayList<>(Arrays.asList(a2, a3, a8)));
        Acquisto b9 = new Acquisto(c4, 7, new ArrayList<>(Arrays.asList(a1, a4, a6, a7, a8)));
        Acquisto b10 = new Acquisto(c6, 7, new ArrayList<>(Arrays.asList(a2, a2)));
        Acquisto b11 = new Acquisto(c6, 8, new ArrayList<>(Arrays.asList(a1, a4, a8)));
        Acquisto b12 = new Acquisto(c6, 9, new ArrayList<>(Arrays.asList(a3, a5, a6)));

        ArrayList<Cliente> clienti = new ArrayList<>();
        clienti.add(c1);
        clienti.add(c2);
        clienti.add(c3);
        clienti.add(c4);
        clienti.add(c5);
        clienti.add(c6);

        ArrayList<Articolo> articoli = new ArrayList<>();
        articoli.add(a1);
        articoli.add(a2);
        articoli.add(a3);
        articoli.add(a4);
        articoli.add(a5);
        articoli.add(a6);
        articoli.add(a7);
        articoli.add(a8);

        ArrayList<Acquisto> acquisti = new ArrayList<>();
        acquisti.add(b1);
        acquisti.add(b2);
        acquisti.add(b3);
        acquisti.add(b4);
        acquisti.add(b5);
        acquisti.add(b6);
        acquisti.add(b7);
        acquisti.add(b8);
        acquisti.add(b9);
        acquisti.add(b10);
        acquisti.add(b11);
        acquisti.add(b12);

        Supermercato s = new Supermercato(articoli,clienti, acquisti);

        System.out.println(s.articoliCittà("Cosenza"));
        System.out.println(s.articoliCostosi(3, 2.0));
        System.out.println(s.clientiTop(1, 5));
    }
}
