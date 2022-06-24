package febbraio172021;

import java.util.LinkedList;
import java.util.ListIterator;

public class Sistema {
    private LinkedList<Articolo> articoli;
    private LinkedList<Componente> componenti;
    public Sistema(LinkedList<Articolo> articoli, LinkedList<Componente> componenti) {
        this.articoli = new LinkedList<Articolo>(articoli) ;
        this.componenti = new LinkedList<Componente>(componenti);
    }
    public String articoloTop(){
        if (articoli.size()==0) return null;
        ListIterator<Articolo> i= articoli.listIterator();
        Articolo artMax= i.next();
        float profittoMax= calcolaProfitto(artMax);
        while(i.hasNext()) {
            Articolo articolo= i.next();
            if (calcolaProfitto(articolo)> profittoMax) {
                profittoMax=calcolaProfitto(articolo);
                artMax=articolo;
            }
        }
        return artMax.getNome();
    }
    private float calcolaProfitto(Articolo articolo) {
        float sommaPrezziComponenti=0;
        LinkedList<String> codiciComp= articolo.getComponenti();
        ListIterator<String> i=codiciComp.listIterator();
        while (i.hasNext()) {
            String codiceComponente= i.next();
            Componente c= trovaComponente(codiceComponente);
            if (c != null) {
                sommaPrezziComponenti+=c.getPrezzo();
            }
        }
        return articolo.getPrezzo()-sommaPrezziComponenti;
    }
    private Componente trovaComponente(String codiceComponente) {
        for (Componente componente : componenti) {
            if(componente.getCodice().equals(codiceComponente))
                return componente;
        }
        return null;
    }
    public LinkedList<String> componentiUniversali() {
        LinkedList<String> ret=new LinkedList<>();
        ListIterator<Componente> i= componenti.listIterator();
        while (i.hasNext()) {
            Componente c= i.next();
            if(eUniversale(c))
                ret.add(c.getCodice());
        }
        return ret;
    }
    private boolean eUniversale(Componente c) {
        ListIterator<Articolo> i= articoli.listIterator();
        while (i.hasNext()) {
            Articolo a= i.next();
            if (!(a.getComponenti().contains((Object)c))) {
                return false;
            }
        }
        return true;
    }
    public LinkedList<String> articoliComponentiCostosi(float p) {
        LinkedList<String> ret= new LinkedList<>();
        ListIterator<Articolo> i= articoli.listIterator();
        while (i.hasNext()) {
            Articolo a= i.next();
            if(haComponentePrezzoMaggiore(a,p))
                ret.add(a.getNome());
        } 
        return ret;
    }
    private boolean haComponentePrezzoMaggiore(Articolo a, float p) {
        LinkedList<String> componenti= a.getComponenti();
        ListIterator<String> i= componenti.listIterator();
        while (i.hasNext()) {
            String codiceComponente= i.next();
            Componente c=trovaComponente(codiceComponente);
            if (c != null) {
                if(c.getPrezzo()>p)
                return true;    
            }
            
        }
        return false;
    }
    
}
