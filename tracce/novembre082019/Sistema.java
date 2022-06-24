package novembre082019;

import java.util.*;

public class Sistema {
    private ArrayList<Biglietto> biglietti;
    private ArrayList<Partita> partite;
    private ArrayList<Persona> persone;



    public Sistema(ArrayList<Biglietto> biglietti, ArrayList<Partita> partite, ArrayList<Persona> persone) {
        this.biglietti = biglietti;
        this.partite = partite;
        this.persone = persone;
    }

    public Biglietto emettiBiglietto(Partita partita, String persona, String settore){
        int numSerie= ultimoBigliettoPartita(partita);
        int posto= postoLibero(partita,settore);
        Biglietto biglietto= new Biglietto(numSerie+1,partita.getCodice(), posto, settore, persona);
        if( unicoBiglietto(persona, partita) && posto != 0)
            return biglietto;
        return null;
    }

    private int postoLibero(Partita partita, String settore) {
        ArrayList<Integer> postiOccupati= new ArrayList<>();
        for (Biglietto biglietto : biglietti) {
            if(biglietto.getCodice().equals(partita.getCodice()) && biglietto.getSettore().equals(settore) )
                postiOccupati.add(biglietto.getPosto());
        }
        int posto=0;
        for (boolean giusto= false; giusto==false;) {
            Random rand= new Random();
            posto= rand.nextInt(1001);
            if(!(postiOccupati.contains(posto)))
                giusto=true;
        }
        return posto;
    }

    private int ultimoBigliettoPartita(Partita partita) {
        int numBiglietto=-1;
        for(Biglietto b: biglietti){
            if(b.getCodice().equals(partita.getCodice()) && b.getNumSerie()>=numBiglietto)
                numBiglietto=b.getNumSerie();
        }
        return numBiglietto;
    }

    private boolean unicoBiglietto(String persona, Partita partita) {
        for (Biglietto biglietto : biglietti) {
            if(biglietto.getCodice().equals(partita.getCodice()) && biglietto.getCodiceFiscale().equals(persona))
                return false;
        }
        return true;
    }
    public ArrayList<Biglietto> listaBiglietti(Partita p){
        ArrayList<String> tifosi= new ArrayList<>();
        for(Biglietto b: biglietti){
            if(b.getCodice().equals(p.getCodice()))
                tifosi.add(b.getCodiceFiscale());
        }
        for(int i=0; i<tifosi.size(); i++){
            for (int j = 0; j < tifosi.size()-i-1; j++) {

                if(getDatadaCF(tifosi.get(j))>getDatadaCF(tifosi.get(j+1))){
                    String c=tifosi.get(j);
                    System.out.println(c);
                }
            }
        }
        ArrayList<Biglietto> bigl= new ArrayList<>();
        for (String cf : tifosi) {
            bigl.add(bigliettoDaCf(cf));
        }
        return bigl;
    }
    private Biglietto bigliettoDaCf(String cf) {
        for (Biglietto biglietto : biglietti) {
            if(biglietto.getCodiceFiscale().equals(cf))
                return biglietto;
        }
        return null;
    }

    private int getDatadaCF(String cf){
        for (Persona persona : persone) {
            if(persona.getCodiceFiscale().equals(cf))
                return persona.getData();
        }
        return 0;
    }
    public String bestTeam(){
        int max=-1;
        int numBiglietti=0;
        String nomeSquadra="";
        for (Partita partita : partite) {
            numBiglietti= bigliettiVenduti(partita);
            if (numBiglietti>max ) {
                max=numBiglietti;
                nomeSquadra=partita.getNomeCasa();
            }
        }
        return nomeSquadra;
    }

    private int bigliettiVenduti(Partita partita) {
        int num=0;
        for (Biglietto biglietto : biglietti) {
            if(biglietto.getCodice().equals(partita.getCodice()))
                num++;
        }
        return num;
    }

    public static void main(String[] args) {
        Partita p1= new Partita("A1", "Juventus", "inter", 101);
        Partita p2= new Partita("A2", "Juventus", "GENOA", 102);
        Partita p3= new Partita("B", "COSEMZA", "CREMONESE", 103);
        Partita p4= new Partita("C", "RENDE", "REGGINA", 104);
        ArrayList<Partita> partite= new ArrayList<>();
        partite.add(p1);partite.add(p2);partite.add(p3);partite.add(p4);

        Biglietto b1=new Biglietto(100, "A1", 34,"tribuna", "CF1");
        Biglietto b2=new Biglietto(101, "A1", 12,"curva", "CF2");
        Biglietto b3=new Biglietto(102, "A1", 26,"tribuna", "CF3");
        Biglietto b4=new Biglietto(103, "B", 16,"tribuna", "CF4");
        Biglietto b5=new Biglietto(104, "B", 6,"curva", "CF5");
        Biglietto b6=new Biglietto(105, "B", 36,"curva", "CF6");
        Biglietto b7=new Biglietto(106, "C", 21,"tribuna", "CF7");
        Biglietto b8=new Biglietto(107, "C", 22,"tribuna", "CF8");
        Biglietto b9=new Biglietto(108, "C", 42,"curva", "CF9");
        Biglietto b10=new Biglietto(109, "A2", 34,"tribuna", "CF1");
        Biglietto b11=new Biglietto(110, "A2", 12,"curva", "CF2");
        Biglietto b12=new Biglietto(111, "A2", 26,"tribuna", "CF3");
        ArrayList<Biglietto> biglietti= new ArrayList<>();
        biglietti.add(b1);biglietti.add(b2);biglietti.add(b3);biglietti.add(b4);biglietti.add(b5);biglietti.add(b6);biglietti.add(b7);biglietti.add(b12);biglietti.add(b8);biglietti.add(b9);biglietti.add(b10);biglietti.add(b11);
        
        Persona t1=new Persona("CF1",1,"Torino");
        Persona t2=new Persona("CF2",2,"Torino");
        Persona t3=new Persona("CF3",3,"Milano");
        Persona t4=new Persona("CF4",4,"Cosenza");
        Persona t5=new Persona("CF5",5,"Cosenza");
        Persona t6=new Persona("CF6",6,"Cosenza");
        Persona t7=new Persona("CF7",7,"Cosenza");
        Persona t8=new Persona("CF8",8,"Reggio");
        Persona t9=new Persona("CF9",9,"Reggio");
        ArrayList<Persona> persone= new ArrayList<>();
        persone.add(t1);persone.add(t2);persone.add(t3);persone.add(t4);persone.add(t5);persone.add(t6);persone.add(t7);persone.add(t8);persone.add(t9);
        Sistema a= new Sistema(biglietti, partite, persone);
        System.out.println("emettiBiglietto");
        System.out.println(a.emettiBiglietto(p1, "CF10", "curva"));
        System.out.println("listaBiglietti");
        System.out.println(a.listaBiglietti(p1));
        System.out.println("bestTeam");
        System.out.println(a.bestTeam());
    }
}
