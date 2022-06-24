package settembre092019;

import java.util.ArrayList;

import IO.IO;

public class Sistema {
    private ArrayList<Parlamentare> parlamentari;
    //private ArrayList<Votazione> votazioni;
    private ArrayList<DisegnoDiLegge> disegnoDiLegges;
    public Sistema(ArrayList<Parlamentare> parlamentari, ArrayList<Votazione> votazioni,
            ArrayList<DisegnoDiLegge> disegnoDiLegges) {
        this.parlamentari = parlamentari;
        //this.votazioni = votazioni;
        this.disegnoDiLegges = disegnoDiLegges;
    }
    public ArrayList<DisegnoDiLegge> m1(String r){
        /*
         * Il metodo restituisce i disegni di legge approvati 
         * soltanto con voti favorevoli espressi da parlamentari eletti in collegi della regione r.
        */
        ArrayList<DisegnoDiLegge> ret= new ArrayList<>();
        for(DisegnoDiLegge d: disegnoDiLegges){
            if(d.isVotazione() && unicaRegione(d,r))
                ret.add(d);
        }
        return ret;
    }
    private boolean unicaRegione(DisegnoDiLegge d, String r) {
        ArrayList<String> parlamentar= d.getListaParlamentari();
        for (String cf : parlamentar) {
            Parlamentare p= parlamentareDaCF(cf);
            if(p.getRegione()!=r) return false; 
        }
        return true;
    }
    private Parlamentare parlamentareDaCF(String cf) {
        for(Parlamentare p: parlamentari)
            if(p.getCodiceFiscale()==cf) return p;
        return null;
    }
    public ArrayList<Parlamentare> m2(String p){
    /*Il metodo restituisce l’elenco dei parlamentari del partito politico p che
     hanno espresso voto contrario su qualche disegno di legge proposto da almeno
      un parlamentare dello stesso partito p.*/
        ArrayList<Parlamentare> ret = new ArrayList<>();
        ArrayList<DisegnoDiLegge> disegni= disegniDiLeggeDelPartito(p);
        for(DisegnoDiLegge d: disegni) {
            ArrayList<String> parlamentares= d.getListaParlamentari();
            for(String cf: parlamentares){
                Parlamentare parlamentare= parlamentareDaCF(cf);
                if (parlamentare.getPartitoPolitico()==p &&  !(ret.contains(parlamentare))) 
                    ret.add(parlamentare);    
            }
        }
        return ret;
    }
    private ArrayList<DisegnoDiLegge> disegniDiLeggeDelPartito(String p) {
        ArrayList<DisegnoDiLegge> ret= new ArrayList<>();
        for(DisegnoDiLegge d: disegnoDiLegges){
            ArrayList<String> cf1= d.getListaParlamentari();
            for (String cf : cf1) {
                Parlamentare par= parlamentareDaCF(cf);
                if(par.getPartitoPolitico()==p) ret.add(d);
            }
        }
        return ret;
    }
    public ArrayList<String> m3(DisegnoDiLegge d){
        /*
         * Il metodo restituisce l’elenco dei partiti politici 
         * i cui parlamentari hanno votato a favore del disegno di legge d, 
         * ordinato in modo decrescente in base al numero di parlamentari di quel partito che hanno espresso tali voti favorevoli.
         */
        ArrayList<String> ret= new ArrayList<>();
        for (String cf : d.getListaParlamentari()) {
            Parlamentare p= parlamentareDaCF(cf);
            if(!(ret.contains(p.getPartitoPolitico())))
                ret.add(p.getPartitoPolitico());           
        }
        return  ret;
    }
    public static void main(String[] args) {
        Parlamentare p1=new Parlamentare("RSS", "Calabria" ,"partito1");
        Parlamentare p2=new Parlamentare("BNC", "Lombardia", "partito2");
        Parlamentare p3=new Parlamentare("GIA", "Lombardia", "partito2");
        Parlamentare p4=new Parlamentare("VRD", "Calabria" ,"partito3");
        Parlamentare p5=new Parlamentare("MAR", "Calabria" ,"partito1");
        ArrayList<Parlamentare> parlamentares= new ArrayList<>();
        parlamentares.add(p1);parlamentares.add(p2);parlamentares.add(p3);parlamentares.add(p4);parlamentares.add(p5);
        ArrayList<String> s1= new ArrayList<>();
        s1.add("RSS");s1.add("VRD");s1.add("MAR");
        ArrayList<String> s2= new ArrayList<>();
        s2.add("VRD");s2.add("MAR");
        ArrayList<String> s3= new ArrayList<>();
        s3.add("VRD");s3.add("BNC");s3.add("GIA");
        DisegnoDiLegge d1= new DisegnoDiLegge(1,"DDL1", s1, 1, true);
        DisegnoDiLegge d2= new DisegnoDiLegge(2,"DDL2", s2,  2, false);
        DisegnoDiLegge d3= new DisegnoDiLegge(3,"DDL3", s3, 3,  true);
        ArrayList<DisegnoDiLegge> disegnoDiLegges= new ArrayList<>();
        disegnoDiLegges.add(d1);disegnoDiLegges.add(d2);disegnoDiLegges.add(d3);
        
        Votazione v1= new Votazione(1, "RSS",1,true);
        Votazione v2= new Votazione(2, "BNC",1,false);
        Votazione v3= new Votazione(3, "MAR",1,true);
        Votazione v4= new Votazione(4, "VRD",1,true);
        Votazione v5= new Votazione(5, "GIA",1,false);
        Votazione v6= new Votazione(6, "RSS",2,false);
        Votazione v7= new Votazione(7, "BNC",2,false);
        Votazione v8= new Votazione(8, "MAR",2,true);
        Votazione v9= new Votazione(9, "VRD",2,true);
        Votazione v10= new Votazione(10,"GIA",2,false);
        Votazione v11= new Votazione(11,"RSS",3,false);
        Votazione v12= new Votazione(12,"BNC",3,true);
        Votazione v13= new Votazione(13,"MAR",3,false);
        Votazione v14= new Votazione(14,"VRD",3,true);
        Votazione v15= new Votazione(15,"GIA",3,true);
        ArrayList<Votazione>votaziones= new ArrayList<>();
        votaziones.add(v1);votaziones.add(v2);votaziones.add(v3);
        votaziones.add(v4);votaziones.add(v5);votaziones.add(v6);
        votaziones.add(v7);votaziones.add(v8);votaziones.add(v9);
        votaziones.add(v10);votaziones.add(v11);votaziones.add(v12);
        votaziones.add(v13);votaziones.add(v14);votaziones.add(v15);
        Sistema a= new Sistema(parlamentares, votaziones, disegnoDiLegges);
        IO.println(a.m1("Calabria"));IO.println(a.m2("partito1"));IO.println(a.m3(d3));
    }
}
