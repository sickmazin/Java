package listeconcatenate;
import java.util.LinkedList;
import java.util.ListIterator;


import IO.IO;

public class ListaConcatenataInt {
    private NodoInt head;
    private NodoInt tail;
    private int size;

    public int getSize() {
        return this.size;
    }

    public ListaConcatenataInt() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public ListaConcatenataInt(ListaConcatenataInt l) {// costruttore per copia

        /* COPIA SHALLOW: deprecata! non può andare bene
        this.head=l.head;
        this.tail=l.tail;
        this.size=l.size;
        copia shallow che permette cambiamenti ibridi. Accade che se cambiamo qualcosa nella copia, si ripercuote nella prima lista. 
        Se aggiungiamo in coda non cambia mentre se aggiungiamo in un altro posto cambierà anche per la prima lista*/

        //COPIA PROFONDA, si va a creare un nuovo node con la info del node corrispondente in l e metto tale node in coda alla lista che sto costruendo
        inizializza();
        if (l != null) {
            NodoInt i=l.head;
            while (i.getNext()!=null) {
                aggiungiHead(i.getInfo());
                i=i.getNext();
            }
        }
    }
    private void inizializza(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    public ListaConcatenataInt(int[] a) {
        if (a == null || a.length<0) {
            inizializza();
        }
        for (int i : a) {
            aggiungiTail(i);
        }
    }

    public void aggiungiHead(int info) {
        NodoInt newHead = new NodoInt(info, this.head);
        this.head = newHead;
        if (this.tail == null) {
            this.tail = newHead;
            this.size++;
        }
    }

    public void aggiungiTail(int info) {
        NodoInt newTail = new NodoInt(info, null);
        if (this.size == 0) {
            this.head = newTail;
            this.tail = newTail;
        } else {
            this.tail.setNext(newTail);
            ;
            this.tail = newTail;

        }
        this.size++;
    }

    public void rimuoviHead() {
        if (this.size == 0) {
            throw new EccezioneListaVuota();
        }
        if (this.size == 1) {
            this.head = null;
            this.tail = null;
        }
        this.head = this.head.getNext();
        this.size--;
    }

    public void rimuoviTail() {
        if (this.size == 0) {
            throw new EccezioneListaVuota();
        }
        if (this.size == 1) {
            this.head = null;
            this.tail = null;
        }
        NodoInt j = this.head;
        for (int i = 0; i < this.size - 2; i++) {
            j = j.getNext();
        }
        this.tail = j;
        this.tail.setNext(null);
        this.size--;
    }

    public int get(int index) {
        if (index < 0 || index > this.size) {
            throw new EccezioneIndiceNonValido();
        }
        NodoInt i = this.head;
        for (int j = 0; j < index; j++) {
            i = i.getNext();
        }
        return i.getInfo();

    }

    /*
     * public String toString() {
     * String ret = "[";
     * for (NodoInt j = head; j != null; j.getNext()) {
     * ret += j.getInfo() + ",";
     * if (j.getNext() == null) {
     * ret += j.getInfo();
     * }
     * }
     * return ret + "]";
     * }
     */
    public String toString() {
        String s = "[";
        for (NodoInt n = head; n != null; n = n.getNext()) {
            s += n;
            if (n.getNext() != null)
                s += ", ";
        }
        s += "]";
        return s;
    }
    public void rimuovi(int index){

    }


    // 15  febbraio 2022
    /*
Si arricchisca la classe ListaConcatenataIntsviluppata durante il corso con un metodoverifica che restituisca
true se e solo selista è ordinata secondo il seguente criterio:  ogni numero in posizione 
pari è maggiore del doppio dell’elemento che  occupa  la  posizione  pari  precedente(se  esiste),  
mentre  ogni  numero  in  posizione  dispari  è  maggiore  del  triplo dell’elemento  che  occupa  la  posizione  dispari  precedente(se  esiste).
Il  metodo verifica dovrà  essere  ricorsivo  o invocare un opportuno metodo ricorsivo sulla classe NodoInt.
    */
    public boolean verifica() {
        if(size<=2) return true;
        return verifica(head,0);
    }

    private boolean verifica(NodoInt nodo, int i) {
        if(nodo==null  || i+2>size) return true;
        NodoInt succ= nodo.getNext().getNext();
        if(i%2==0 && succ.getInfo()/nodo.getInfo()<=2) return false;
        if(i%2!=2 && succ.getInfo()/nodo.getInfo()<=3) return false;
        return verifica(nodo.getNext(),++i);
    }

    public void aggiungi(int info, int index) {
        if (index < 0 || index > this.size)
            throw new EccezioneIndiceNonValido();
        NodoInt j = this.head;
        for (int i = 0; i < index-1; i++) {
            j = j.getNext();
        }
        NodoInt nuovo = new NodoInt(info, j.getNext());
        j.setNext(nuovo);
        this.size++;
    }

    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (o == this)
            return true;
        if (o.getClass() != this.getClass())
            return false; 
        ListaConcatenataInt a = (ListaConcatenataInt) o;
        if(a.size!= this.size) return false;
        NodoInt i1= this.head;
        NodoInt i2=a.head;
        while(i1!=null){
            if(i1.getInfo()!=i2.getInfo()) return false;
            i1=i1.getNext();
            i2=i2.getNext();
        }    
        return true;
    }

    public int sommaIterativa() {
        int s=0;
        for (NodoInt i=this.head; i.getNext()!= null; i.getNext()) {
            s+=i.getInfo();
        }
        return s;
    }

    public int sommaRicorsiva() {
        return sommaRicorsiva(this.head);
    }

    private int sommaRicorsiva(NodoInt i) {
        if (i == null) {
            return 0;
        }
        return i.getInfo()+sommaRicorsiva(i.getNext());
    }

    public static int sommaRicorsivaStatic(ListaConcatenataInt l) {
        if (l == null || l.size==0) return 0;
        ListaConcatenataInt lCopy=new ListaConcatenataInt(l);
        lCopy.rimuoviHead();
        return l.head.getInfo()+sommaRicorsivaStatic(lCopy);
    }

    public boolean alternati() { //restituisce true se si incontrano valori alternati tra positivo e negativo scandendo la lista
        if (this.size <=1) return true;
        if(this.head.getInfo()>=0){
            return alternati(head.getNext(),false);
        }
        return alternati(head.getNext(),true);
    }

    private boolean alternati(NodoInt nodo, boolean valore) {
        if(nodo==null) return true;
        if(valore && nodo.getInfo()>=0) return alternati(nodo.getNext(),false);
        if(!valore && nodo.getInfo()<0)return alternati(nodo.getNext(),true);
        return false;
    }

    public void stampaRicorsiva() {
        IO.print("[");
        if (this != null && this.head!=null) {
            stampaRicorsiva(this.head);
        }
        IO.print("]");
    }

    private void stampaRicorsiva(NodoInt nodo) {
        IO.print(nodo.getInfo());
        if (nodo.getNext()!=null) {
            IO.print(", ");
            stampaRicorsiva(nodo.getNext());
        }
    }

    public boolean eOrdinatoCrescente() {
        if (this.size<=1) return true;
        return servizioOrdinata(this.head.getInfo(),this.head.getNext());
    }


    private boolean servizioOrdinata(int precedente, NodoInt n) {
        if (n==null) return true;
        if (n.getInfo()<precedente) return false;
        return servizioOrdinata(n.getInfo(), n.getNext());
            
    }
    /*  scrivere un metodo ricorsivo che conta quante volte c'è un cambio di ordinamento (crescente o decrescente) 
        in una ListaConcatenataInt, In una LinkedList<Integer>, in un int[]
        Ad esempio:
        [1 2 3 4 3 2 3 4 5]
        ha due cambi di ordinamento
    */
    public static int cambioOrdinamento(int[] v) {
        if (v.length<=2 ||v==null) return 0;
        int i=1;
        while (i<v.length && v[i]==v[i+1]) {
            i++;
            if(i==v.length) return 0;
        }
        boolean prossimoOrd= v[i]>v[i-1];
        return cambioOrdinamento(v,i+1,prossimoOrd);
    }
    private static int cambioOrdinamento(int[] v, int i, boolean ordinamentoAtt) {
        if(i==v.length) return 0;
        boolean prossimoOrd;
        if(v[i]>v[i-1]) prossimoOrd=true;
        else
            if(v[i]<v[i-1]) prossimoOrd=false;
            else prossimoOrd=ordinamentoAtt;
        if(prossimoOrd==ordinamentoAtt) return cambioOrdinamento(v,i+1,prossimoOrd);
        else return 1+cambioOrdinamento(v, i+1, prossimoOrd);
    }
    /*
    Verificare che una LinkedList sia palindroma
    */
    public static boolean palindromaRic(LinkedList<Integer> l) {
        if(l==null || l.size()<2) return true;
        ListIterator<Integer> i=l.listIterator();
        ListIterator<Integer> j= l.listIterator(l.size());
        return palindromaRic(i,j,l);
        
    }
    private static boolean palindromaRic(ListIterator<Integer> i, ListIterator<Integer> j,  LinkedList<Integer> l) {
        if (i.nextIndex()==l.size()/2) return true;  
        if(i.next().equals(j.previous())) {
            return palindromaRic(i,j,l);
        }
        return false;
    }
    public static boolean palindromaRic(int[] v) {
        if(v.length<=1 || v==null) return true;
        if(!(v[0]==v.length-1)) return false;
        return palindromaRic(v,0);
    }
    private static boolean palindromaRic(int[] v, int i) {
        if(i==v.length/2) return true;
        if(!(v[i]==v[v.length-1-i])) return false;
        return palindromaRic(v, i+1);
    }

    //esercizio 2 17 febbraio 2021
    public boolean verificaUgualiConsecutivi(int x) {
        if (this.size<=1) return false;
        return verificaUgualiConsecutivi(x,this.head, head.getNext());
    }

    private boolean verificaUgualiConsecutivi(int x, NodoInt head, NodoInt next) {
        if(x==0) return true;
        if (next == null) return false;
        if(head.getInfo()==next.getInfo()) return verificaUgualiConsecutivi(--x, next, next.getNext());
        return verificaUgualiConsecutivi(x, next, next.getNext());
    }
    // 01 febbraio 2022
    /*
    Si arricchisca la classe ListaConcatenataInt sviluppata durante il corso con un metodo contaTriple() 
    che conta quante volte la lista contiene una sottosequenza di tre elementi consecutivi di cui il primo negativo, il secondo uguale a zero e il terzo positivo.
     Ad esempio, la lista [5,-1,0,2,-2,-4,0,1,-2,-3,0,3,0,-2,0] contiene tre triple della forma richiesta (in grassetto). 
    Il metodo contaTriple dovrà essere ricorsivo o invocare un opportuno metodo ricorsivo sulla classe NodoInt.  
    */
    public int contaTriple(){
        if(size<=2) return 0;
        return contaTriple(head, -1,0);
    }


    private int contaTriple(NodoInt nodo, int flag, int cont) {
        if(nodo==null) return cont;
        if(flag==-1 && nodo.getInfo()<0) return contaTriple(nodo.getNext(),0,cont);
        if(flag==0 && nodo.getInfo()==0)return contaTriple(nodo.getNext(),1,cont);
        if(flag==1 && nodo.getInfo()>0) return contaTriple(nodo.getNext(),-1,cont++);
        if(nodo.getInfo()<0) return contaTriple(nodo.getNext(),0,cont);
        return contaTriple(nodo.getNext(),-1,cont);
    }

    // ESERCIZIO 2 TRACCIA 16 SETTEMBRE
    public boolean stesseSottoSequenze(){
        if(this.head == null && this.size%2 != 0){
            return false;
        }
        return stesseSottoSequenze(this.head, this.head.getInfo(),0);
    }
    private boolean stesseSottoSequenze(NodoInt nodo, int info, int i) {
        if(i< this.size-2) return true;
        if(nodo.getNext().getNext().getInfo()== info) return stesseSottoSequenze(nodo.getNext(),nodo.getNext().getInfo(),i+1);
        else return false;
    }


    // ESERCIZIO 2 TRACCIA  23 LUGLIO 2020
    /*che restituisca il numero di elementi della lista che sono minori 
    o uguali alla media aritmetica tra l’elemento precedente e l’elemento successivo. 
    Si assuma che il primo elemento della lista è preceduto da 0 e 
    che all’ultimo elemento della lista succede il valore 0. 
    */
    public int contaElementi(){
        return contaElementi(0,head,0);
     
    }


    private int contaElementi(int precedente, NodoInt nodo,int c) {
        if(nodo.getNext() == null ){
            if(nodo.getInfo()<=(precedente/2))
                return c+1;
            else
                return c;
        }
        int succ=nodo.getNext().getInfo();
        float media= (precedente+succ)/2;
        if(media > nodo.getInfo())
            return contaElementi(nodo.getInfo(),nodo.getNext(),c);
        return  contaElementi(nodo.getInfo(),nodo.getNext(),c++);
            
    }
    // ESERCIZIO 2 TRACCIA  17 07 2018
    /*
     * Si arricchisca la classe ListaConcatenataInt sviluppata durante i l corso con un metodo verificaSottoliste(int l, int t) 
     * che restituisce il numero di sottoliste di lunghezza l la cui somma è almeno t, ad esempio la lista 
     */
    public int verificaSottoliste(int l, int t){
        if(this==null || this.size==0) return -1;
        return verificaSottoliste(l, t,head,0,0,0,head.getNext());
    }

   private int verificaSottoliste(int l, int t, NodoInt nodo,int cnt,int somma, int i,NodoInt inz) {
        if(nodo.getNext()==null){
            if(somma+nodo.getInfo()>=t) return i+1;
            return i;
        }
        if (cnt<l){
            int s= somma+nodo.getInfo();
            return verificaSottoliste(l, t,nodo.getNext(),cnt+1,s,i,inz);
        } 
        if(cnt==l && somma>=t) return verificaSottoliste(l, t, inz, 0, 0, i+1,inz.getNext());
        return verificaSottoliste(l, t, inz, 0, 0, i,inz.getNext());
    }
    // esercizio tarccia 21 02 2018
    public boolean verificaZeri(){
        return verificaZeri(head.getNext(),head);
    }
    public boolean verificaZeri(NodoInt nodo, NodoInt precedente){
        if(nodo.getNext()== null || nodo==null) return true;
        if(nodo.getInfo()==0) return verificaZeri(nodo.getNext(), precedente);
        if(nodo.getInfo()!=0) {
           System.out.println(contaZeri(precedente)); System.out.println(contaZeri(nodo));
            if(contaZeri(nodo)>=nodo.getInfo() && contaZeri(precedente)>=nodo.getInfo())
                return verificaZeri(nodo.getNext(),nodo);
        }
        return false;
    }
    private int contaZeri(NodoInt nodo) {
        int c=0;
        if(nodo.getInfo()!=0)   nodo= nodo.getNext();
        if(nodo==null || nodo.getNext()==null) return c;
        while(nodo.getInfo()==0){
            c++;
            if(nodo==null || nodo.getNext()==null) return c;
            nodo=nodo.getNext();
        }
        return c;
    }
    // esercizio 24 09 2018
    //prende in input una lista lunga il doppio della prima e restituisce true se e solo se ogni
    //elemento della prima è uguale alla somma dei due numeri corrispondenti nella seconda,
    // ad esempio le liste [3, 0, 7, -2, 1, 5, 2, -10] e [3, 5, 6, -8] verificano la condizione.

    public static ListaConcatenataInt verificaPresenza(ListaConcatenataInt l) {
        if(l==null || l.head==null) return null;
        ListaConcatenataInt n= new ListaConcatenataInt();
        n.head=verificaPresenza(l.head);
        return n;
    }

    private static NodoInt verificaPresenza(NodoInt nodoL) {
        if(nodoL==null || nodoL.getNext()==null) return null;
        NodoInt succ=nodoL.getNext().getNext();
        NodoInt n= new NodoInt(nodoL.getInfo()+nodoL.getNext().getInfo(), verificaPresenza(succ));
        return n;
    }
    // ESERCIZIO 20 09 2021
    public int contaCambiOrdinamento(){
        if(head==null) return -1;
        return contaCambiOrdinamento(head,0,true);
    }

    private int contaCambiOrdinamento(NodoInt nodo, int i, boolean cresc) {
        if(nodo==null || nodo.getNext()== null) return i;
        if(nodo.getInfo()>nodo.getNext().getInfo() && cresc) return contaCambiOrdinamento(nodo.getNext(), i+1, false);
        if(nodo.getInfo()<=nodo.getNext().getInfo() && cresc) return contaCambiOrdinamento(nodo.getNext(), i, true);
        if(nodo.getInfo()>=nodo.getNext().getInfo() && !cresc) return contaCambiOrdinamento(nodo.getNext(), i, false);
        if(nodo.getInfo()<nodo.getNext().getInfo() && !cresc) return contaCambiOrdinamento(nodo.getNext(), i+1, true);
        return contaCambiOrdinamento(nodo.getNext(), i, cresc);
    }

    // ESERCIZIO 15 06 2022
    public int contaElementiSpeciali(int b){
        if (head== null || size==0) return -1;
        return conta(head,b,0,0);
    }
    private int conta(NodoInt nodo, int b, int c, int somma) {
        if(nodo.getNext()==null) {
            if(nodo.getInfo()>b-somma) return c;
            return c;
        }
        if(nodo.getInfo()>b-somma) return conta(nodo.getNext(), b, c+1, somma+nodo.getInfo());
        else    return conta(nodo.getNext(), b, c, somma+nodo.getInfo());
    }

    public static void main(String[] args) {
        int[] v={5,3,1,0,2,-1,4,6,-9};
        ListaConcatenataInt a = new ListaConcatenataInt(v);
        System.out.println(a.contaElementiSpeciali(10));
   }
}