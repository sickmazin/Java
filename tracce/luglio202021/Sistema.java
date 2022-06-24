package luglio202021;

import java.util.LinkedList;

public class Sistema {
    private LinkedList<Calciatore> calciatori;
    private LinkedList<Contratto> contratti;
    public Sistema(LinkedList<Calciatore> calciatori, LinkedList<Contratto> contratti) {
        this.calciatori = new LinkedList<>(calciatori);
        this.contratti = new LinkedList<>(contratti);
    }

    public boolean verificaDati(){
        for (Contratto c :contratti) {
            String squadraAttuale=c.getSquadra();
            String nomeCalciatore= c.getCalciatore();
            for(Calciatore calc: calciatori)
                if(calc.getNome().equals(nomeCalciatore) && calc.getSquadra().equals(squadraAttuale)) 
                    return false;
        }
        return true;
    }
    public LinkedList<String> squadreAttive(int pMin){
        LinkedList<String> ret= new LinkedList<>();
        LinkedList<String> nomiSquadra= getNomiSquadra();
        for (String squadra: nomiSquadra) {
            LinkedList<Calciatore> calciatores= getCalciatoriAcqu(squadra);
            if(almeno3SquadDiverse(calciatores) && spesaTotaleAcqu(squadra)>=pMin) ret.add(squadra);
        }
        return ret;
    }

    private int spesaTotaleAcqu(String squadra) {
        int spesaTotaleAcqu=0;
        for (Contratto c : contratti) {
            if(c.getSquadra().equals(squadra)) spesaTotaleAcqu+= c.getPrezzo();
        }
        return spesaTotaleAcqu;
    }

    private boolean almeno3SquadDiverse(LinkedList<Calciatore> acquisti) {
        LinkedList<String> squadre= new LinkedList<>();
        for (Calciatore calciatore : acquisti) {
            if((squadre.contains(calciatore.getSquadra())))
                squadre.add(calciatore.getSquadra());
        }
        if (squadre.size()>=3) return true;
        return false;
    }

    private LinkedList<Calciatore> getCalciatoriAcqu(String squadra) {
        LinkedList<Calciatore> acquisti= new LinkedList<>();
        for (Contratto c : contratti) {
            if(c.getSquadra().equals(squadra)) 
                acquisti.add(CalciatoreDaContratto(c.getCalciatore()));
        }
        return acquisti;
    }

    private Calciatore CalciatoreDaContratto(String nomecalciatore) {
        for (Calciatore c : calciatori) {
            if(c.getNome().equals(nomecalciatore)) return c;
        }
        return null;
    }

    private LinkedList<String> getNomiSquadra() {
        LinkedList<String> ret= new LinkedList<>();
        for (Contratto c : contratti) {
            if(!(ret.contains(c.getSquadra())))
                ret.add(c.getSquadra());
        }
        return ret;
    }
    public LinkedList<String> calciatoriPocoPremiati(int pMax) {
        LinkedList<String> res = new LinkedList<>();
        for (Calciatore calciatore : calciatori) {
            if(pocoPremiato(calciatore,pMax))
            res.add(calciatore.getNome());
        }
        return res;
    }

    private boolean pocoPremiato(Calciatore calciatore, int pMax) {
        for (Contratto c: contratti) {
            if(c.getCalciatore().equals(calciatore.getNome()) && !(verificaCondizione(c.getPremi(),pMax)))
                return false;
        }
        return true;
    }

    private boolean verificaCondizione(LinkedList<Integer> premi, int pMax) {
        for (Integer p : premi) {
            if(p>pMax)
                return false;
        }
        return true;
    }

}
