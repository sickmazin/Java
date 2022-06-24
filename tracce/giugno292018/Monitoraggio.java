package giugno292018;
import java.util.*;
public class Monitoraggio {
    ArrayList<Acquedotto> acquedotti;
    ArrayList<Citta> citta;
    ArrayList<Fornitura> forniture;
    
    public Monitoraggio(ArrayList<Acquedotto> acquedotti, ArrayList<Citta> citta, ArrayList<Fornitura> forniture) {
        this.acquedotti = acquedotti;
        this.citta = citta;
        this.forniture = forniture;
    }
    public ArrayList<Acquedotto> listaAcquedotti(String c){
        ArrayList<Acquedotto> ret = new ArrayList<>();
        for (Fornitura f : forniture) {
            if(f.getCitta().equals(c)) ret.add(acquedottoDaCodice(f.getCodAcquedotto()));
        }
        return ret;
    }
    private Acquedotto acquedottoDaCodice(int codice){
        for(Acquedotto a: acquedotti){
            if(a.getCodice()==codice) return a;
        }
        return null;
    }
    public ArrayList<String> trovaCittà(int pop, int k){ 
        //Il metodo restituisce tutti i nomi delle città con popolazione superiore a pop abitanti e rifornite da almeno k acquedotti. 
        ArrayList<String> ret = new ArrayList<>();
        for (Citta c : citta) {
            if(c.getPopolazione()>pop && rifornita(c.getNome())>=k) ret.add(c.getNome());
        }
        return ret;
    }
    private int rifornita(String citta){
        int c=0;
        ArrayList<Acquedotto> a= new ArrayList<>();
        for(Fornitura f: forniture){
            if(f.getCitta().equals(citta) && !a.contains(acquedottoDaCodice(f.getCodAcquedotto()))){
                c++;
                a.add(acquedottoDaCodice(f.getCodAcquedotto()));
            }
        }
        return c;
    }
    public Citta cittàGold(){
        //Il metodo restituisce la città con la massima disponibilità totale di acqua (cioè la somma delle portate delle forniture per quella città). 
        double max=-1;
        Citta ret= null;
        for (Citta c: citta) {
            if(portata(c)>max) ret=c;
        }
        return ret;
    }
    private double portata(Citta c){
        double cnt=0;
        for (Fornitura f : forniture) {
            if(f.getCitta().equals(c.getNome())) cnt+=f.getPortata();
        }
        return cnt;
    }
    public static void main(String[] args) {

        ArrayList<Citta> citta = new ArrayList<>();
        citta.add(new Citta("Cosenza", 69911));
        citta.add(new Citta("Lamezia Terme", 70845));
        citta.add(new Citta("Catanzaro", 89801));
        citta.add(new Citta("Reggio Calabria", 81454));
        citta.add(new Citta("Corigliano - Rossano", 77076));

        ArrayList<Acquedotto> acquedotti = new ArrayList<>();
        acquedotti.add(new Acquedotto(0, "a0"));
        acquedotti.add(new Acquedotto(1, "a1"));
        acquedotti.add(new Acquedotto(2, "a2"));
        acquedotti.add(new Acquedotto(3, "a3"));
        acquedotti.add(new Acquedotto(4, "a4"));
        acquedotti.add(new Acquedotto(5, "a5"));
        acquedotti.add(new Acquedotto(6, "a6"));
        acquedotti.add(new Acquedotto(7, "a7"));

        ArrayList<Fornitura> forniture = new ArrayList<>();
        forniture.add(new Fornitura(0, 100.50, 0, "Cosenza"));
        forniture.add(new Fornitura(1, 121.30, 1, "Cosenza"));
        forniture.add(new Fornitura(2, 122.90, 2, "Lamezia Terme"));
        forniture.add(new Fornitura(3, 130.52, 3, "Lamezia Terme"));
        forniture.add(new Fornitura(4, 250.89, 4, "Catanzaro"));
        forniture.add(new Fornitura(5, 240.46, 5, "Reggio Calabria"));
        forniture.add(new Fornitura(6, 200.00, 6, "Reggio Calabria"));
        forniture.add(new Fornitura(7, 220.19, 7, "Corigliano - Rossano"));

        Monitoraggio m = new Monitoraggio(acquedotti,citta,  forniture);
        System.out.println(m.listaAcquedotti("Cosenza")); // [a0, a1]
        System.out.println(m.trovaCittà(80000 ,2)); //["Reggio Calabria"].
        System.out.println(m.cittàGold());//"Reggio Calabria"
    }
}
