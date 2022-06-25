
import java.util.LinkedList;
import java.util.ListIterator;

import IO.IO;

public class algoritmiRicorsivi {
    //La ricorsione spesso è molto più costosa rispetto ad altri metodi.

    //fattoriale f=n*(n-1)*(n-2)*...*3*2*1
    public static int fattoriale(int n) {
        int f=1;
        for (int i = 1; i<=n; i++) {
            f*=i;
        }
        return f;
    }
    // un algoritmo ricorsivo tipicamente non usa for, deve contenere un tappo cioè vado a definire i casi limite 
    /*
    Fattoriale N=1, se n=1
    Fattoriale N=n* fattoriale(n-1)
    4! = 4*3*2*1 = 4* 3!     
    */
    public static int FattorialeRicorsivo(int n) { // per ogni invocazione si va a creare un record di attivazione che contiene via via n decrescente e f composto da n e la chiamata della funzione ricorsiva. I record di attivazione si impilano finché non si arriva al tappo, cioè non deve richiamare più se stessa, si iniziano ad eliminare poiché si arriva al return.
        if (n==1) return 1;
        int fattoriale =n * FattorialeRicorsivo(n-1);
        return fattoriale;
        
    }
    // FIBONACCI:
    /*
    SERIE: 0 1 1 2 3 5 8 13 21 34 55 89 ...
    */
    public static int iesimoFibonacci(int index) {
        int i1=0;
        int i2=1;
        if (index==1)   
            return i1;
        if (index==2)   
            return i2;
        for (int i = 3; i <= index; i++) {
            int nuovo= i2+i1;
            i1=i2;
            i2=nuovo;    
        }
        return i2;
        
    }
    //In forma ricorsiva diviene 
    public static int iesimoFibonacciRicorsivo(int index) {
        // bisogna prima cosa definire il tappo altrimenti possibile che si richiami la funzione all'infinito poichè non si hanno le condizioni per saltare la chiamata prima del tappo
        if(index==1)
            return 0;
        if(index==2)
            return 1;        
        int f=iesimoFibonacciRicorsivo(index-1)+iesimoFibonacciRicorsivo(index-2);
        return f;
    }
    /* 
    Algoritmo ricorsivo che fa la ricerca del massimo all'interno di un vettore
    */
    public static int maxRicorsivo(int[] array, int pos) { // restituisce il massimo a partire dalla posizione pos fino alla fine dell'array
        // il max dalla posizione pos alla fine è max(array[pos], maxRicorsivo(array,pos+1)
        // casi da studiare: Array non null ,pos oltre la lunghezza e array.lenght==0
        if (pos==array.length-1)
            return array[pos];
        int maxDestra= maxRicorsivo(array, pos+1);
        if (array[pos]>=maxDestra)
            return array[pos];
        return maxDestra;
        // questo metodo però è davvero inefficiente 
    }
    
    private static int sommaRicorsiva(int[] v, int index) {
        if(v==null || index==v.length)
            return 0;
        return v[index]+sommaRicorsiva(v, index+1);
        /*
        if (index==v.length-1)
            return v[index];
        int somma=v[index];
        somma+=sommaRicorsiva(v, index+1);
        return somma;
         */
    }
    private static boolean eOrdinatoCrescenteRicorsivo(int[] v, int indStart) {
        if (v==null || indStart==v.length)
            return true;
        return v[indStart]<= v[indStart+1] && eOrdinatoCrescenteRicorsivo(v, indStart++);
        /*
        metodo più leggibile

        if (v[indStart]>v[indStart+1])
            return false;
        return eOrdinatoCrescenteRircorsivo(v, indStart+1);
        */


    }
    
/*
    ESERCIZI
    1)Usando la ricorsione, scrivere un metodo che conta il numero di occorrenze di una persona all'interno di un array di persone (l'uguaglianza di due persone va verificata tramite l'invocazione di equals)
*/
    private static int contaPersone(Persona[] a, Persona p, int indStart) {
        if (a==null || p==null || indStart== a.length)
            return 0;
        if (a[indStart].equals(p))
            return 1+contaPersone(a, p, indStart+1);
        else
            return 0+contaPersone(a, p, indStart+1);
    }
    /*
    2) Usando la ricorsione, scrivere un metodo che, preso in input un array di persone, restituisca il numero di volte in cui una persona ha un'età maggiore rispetto a quella in posizione successiva
    */
    private  static int etaMaggiore(Persona[] p,int i) {
        if (p==null  || i== p.length-1)
            return 0;
        if (p[i].eta>p[i+1].eta )
            return 1+etaMaggiore(p, i+1);
        else
            return 0+etaMaggiore(p, i+1);
    }
    /*
    3)Usand.o la ricorsione, scrivere un metodo che, preso in input un vettore di interi a ed un intero n, restituisca il vettore contenente le posizioni in cui a contiene n
    
    private static int[] posizioniIn(int[] v, int n) {
        if (v != null) {
            
        }
    }
*/
    //stampa vettore 
    public static void stampaArray(int[] a) {
        IO.print("[");
        stampaSequenza(a,0);
        IO.print("]");
    }
    private static void stampaSequenza(int[] a, int i) {
        if (i <a.length) {
            IO.print(a[i]+", ");
            stampaSequenza(a,i+1);
        }
    }
    public static <T> void stampaLinkedList(LinkedList<T> ll) {
        if (ll != null && ll.size()>0) {
            IO.print("[");
            ListIterator<T> i= ll.listIterator();
            stampaLinkedList(i);
        }
        IO.print("]");
    }
    private static <T> void stampaLinkedList(ListIterator<T> i) {
        
        IO.print(i.next());
        if(i.hasNext()){
            IO.print(", ");
            stampaLinkedList(i);
        }
        
    }
    public static <T> void StampaInversa(LinkedList<T> ll) {
        IO.print("[");
        if (ll != null) {
            ListIterator<T> i= ll.listIterator(ll.size());
            StampaInversa(i);
        }
        IO.print("]");
    }
    public static <T> void StampaInversa(ListIterator<T> i){
        IO.print(i.previous());
        if (i.hasPrevious()) {
            IO.print(", ");
            StampaInversa(i);
        }
    }

    public static void main(String[] args) {/*
        IO.println("5! = "+FattorialeRicorsivo(5));
        IO.println("5! = "+fattoriale(5));
        IO.println(iesimoFibonacciRicorsivo(9));
        */
        int[] vettore={6,3,5,2,8,4,7,1};
        IO.println("il massimo dalla posizione 3 e' : "+maxRicorsivo(vettore, 3));
        IO.println("la somma del vettore e' : "+sommaRicorsiva(vettore, 0));
        IO.println("il vettore è crescente? "+eOrdinatoCrescenteRicorsivo(vettore, 0));
        // 1)
        stampaArray(vettore);
        Persona a= new Persona("a",1);
        Persona b= new Persona("b",2);
        Persona c= new Persona(a);
        IO.println(a.equals(c));
        Persona[] arrayPersone={b,a,b,a};
        IO.println("La persona "+c.nome+" e' presente nell'array "+contaPersone(arrayPersone, c, 0));
        // 2)
        IO.println(etaMaggiore(arrayPersone, 0));
        LinkedList<Integer> ll= new LinkedList<>();
        ll.add(1);ll.add(2);ll.add(3);ll.add(4);
        IO.println(ll);
        IO.println("fatta in maniera ricorsiva: ");
        stampaLinkedList(ll);
        IO.println("\nLista al contrario: ");
        StampaInversa(ll);
        
    }

}
