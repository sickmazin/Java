package luglio222019;

import java.util.ArrayList;

public class Sistema {
    private ArrayList<Immobile> immobili;
    private ArrayList<Person> persone;
    //1.	
    public ArrayList<Person> contribuenti (String c){
    /*Il metodo restituisce l’elenco di tutte le persone che possiedono immobili ubicati nella città c.*/
        ArrayList<Person> ret= new ArrayList<>();
        for(Immobile immobile: immobili)    {
            if(immobile.getCittà().equals(c)){
                ret.addAll(PersonedellImmobile(immobile));

            }
        }
        return ret;
    }
    private ArrayList<Person> PersonedellImmobile(Immobile immobile) {
        ArrayList<Person> ret= new ArrayList<>();
        ArrayList<Proprietà> propr= immobile.getProprietari();
        for (Proprietà proprietà : propr) {
            String codicefiscale= proprietà.getCodiceFiscale();
            for (Person persona : persone) {
                if(persona.getCodiceFiscale().equals(codicefiscale)) ret.add(persona);
            }   
        }
        return ret;
    }
    //2.	
    public ArrayList<Immobile> piuProprietari(){
        /*Il metodo restituisce l’elenco degli immobili di proprietà di più persone, 
        tali che solo una di esse risiede allo stesso indirizzo in cui è ubicato l’immobile.*/
        ArrayList<Immobile> ret= new ArrayList<>();
        for (Immobile immobile : immobili) {
            if (immobile.getProprietari().size()>1) {
                    if(unSoloResidente(immobile)) ret.add(immobile);
            }
        }
        return ret;
    }
    private boolean unSoloResidente(Immobile immobile) {
        String viaImmobile= immobile.getVia();
        ArrayList<Person> propr= PersonedellImmobile(immobile);
        int c=0;
        for(Person p: propr){
            if (p.getVia().equals(viaImmobile)) {
                c++;
            }
        }
        if(c==1) return true;
        return false;
    }
    //3.	
    public ArrayList<String> grandiProprieta(String c, int d){
    /* Il metodo restituisce la lista dei codici fiscali delle persone residenti nella città c che posseggono
     immobili di dimensione almeno d, ordinata in base alla via di residenza delle persone stesse (secondo l’ordine lessicografico).*/
        ArrayList<String> ret= new ArrayList<>();
       for(Person a: persone) {
           if(a.getCitta().equals(c)){
            ArrayList<Immobile> m= immobiliDiPersona(a);
                for (Immobile imm : m) {
                    if(imm.getDimensione()>=d) ret.add(a.getCodiceFiscale());
                }
            }
        }
        return ret;
    }
    private ArrayList<Immobile> immobiliDiPersona(Person a) {
        ArrayList<Immobile> ret= new ArrayList<>();
        for(Immobile imm: immobili){
            ArrayList<Person> m= PersonedellImmobile(imm);
            if (m.contains(a)) {ret.add(imm);
            }
        }
        return ret;
    }
}
