package luglio232020;

import java.util.LinkedList;

import IO.IO;

public class Torneo2 {
        private LinkedList<Partita> partite;
        private LinkedList<Squadra> squadre;

        public LinkedList<String> squadreCasalinghe(){
            LinkedList<String> ret= new LinkedList<>();
            int max= maxVittorieInCasa();
            for (Squadra s: squadre){
                if(partiteVinteInCasa(s)==max)
                    ret.add(s.getNome());
            }
            return ret;
        }

        private int partiteVinteInCasa(Squadra s1) {
            int c=0;
            for (Squadra s : squadre) {
                if (s.equals(s1))
                    for (Partita p : partite) {
                        if(p.getNomeSquadraCasa().equals(s.getNome()) && p.getGolCasa()> p.getGolOspite())
                            c++;
                }
                
            }
            return c;
        }

        private int maxVittorieInCasa() {
            int max=-1;
            for (Squadra s : squadre) {
                int c=0;
                for (Partita p : partite) {
                    if(p.getNomeSquadraCasa().equals(s.getNome()) && p.getGolCasa()> p.getGolOspite())
                        c++;
                }
                if(c>max) max=c;
            }
            return max;
        }

        public LinkedList<String> arbitriFuoriCItta(){
            /**
             * Il metodo restituisce la lista dei nomi degli arbitri tali che tutte le partite da essi 
             * arbitrate non si sono svolte nella loro città (si noti che la città in cui si è svolta 
             * una partita è la città della squadra di casa).
             */
            LinkedList<String> ret= new LinkedList<>();
            LinkedList<String> arbitri= arbitri();
            for (String arbitro : arbitri) {
                if(arbitrofuoriCitta(arbitro)) ret.add(arbitro);
            }
            return ret;

        }

        private LinkedList<String> arbitri() {
            LinkedList<String> ret= new LinkedList<>();
            for (Partita partita : partite) {
                if(!(ret.contains(partita.getNomeArbitro()))) ret.add(partita.getNomeArbitro());
            }
            return ret;
        }

        private boolean arbitrofuoriCitta(String arbitro) {
            for (Partita p : partite) {
                if(p.getNomeArbitro().equals(arbitro) && p.getCittaArbitro()== cittaSqudra(p.getNomeSquadraCasa()))
                    return false; 
            }
            return true;
        }
        private String cittaSqudra(String nomeSquadraCasa) {
            for (Squadra s : squadre) {
                if(s.getNome()==nomeSquadraCasa) return s.getCitta();
            }
            return null;
        }
        public LinkedList<String> arbitri3squadre(){
            LinkedList<String> ret= new LinkedList<>();
            /*Il metodo restituisce la lista dei nomi degli arbitri tali 
            che l’insieme delle squadre distinte da essi arbitrate ha cardinalità 3 
            (si intende che un arbitro ha arbitrato una squadra se egli ha arbitrato 
            una partita in cui tale squadra ha partecipato come squadra di casa o ospite). */
            LinkedList<String> arbitri= arbitri();
            for (String arbitro : arbitri) {
                if(numSquadreArbitrate(arbitro)>=3 && !(ret.contains(arbitro))) ret.add(arbitro);
            }
            return ret;
        }



        private int numSquadreArbitrate(String arbitro) {
            LinkedList<String> ret= new LinkedList<>();
            for(Partita p: partite){
                if(p.getNomeArbitro()==arbitro && !(ret.contains(p.getNomeSquadraCasa()))) ret.add(p.getNomeSquadraCasa());
                if(p.getNomeArbitro()==arbitro && !(ret.contains(p.getNomeSquadraOspite()))) ret.add(p.getNomeSquadraOspite());
            }
            return ret.size();
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
