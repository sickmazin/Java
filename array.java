
import IO.IO;

public class array {
    
    public static void main(String[] args){
        /*
        // gli array saranno di tipo omogeneo e dinamiche , 
        quindi può contenere soltato elementi dello stesso tipo. Per esempio solo interi o solo stringhe.
        int[] vector={5,6,7}; // come inizializzare un'array che conterra solo interi
        for (int i=0; i<vector.length  come sapere la lunghezza dell'array ; i++) 
            IO.print(vector[i]);

        int [] v1= new int[3]; // mi permette di inizializzare un vettore con 3 spazi vuoti in cui contenere interi 
        for (int i =0; i<v1.length; i++)
            v1[i]= IO.readInt(" Dammi un numero: "); // vado ad assegnare il valore nella posizione 0 e cosi via
        
        IO.print(" Sequenza inserita: ");
        for(int i=0; i<v1.length;i++)
            IO.print(v1[i]+" ");
        
        IO.println("Sequenza al contrario: ");
        for (int i=v1.length - 1; i>=0; i--)
            IO.print(v1[i]+" ");

        // v1={1,2,3};  questo non è possibile farlo poichè l'array è gia stato gia inizializzato. 
        Non possiamo associare costanti ad un array già inizializzato
    }
        Se vado ad inizializzare un array di oggetti tipo Persona[] p= new Persona[3]; 
        ogni celletta di questo array avrà il valore null perché il contenuto di ogni cella non è definito
    */
        int n=IO.readInt("Dammi la dimensione della stringa: ");

        int[] v=new int[n];
        
        for (int i=0; i<v.length;i++)
            v[i]= IO.readInt("Dammi il numero in posizione "+i+": ");

        for (int i=0 ; i<v.length/2; i++){
            if (v[i]!=v[v.length-i-1]){
                IO.print(" Non è simmetrico");
                break;}
        }
        IO.print(" E' simmetrica");
    }

}

