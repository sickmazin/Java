package settembre162020;

import java.util.*;
public class Sistema {
    private ArrayList<Utente> utenti;
    private ArrayList<Messaggio> messaggi;

    public Sistema(ArrayList<Utente> utenti, ArrayList<Messaggio> messaggi) {
        this.utenti = utenti;
        this.messaggi = messaggi;
    }
    public ArrayList<String> nessunaLettura(String destinatario){
        //Il metodo restituisce la lista dei nomi degli utenti che hanno inviato 
        //qualche messaggio all’utente destinatario, ma nessuno di questi messaggi è stato letto.
        ArrayList<String> ret= new ArrayList<>();
        for(Messaggio m: messaggi){
            if(m.getNomeDestinatario().equals(destinatario) && m.letto()==false)
                ret.add(m.getNomeMittente());
        }
        return ret;
    }
    public ArrayList<String> cittaUnica(int dataInizio, int dataFine){
    /*Il metodo restituisce la lista dei nomi degli utenti per ciascuno dei quali l’insieme dei messaggi inviati nel periodo compreso 
    tra il giorno dataInizio e il giorno dataFine (estremi inclusi) 
    ha cardinalità maggiore o uguale a 2 e non contiene alcuna coppia di messaggi inviati a destinatari che  risiedono in città diverse.
    */ 
        ArrayList<String> ret= new ArrayList<>();
        for (Utente u : utenti) {
            ArrayList<Messaggio> mex= messaggiInviatiInData(u,dataInizio,dataFine);
            if(mex.size()>=2 && messaggiStessaCitta(mex))
                ret.add(u.getNome());        
        }     
        return ret;
    }
    private ArrayList<Messaggio> messaggiInviatiInData(Utente u, int dataInizio, int dataFine) {
        ArrayList<Messaggio> ret=new ArrayList<>();
        for (Messaggio messaggio : messaggi) {
            if(messaggio.getData()>=dataInizio && messaggio.getData()<= dataFine && messaggio.getNomeMittente().equals(u.getNome()))
                ret.add(messaggio);
        }
        return ret;
    }
    private boolean messaggiStessaCitta(ArrayList<Messaggio> mex) {
        for (int i = 0; i < mex.size()-1; i++) {
            if(cittaDaNome(mex.get(i).getNomeDestinatario()) != cittaDaNome(mex.get(i+1).getNomeDestinatario()))
                return false;
        }
        return true;
    }
    private String cittaDaNome(String destinatario) {
        for (Utente u : utenti) {
            if(u.getNome().equals(destinatario)) return u.getNome();
        }
        return null;
    }
    public ArrayList<String> mittentiFrequenti(int data, String citta){
        //Il metodo restituisce la lista dei nomi degli utenti che hanno inviato il 
        //maggior numero di messaggi nel giorno data a destinatari che risiedono nella città citta.
        ArrayList<String> ret= new ArrayList<>();
        int max= maxMessaggiInDataNellaCitta(data,citta);
        for (Utente u : utenti) {
            ArrayList<Messaggio> mex= messaggiInviatiInData(u,data,data);
            if(mex.size()==max) ret.add(u.getNome());
        }
        return ret;
    }
    private int maxMessaggiInDataNellaCitta(int data, String citta) {
        int max=-1;
        for (Utente u : utenti) {
            ArrayList<Messaggio> mex= messaggiInviatiInData(u,data,data);
            for (Messaggio messaggio : mex) {
                if(cittaDaNome(messaggio.getNomeDestinatario()) != citta ) mex.remove(messaggio);
            }
            if(mex.size()>max) max=mex.size();
        }
        return max;
    }
    
}
