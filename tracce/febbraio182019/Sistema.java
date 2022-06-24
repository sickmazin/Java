package febbraio182019;
import java.util.*;

public class Sistema {
    private ArrayList<Articolo> articoli;
    private ArrayList<Cliente> clienti;
    //1.	
    public ArrayList<String> articoliCittà(String c){
//Il metodo restituisce la lista dei codici degli articoli acquistati da tutti i clienti residenti nella città c. 
        ArrayList<String> ret= new ArrayList<>();
        ArrayList<Cliente> tutticlienti=new ArrayList<>();
        for (Cliente cliente: clienti) {
            if (cliente.getCitta().equals(c)) 
                tutticlienti.add(cliente);
        }
        for(Articolo a: articoli){
            for (Cliente clie : tutticlienti) {
                if (a.getClienti().contains(clie)) ret.add(a.getCodice());
                
            }
        }
        return ret;
    }
    //2.
    public ArrayList<Cliente> acquirentiUnici(int d1, int d2){
        /*Il metodo restituisce la lista dei clienti che hanno la caratteristica di essere gli 
        unici acquirenti di almeno un articolo messo in vendita nel periodo compreso tra la data d1 e la data d2.*/        
        ArrayList<Cliente> ret= new ArrayList<>();
        for (Articolo a : articoli) {
            if (a.getData()>=d1 && a.getData()<=d2 && a.getClienti().size()==1) 
                ret.add(a.getClienti().get(0));
            
        }
        return ret;
    }
    //3.	
    public ArrayList<Articolo> acquirentiComuni(Cliente a, Cliente b){
    /*Il metodo restituisce la lista degli acquisti effettuati sia dal cliente a che dal cliente b (eventualmente insieme ad altri), 
    ordinata (in senso decrescente) secondo la data di messa in vendita degli articoli. */
        ArrayList<Articolo> ret= new ArrayList<>();
        for (Articolo articolo : articoli) {
            if(articolo.getClienti().contains(a)&&articolo.getClienti().contains(b)) ret.add(articolo);
        }
        for (int i = 0; i < ret.size(); i++) {
            for (int j = 0; j < ret.size()-1-i; j++) {
                if(ret.get(j).getData()>ret.get(j+1).getData()){
                    ret.set(j, ret.get(j+1));
                    ret.set(j+1, ret.get(j));
                }
            }
        }
        return ret;
    }
}

