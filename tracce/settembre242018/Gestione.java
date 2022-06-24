package settembre242018;

import java.util.ArrayList;
import java.util.List;

public class Gestione {
    ArrayList<Farmaco> farmaci;
    ArrayList<Produttore> produttori;
    ArrayList<String> princiAttivi;

    public Gestione(ArrayList<Farmaco> farmaci, ArrayList<Produttore> produttori, ArrayList<String> princiAttivi) {
        this.farmaci = farmaci;
        this.produttori = produttori;
        this.princiAttivi = princiAttivi;
    }

    public String farmacoCaro(String p){
        //Il metodo restituisce, fra i farmaci realizzati con il principio attivo p, il nome del farmaco con costo maggiore.
        double max=-1;
        String ret= "";
        for(Farmaco f: farmaci){
            if(f.getPrincipiAttivi().contains(p) && f.getPrezzo()>=max) {
                ret=f.getNome();
                max=f.getPrezzo();
            }
        }
        return ret;
    }

    public ArrayList<Produttore> esclusivisti(){
        ArrayList<Produttore> ret= new ArrayList<>();
        for (Produttore p : produttori) {
            if(prodEqu(p)>=1) ret.add(p);
        }
        return ret;
    }

    private int prodEqu(Produttore p) {
        int n=0;
        for (Farmaco f : farmaci) {
            if(f.getCodProd()==p.getCodice() && notEquivalente(f,p)) n++;
        }
        return n;
    }

    private boolean notEquivalente(Farmaco far,Produttore p) {
        for(Farmaco f : farmaci){
            if(f.getCodProd()!=p.getCodice() && f.getPrincipiAttivi().equals(far.getPrincipiAttivi())) return false;
        }
        return true;
    }
    public ArrayList<String> universali(){
        //Il metodo restituisce i principi attivi usati in almeno un farmaco di un produttore di ogni nazione. 
        ArrayList<String> ret= new ArrayList<>();
        ArrayList<String> nazioni= nazioni();
        ArrayList<Produttore> prodNazioni= prodPerNazioni(nazioni);
        int c=0;
        for(String princ : princiAttivi){
            for (Produttore p : prodNazioni) {
                if(principiAttiviProd(p).contains(princ)) c++;
            }
            if(c==prodNazioni.size()) ret.add(princ);
            else c=0;
        }
        return ret;
    }

    private ArrayList<String> principiAttiviProd(Produttore p) {
        ArrayList<String> ret=new ArrayList<>();
        for (Farmaco f : farmaci) {
            if(f.getCodProd()==p.getCodice()) ret.addAll(f.getPrincipiAttivi());
        }
        return ret;
    }


    private ArrayList<Produttore> prodPerNazioni(ArrayList<String> nazioni) {
        ArrayList<Produttore> ret= new ArrayList<>();
        for (String n : nazioni) {
            for (Produttore p : produttori) {
                if(p.getNazione()==n && !ret.contains(p)) {
                    ret.add(p);
                    break;
                }
            }
        }return ret;
    }

    private ArrayList<String> nazioni() {
        ArrayList<String> ret= new ArrayList<>();
        for(Produttore p: produttori){
            if(!ret.contains(p.getNazione())) ret.add(p.getNazione());
        }
        return ret;
    }
    public static void main(String[] args) {
        
        ArrayList<Produttore> produttori = new ArrayList<>();
        produttori.add(new Produttore(1, "produttore 1", "Italia"));
        produttori.add(new Produttore(2, "produttore 2", "Francia"));
        produttori.add(new Produttore(3, "produttore 3", "Inghilterra"));
        produttori.add(new Produttore(4, "produttore 4", "Italia"));

        ArrayList<String> principiAttivi = new ArrayList<>(
                List.of("principioA", "principioB", "principioC", "principioD", "principioE", "principioF"));

        ArrayList<Farmaco> farmaci = new ArrayList<>();
        farmaci.add(new Farmaco(1, "farmaco 1", 1, 1.5, new ArrayList<>(List.of("principioA", "principioB", "principioC"))));
        farmaci.add(new Farmaco(2, "farmaco 2", 1, 1, new ArrayList<>(List.of("principioC", "principioD"))));
        farmaci.add(new Farmaco(3, "farmaco 3", 2, 2, new ArrayList<>(List.of("principioC", "principioD"))));
        farmaci.add(new Farmaco(4, "farmaco 4", 3, 3, new ArrayList<>(List.of("principioC", "principioE"))));
        farmaci.add(new Farmaco(5, "farmaco 5", 3, 2.5, new ArrayList<>(List.of("principioA", "principioF"))));
        farmaci.add(new Farmaco(6, "farmaco 6", 4, 0.5, new ArrayList<>(List.of("principioA", "principioF"))));

        Gestione g = new Gestione( farmaci, produttori,principiAttivi);
        System.out.println(g.farmacoCaro("principioC")); // "farmaco 4".
        System.out.println(g.esclusivisti()); //[p1, p3].
        System.out.println(g.universali()); //["principioC"].
    }
}
