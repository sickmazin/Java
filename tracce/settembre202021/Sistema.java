package settembre202021;

import java.util.LinkedList;

public class Sistema {
    LinkedList<Tennista> tennisti;
    LinkedList<Incontro> incontri;
    
    

    public Sistema(LinkedList<Tennista> tennisti, LinkedList<Incontro> incontri) {
        this.tennisti = tennisti;
        this.incontri = incontri;
    }

    public LinkedList<Integer> edizioniOK(String nomeTennista){
        //Il metodo restituisce la lista delle edizioni del torneo in cui il tennista passato come argomento ha vinto almeno 2 incontri. 
        LinkedList<Integer> ret = new LinkedList<>();
        for(Incontro i: incontri){
            if(VincenteT(i.getNumEdizione(),nomeTennista)>=2 && !ret.contains(i.getNumEdizione())) ret.add(i.getNumEdizione());
        }
        return ret;
    }

    private int VincenteT(int n, String nomeTennista) {
        int ret=0;
        for (Incontro i : incontri) {
            if(i.getNumEdizione()==n && i.getVincitore()==nomeTennista) ret++;
        }
        return ret;
    }
    public LinkedList<String> tennistiFrequenti(int k){
        //Il metodo restituisce i nomi dei tennisti che in almeno k edizioni diverse del torneo hanno raggiunto almeno la semifinale. 
        LinkedList<String> ret= new LinkedList<>();
        for (Tennista t: tennisti) {
            if(SemifinaliRaggiunte(t)>=k) ret.add(t.getNome());
        }
        return ret;
    }

    private int SemifinaliRaggiunte(Tennista t) {
        LinkedList<Integer>  ed= new LinkedList<>();
        int c=0;
        for (Incontro i : incontri) {
            if(i.getVincitore()==t.getNome() || i.getVinto()==t.getNome() && i.getFase()=="semifinale" && !ed.contains(i.getNumEdizione())) c++;
        }
        return c;
    }
    public LinkedList<String> tennistiSorprendenti(int numEd1, int numEd2){
        /*Il metodo restituisce la lista dei tennisti che, considerate le partite disputate nelle
         edizioni del torneo comprese tra la numEd1-esima e la numEd2-esima, hanno vinto il maggior 
         numero di incontri contro tennisti con una migliore posizione nella classifica mondiale.*/
        LinkedList<String> ret = new LinkedList<>();
        int max=2;
        for (Incontro i : incontri) {
            if( i.getNumEdizione()<=numEd2 && i.getNumEdizione()>=numEd1){
                for (Tennista t : tennisti) {
                    if(vincite(t,numEd1,numEd2)==max && !ret.contains(t.getNome())) ret.add(t.getNome());
                }
            }
        }return ret;
    }

    private int vincite(Tennista t, int numEd1, int numEd2) {
        int c=0;
        for (Incontro i : incontri) {
            if( i.getNumEdizione()<=numEd2 && i.getNumEdizione()>=numEd1 && i.getVincitore()==t.getNome() && t.getClassifica()>numClasstennista(i.getVinto()))
                c++;
        }
        return c;
    }

    private int numClasstennista(String vinto) {
        for (Tennista t : tennisti) {
            if(t.getNome()==vinto) return t.getClassifica();
        }
        return 0;
    }
    public static void main(String[] args) {
        Tennista t1= new Tennista("Angela", 1);   
        Tennista t2= new Tennista("Beatrice", 2);
        Tennista t3= new Tennista("Carla", 3);
        Tennista t4= new Tennista("Daria",4 );
        Tennista t5= new Tennista("Elisa",5 );  
        LinkedList<Tennista> tennistas= new LinkedList<>();
        tennistas.add(t1);tennistas.add(t2);tennistas.add(t3);tennistas.add(t4);tennistas.add(t5);
        Incontro i1 = new Incontro(1,"Elisa","Daria" , "quarto di finale");
        Incontro i2 = new Incontro(1,"Elisa","Beatrice" ,"semifinale" );
        Incontro i3 = new Incontro(1,"Angela","Carla" ,"semifinale" );
        Incontro i4 = new Incontro(1,"Angela" ,"Elisa" , "finale");
        Incontro i5 = new Incontro(2,"Carla" ,"Beatrice" , "quarto di finale");
        Incontro i6 = new Incontro(2,"Carla" , "Angela","semifinale" );
        LinkedList<Incontro> incontros= new LinkedList<>();
        incontros.add(i1);incontros.add(i2);incontros.add(i3);incontros.add(i4);incontros.add(i5);incontros.add(i6);
        Sistema s= new Sistema(tennistas,incontros);
        System.out.println(s.edizioniOK("Elisa"));System.out.println(s.tennistiFrequenti(2));System.out.println(s.tennistiSorprendenti(1,2));   
        
    }
}
