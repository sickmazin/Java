package gennaio272021;

import java.util.ArrayList;
import java.util.LinkedList;

import IO.IO;

public class Sistema {
    private ArrayList<Fornitore> fornitori;
    private ArrayList<Merce> merci;

    public Sistema(ArrayList<Fornitore> fornitori, ArrayList<Merce> merci) {
        this.fornitori = fornitori;
        this.merci = merci;
    }

    public LinkedList<String> grandiFornitori(){//Il metodo restituisce la lista dei nomi dei fornitori che forniscono il maggior numero di merci.
        LinkedList<String> ret= new LinkedList<>();
        int max=maxVenduta();
        for (int i=0;i<this.merci.size();i++) {
            for (int j=0; j<this.merci.get(i).fornitori.size(); j++) { 
                if(merceVenduta(this.merci.get(i).fornitori.get(j))==max&& !ret.contains(this.merci.get(i).fornitori.get(j).getNome())) ret.add(this.merci.get(i).fornitori.get(j).getNome());
            }
        }
        return ret;
    }

    private int maxVenduta() {
        int max=0;
        for (Merce merce : merci) {
            for (Fornitore fornitore : merce.fornitori) 
                if(merceVenduta(fornitore)>max) max=merceVenduta(fornitore); 
        }
        return max;
    }    

    private int merceVenduta(Fornitore fornitore) {
        int merceVenduta=0;
        for (Merce merce : merci) {
            for (Fornitore forn : merce.fornitori) 
                if(forn.equals(fornitore))
                    merceVenduta++;
        }
        return merceVenduta;
    }
    public LinkedList<String> fornitoriMonoMarca(String marca){//Il metodo restituisce la lista dei nomi dei fornitori che forniscono solo merci della marca passata come argomento.
        LinkedList<Fornitore> f=new LinkedList<>();
        LinkedList<String> ret= new LinkedList<>(); 
        for (Merce merce : merci) {
            if(merce.getMarca()==marca) f.addAll(merce.fornitori);
        }
        for (Fornitore fornitore : f) {
            if(unaMerce(fornitore, marca)&& !ret.contains(fornitore.getNome())) ret.add(fornitore.getNome());
        }
        return ret;
    }

    private boolean unaMerce(Fornitore fornitore, String marca) {
        for (Merce merce : merci) {
            if(merce.getMarca()!= marca){
            for (Fornitore forn : merce.fornitori) if(forn.equals(fornitore)) return false;
            }
        }
        return true;
    }
    public String toString() {
        return "Sistema [fornitori=" + fornitori + ", merci=" + merci + "]";
    }

    public LinkedList<String> merciCittaDiverse(){
        return null;

    }
    public static void main(String[] args) {
        ArrayList<Fornitore> fornitori=new ArrayList<>();
        ArrayList<Merce> merci=new ArrayList<>();
        Fornitore f1= new Fornitore("F1", "Roma");
        fornitori.add(f1);
        Fornitore f2= new Fornitore("F2", "Roma");
        fornitori.add(f2);
        Fornitore f3= new Fornitore("F3", "Milano");
        fornitori.add(f3);
        Fornitore f4= new Fornitore("F4", "Roma");
        fornitori.add(f4);
        ArrayList<Fornitore> fo1=new ArrayList<>();
        fo1.add(f1);
        fo1.add(f4);
        Merce m1= new Merce("M1", "Barilla", fo1);
        merci.add(m1);
        ArrayList<Fornitore> fo2=new ArrayList<>();
        fo2.add(f1);
        fo2.add(f2);
        fo2.add(f3);
        Merce m2= new Merce("M2", "Barilla", fo2);
        merci.add(m2);
        ArrayList<Fornitore> fo3=new ArrayList<>();
        fo2.add(f3);
        Merce m3= new Merce("M2", "Barilla", fo3);
        merci.add(m3);
        Sistema a= new Sistema(fornitori, merci);
        
        IO.println("Grandi Fornitori "+a.grandiFornitori());
        
        IO.println("FornitoriMonoMArca "+ a.fornitoriMonoMarca("Barilla"));
    }
}
