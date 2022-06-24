package febbraio012022;

import java.util.LinkedList;

public class Sistema {
    private LinkedList<Tecnico> tecnici;
    private LinkedList<Intervento> interventi;
    
    public Sistema(LinkedList<Tecnico> tecnici, LinkedList<Intervento> interventi) {
        this.tecnici =new LinkedList<Tecnico> (tecnici);
        this.interventi =new LinkedList<Intervento> (interventi);
    }
    /*
    Il metodo restituisce il tecnico avente il massimo costo complessivo (calcolato come 
    prodotto del suo costo orario per la somma delle durate degli interventi che ha effettuato). 
    Nel caso in cui più tecnici soddisfino la condizione, il metodo restituisce uno qualsiasi di essi. 
    */

    public Tecnico tecnicoMax(){
        int CostoMax= costoTecnico(tecnici.get(0));
        Tecnico tecMax=null;
        for (Tecnico tecnico : tecnici) {
            int costo= costoTecnico(tecnico);
            if (costo> CostoMax) {
                CostoMax=costo;
                tecMax= tecnico;
            }
        }
        return tecMax;
    }

    private int costoTecnico(Tecnico t) {
        int cont=0;
        for (Intervento intervento : interventi) {
            if(intervento.getNomeTecnico().equals(t.getNome()));
            cont+= t.getCostoOrario()*intervento.getDurata();
        }
        return cont;
    }
    /*
     Il metodo restituisce la lista dei nomi dei tecnici che in almeno r 
     interventi hanno effettuato almeno un'operazione di tipo “riparazione”.  
    */
    public LinkedList<String> tecniciRiparatori(int r){
        LinkedList<String> ret= new LinkedList<>();
        for (Tecnico t: tecnici) {
            if(riparazioni(t)>= r)  ret.add(t.getNome());
        }
        return ret;
    }

    private int riparazioni(Tecnico t) {
        int c=0;
        for (Intervento i : interventi) {
            if(i.getNomeTecnico().equals(t.getNome()) && i.tipiOperazione.contains("Riparazione")) c++; 
        }
        return c;
    }
    /*
    Il metodo restituisce la lista dei nomi dei tecnici aventi costo orario minore o uguale a cm e che, 
    nelle date comprese tra d1 e d2 (incluse), hanno effettuato operazioni di almeno t tipi diversi. 
}
    */
    public LinkedList<String> tecniciJolly(int cm, int d1, int d2, int t){
        LinkedList<String> ret= new LinkedList<>();
        for (Tecnico tecnico : tecnici) {
            if(tecnico.getCostoOrario()<= cm && numOperazioni(tecnico,d1,d2)>= t)
                ret.add(tecnico.getNome());
        }
        return ret;
    }

    private int numOperazioni(Tecnico tecnico, int d1, int d2) {
        LinkedList<String> operazioniDiverse= new LinkedList<>();
        for (Intervento i : interventi) {
            if(i.getNomeTecnico().equals(tecnico.getNome()) && i.getData()<=d2 && i.getData()>=d1)
                for (String operazione : i.getTipiOperazione()) {
                    if (!(operazioniDiverse.contains(operazione))) {
                        operazioniDiverse.add(operazione);
                    }
                }
        }
        return operazioniDiverse.size();
    }
} 
