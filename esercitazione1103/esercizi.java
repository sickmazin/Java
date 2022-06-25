package esercitazione1103;

import IO.IO;

public class esercizi {
    public static void main(String[] args){
        /* 1) Leggere da tastiera un numero intero positivo n, ripetendo 
                la lettura finchè il valore di n inserito non sia pari 
                (a tal fine, si osservi che in JAVA il resto della 
                divisione tra due interi x, y è restituito dall'espressione x%y). */
                
        int len=0;
        for  (int i = 1;i>0;i++){
            int n=IO.readInt(" Dammi un numero: ");
            if (n%2==0){
                IO.println(n+" e' un numero pari");
                len=n;
                break;
            }
            else
                i++;        
        }
        /*
        2) Creare quindi due array v1, v2 di float, ciascuno di lunghezza n/2.
        */
        float[] v1= new float[len/2];
        float[] v2= new float [len/2];
        /*3) Leggere poi una sequenza di n float, e popolare progressivamente
                da sinistra a destra v1 e v2, inserendo in v1 i numeri 
                della sequenza in posizione pari e in v2 i numeri della 
                sequenza in posizione dispari. */
        int p=0;
        int d=0;        
        for (int j=0;j<len;j++){
            float m= IO.readFloat(" Inserisci un numero float in posizione "+j+" : ");
            if (j%2==0) {
                v1[p]=m;
                p++;
            }
            else {
                v2[d]=m;
                d++;
            }
        }
        IO.println("Sequenza del vettore 1: ");
        for (int i=0; i<v1.length; i++){
            IO.print(v1[i]+" ");
        }
        IO.println("Sequenza del vettore 2: ");
        for (int i=0; i<v2.length; i++){
            IO.print(v2[i]+" ");
        }
        /* 4)  A questo punto, creare un terzo vettore di float la cui 
                cella i-esima contiene la media tra l'elemento di v1 in 
                posizione i e l'elemento di v2 in posizione simmetrica 
                rispetto a i. */
        float[] v3= new float[len/2];
        for (int i=0;i<v1.length;i++){
            float media=(v1[i]+v2[i])/2;
            v3[i]=media;
        }
        IO.print("La sequenza del vettore finale è:  ");
        for (int i=0; i<v3.length; i++){
            IO.print(v3[i]+" ");
        }
    }
}
