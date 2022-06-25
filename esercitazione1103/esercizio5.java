package esercitazione1103;

import IO.IO;

public class esercizio5 {
    /*
    dati 2 vettori di char, restituisce true se v1 è l'anagramma di v2
    */
    private static boolean anagramma(char[]v1, char[]v2) {
        boolean verificato=true;
        boolean[] b= new boolean[v1.length];
            for (int i = 0; i < b.length; i++) {
                b[i]=false;
            }

        for (int i = 0; i < v1.length; i++) {
            for (int j = 0; j < v2.length; j++) {
                if(v1[i]==v2[i] && b[j]==false){
                    b[j]=true;
                    break;
                }
            }
        }
        for (int i = 0; i < b.length; i++) {
            if(b[i]==false){
                verificato=false;
                break;
            }
        }
        return verificato;        
    }
    public static void main(String[] args) {
        char[] v1={'n','o','t','i','z','i','a'};
        char[] v2={'t','i','z','i','a','n','o',};
        boolean ris= anagramma(v1, v2);
        IO.print(ris);
    }
}
