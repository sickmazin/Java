package luglio232020;

import java.util.LinkedList;

import IO.IO;

public class Torneo {
    private LinkedList<Partita> partite;
    private LinkedList<Squadra> squadre;
    public Torneo(LinkedList<Partita> partite, LinkedList<Squadra> squadre) {
        this.partite = partite;
        this.squadre = squadre;
    }
    public LinkedList<String> squadreCasalinghe(){
        LinkedList<String> ret= new LinkedList<>();
        int maxVittorieInCasa= maxVittorieInCasa();
        for(Squadra squadra: squadre){
            if(numVittorieInCasa(squadra)==maxVittorieInCasa)
                ret.add(squadra.getNome());
        }
        return ret;
    }
    private int numVittorieInCasa(Squadra squadra) {
        int vittorie=0;
        for (Partita partita : partite) {
            if(partita.getNomeSquadraCasa()== squadra.getNome() && partita.getGolCasa()>partita.getGolOspite() )
                vittorie++;
        }
        return vittorie;
    }
    private int maxVittorieInCasa() {
        int max=-1;
        for (Squadra squadra :squadre) {
            int vittorie=0; 
            for (Partita partita : partite) {
                if(partita.getNomeSquadraCasa()== squadra.getNome() && partita.getGolCasa()>partita.getGolOspite() )
                    vittorie++;
            }
            if(vittorie>max)
                max=vittorie;
        }
        return max;
    }
    public LinkedList<String> arbitriFuoriCItta(){
        LinkedList<String> ret= new LinkedList<>();
        for (Partita partita : partite) {
            if(pariteFuoricitta(partita.getNomeArbitro()) && !(ret.contains(partita.getNomeArbitro())) )
                ret.add(partita.getNomeArbitro());
        }
        return ret;
    }
    private boolean pariteFuoricitta(String nomeArbitro) {
        for (Partita partita : partite) {
            if(partita.getNomeArbitro()== nomeArbitro){
                Squadra casa = SquadraDaNome(partita.getNomeSquadraCasa());
                if(casa.getCitta()== partita.getCittaArbitro()) return false;
            }
        }
        return true;
    }
    private Squadra SquadraDaNome(String nomeSquadraCasa) {
        for (Squadra squadra : squadre) {
            if(squadra.getNome().equals(nomeSquadraCasa))
                return squadra;
        }
        return null;
    }
    public LinkedList<String> arbitri3squadre(){
        LinkedList<String> ret = new LinkedList<>();
        for(Partita p: partite) {
         if(cardinalita(p.getNomeArbitro()) == 3 && !ret.contains(p.getNomeArbitro()))
          ret.add(p.getNomeArbitro());
        }
        return ret;
       }
       
       private int cardinalita(String a) {
        LinkedList<String> s = new LinkedList<>();
        for (Partita p: partite) {
         if(p.getNomeArbitro() == a)
          if(!s.contains(p.getNomeSquadraCasa()))
           s.add(p.getNomeSquadraCasa());
          if(!s.contains(p.getNomeSquadraOspite()))
           s.add(p.getNomeSquadraOspite());
        }
        return s.size();
       }
    public static void main(String[] args) {
        Squadra s= new Squadra("Juventus", "Torino");
        Squadra s1= new Squadra("Milan", "Milano");
        Squadra s2= new Squadra("Lazio", "Roma");
        LinkedList<Squadra> squadre= new LinkedList<>();
        squadre.add(s);squadre.add(s1);squadre.add(s2);
        Partita p= new Partita("Juventus", "Milan", 2,0,"Arbitro A","Roma");
        Partita p1= new Partita("Milan","Juventus",1,3,"Arbitro A","Roma");
        Partita p2= new Partita("Lazio","Milan",2,0,"Arbitro A","Roma");
        Partita p3= new Partita("Juventus","Lazio",2,0,"Arbitro B","Milano");
        Partita p4= new Partita("Lazio","Juventus",2,1,"Arbitro B", "Milano");
        Partita p5= new Partita("Milan","Lazio",1,1,"Arbitro A","Roma");
        LinkedList<Partita> partite= new LinkedList<>();
        partite.add(p);partite.add(p1);partite.add(p2);partite.add(p3);partite.add(p4);partite.add(p5);
        Torneo a= new Torneo(partite, squadre);
        IO.println(a.squadreCasalinghe());
        IO.println(a.arbitriFuoriCItta());
        IO.println(a.arbitri3squadre()); 
    }
}
