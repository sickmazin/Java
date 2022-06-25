package esercitazione1103;

import IO.*;

public class esercizio4 {
    /*tru se tutti gli elementi sono diversi */
    private static boolean verificaDiversi(int[] v) {
        boolean verificato=true;
        for (int i =0;i<v.length && verificato;i++){
            for (int j = i+1; j < v.length-1&& verificato; j++) {
                if (v[i]==v[j])
                    verificato=false;
            }
        }
        return verificato;
    }
    public static void main(String[] args) {
        int n= IO.readInt("Lunghezza vettore: ");
        int [] v= new int[n];
        for (int i = 0; i < v.length; i++) {
            v[i] =IO.readInt("v ["+i+"]== ");
        }
        boolean ris= verificaDiversi(v);
        IO.print(ris);
    }
    
}