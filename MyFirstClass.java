	/*
import IO.*;
public class MyFirstClass{
	

	public static void main(String[] args){
		IO.println("Ciao");
		int m=IO.readInt(" Dammi un interno m:");
		int n=IO.readInt(" Dammi un interno n:");
		if (m>n) 
		{
			IO.print(m + " e' maggiore di  " + n);   // se voglio dare più istruzioni all'if devo inserirle nelle parentesi graffe
		}
			else 
			if (m<n) 
				IO.println("il secondo numero e' maggiore");
			else 
				IO.println("i due numeri sono uguali");
	}
}

boolean

byte      8 bit
short    16 bit
int       32 bit
long   64 bit

float      32 bit
double  64 bit

char


public class MyFirstClass{
	public static void main(String[] args){
		float m=10.5f; // il valore numero decimale va sempre considerato un double se non ci aggiungiamo una f alla fine del numero per i float e una d per i double
		double x= 10.2d;
		float n= IO.readFloat( "Dammi un numero decimale n: ");
		if (m==n)
			IO.print("i due numeri sono uguali");
		else 
			IO.print("i due numeri sono diversi");

	}
}


public class MyFirstClass{
	public static void main (String[ ] args){
		int m = IO.readInt("Dammi un numero m: ");
		int n = IO.readInt("Dammi un numero n: ");
		int somma= m+n;
		float media= (float)somma/2;
		IO.print("Somma= "+somma+"; Media= "+ media) ;
	}

}


public class MyFirstClass{
	public static void main (String[] args){
		int m= IO.readInt("Dammi un numero m: ");
		IO.println("Adesso leggero da tastiera "+m+"numeri");
		int somma=0;
		for (int i=0; i<m; i++){
			int n=IO.readInt("Numero in posizione "+i+":");
			IO.println(i+") Ciao");
			somma = somma+ n;
	}
}}
// for (X; Y; Z)   X è la variabile della condize; Y è la condizione per il quale si verifica il for ; mentre  Z è l'incremento della variabile

// Le variabili create per il for hanno vita soltanto all'interno di esso, all'esterno non esisteranno 

// legge un numero e fare il fattoriale di esso

public class MyFirstClass{
	public static void main(String[] args){
		int m= IO.readInt("Quanti numeri?");
		int somma=0;
		for(int i=0; i<m; i++){
			int n= IO.readInt("numero: ");
			somma= somma + n;  possiamo ottimizzare questo con: 
			somma+= IO.readInt("numero: ");
		}
		float media = (float)somma/m;
		IO.print("la media e':"+media+" mentre la somma e': "+ somma);
		
	}
}

public class MyFirstClass{
	public static void main(String[] args){
		IO.println("Sequenza di numeri terminata con un numero negativo");
		int somma=0;
		int c=0;
		boolean negativo=true;
		for (int i=1; negativo==true; i++){
			int n =IO.readInt("Inserisci il "+i+"° numero: ");
			if (n>0){
				somma+=n;
				c++; // senza utilizzare un contatore è possibile utilizzare una variabile non inizializzata nel for ma prima così che mantenga il valore anche dopo
			}
			else 
				negativo= false;
		}
		float media= (float)somma/c;
		IO.print("La somma e': "+somma+" mentre la media e' : "+media);
	}
}

public class MyFirstClass{
	public static void main(String[] args){
		int n= IO.readInt("Numero di cui calcolare il fattoriale: ");
		double fattoriale=1;
		for (int i=2; i<=n; i++){
			fattoriale*=i;
		}
	IO.print("Il fattoriale e': "+fattoriale);
	}
}

// WHILE
public class MyFirstClass{
	public static void main(String[] args){
		int m = IO.readInt("Dammi un numero: ");
		long fattoriale=1;
		int i=2;
		while(i<=m){  // il while prenderà soltanto la condizione per il quale funzionare quindi la variabile che utilizza deve necessariamente essere inizializzata prima
			fattoriale*=i;
			i++;
		}
		IO.print("il fattoriale e' : "+ fattoriale);
	}
}

public class MyFirstClass{
	public static void main(String[] args){
		int pos=0;
		int neg=0;
		boolean flag=true;
		while (flag){  // se vogliamo la variabile falsa è !flag
			int n= IO.readInt("dammi un numero: ");
			if (n>0)
				pos++;
			else 
				if (n<0) 
					neg++;
				else
					flag = false;
		}
		IO.print("numeri positivi: "+pos); IO.println( "numeri negativi: "+neg);
	}
}

// legge una sequenza di numeri crescente di numeri interi. terminata con il numero inserito non maggiore del precedente. restituire  il massimo dei numeri in posizione dispari. for e while

public class MyFirstClass{
	public static void main(String[] args){
		boolean flag=true;
		int d=0;
		int m= IO.readInt("Un numero: ");
		while (flag){
			int n= IO.readInt("Un numero: ");
			if(n>m){
				d++;
			}
			else {
				flag= false;
				if (d%2==0)
					IO.println("Il massimo in posizione dispari è "+m);
				else
					IO.println("Il massimo in posizione dispari è "+n);
			}
			m=n;
		}
	}
}
public class MyFirstClass{
	public static void main(String[] args){
		boolean flag=true;
		int i=0 ; 
		int m=IO.readInt("Un numero: ");
		int n=IO.readInt("Un numero: ");
		for (; flag==true; i++){
			n=IO.readInt("Un numero: ");
			if (n<m){
				flag= false;				
			}
			else m=n;
		}		
		if (i%2==0)
			IO.println("Il massimo in posizione dispari è "+m);
		else
			IO.println("Il massimo in posizione dispari è "+n);
	}
	
	public static void main(String[] args) {
		//è possibile creare un oggetto che corrisponde ad una determinata classe, tipo Persona
		Persona p1= new Persona();
		Persona p2=new Persona("Mattia",19);
		Persona p3= new Persona(IO.readString("Nome della persona: "), 	IO.readInt("Eta' della persona: "));

		IO.println("Persona #1");
		IO.println("Nome: "+p1.nome+" Eta': "+p1.eta);

		
		IO.println("Persona #2");
		IO.println("Nome: "+p2.nome+" Eta': "+p2.eta);

		
		IO.println("Persona #3");
		IO.println("Nome: "+p3.nome+" Eta': "+p3.eta);
	}

	public static int maxEta(Persona[] arrayP) {
		int max=0;
		if (arrayP==null)
			return 0;
		for (int i = 0;  i < arrayP.length; i++) {
			if(arrayP[i].eta>max) max=arrayP[i].eta;
		}
		return max;
	}
public static void main(String[] args) {
	Persona p1=new Persona();
	//per andare a cambiare le variabili dell'oggetto vado ad utilizzare il metodo setNomevariabile() per modificarlo. Questo viene effettuato principalmente quando le variabili iniziali dell'oggetto sono del tipo private, esso non possono essere modificate se chiamate in un altro file
	p1.setEta(12);
	p1.setNome("Mattia");
	IO.println(p1.nome+" "+p1.eta);
}


// leggere da input 3 persone e inserirle in un array apposito , leggere una quarta persona e stampare la posizione in cui essa si trova nell'array. -1 se non è presente. Stampare l'età massima tra le persone dell'array.
public static Persona[] arraydiPersona(int n) {
	Persona[] arrayP= new Persona[n];
	IO.print("Dammi i dati di "+n+" persone");
	for (int i = 0; i < arrayP.length; i++) {
		arrayP[i]= new Persona(IO.readString("Nome: "), IO.readInt("Eta': "));
	}
	IO.println("Dammi un'ulteriore persona");
	Persona p=new Persona(IO.readString("Nome: "), IO.readInt("Eta': "));
	for (int i = 0; i < arrayP.length; i++) {
		if (arrayP[i].equals(p))
			IO.println("l'ultima persona inserita è uguale alla persona in posizione: "+i);
		else 
			IO.println("L'ultima persona inserita non è presente nell'array");
	}
	int max= maxEta(arrayP);
	IO.println("l'eta' massima delle prime persone inserite è di : "+max);
	return arrayP;
	}
}
*/