package esercitazione1103;

import IO.IO;

public class rimuovivocali {
    private static char[] copiaVettore(char[] v2, int c) {
        char[] ris=  new char[c];
        for (int i =0; i<ris.length;i++){
            ris[i]=v2[i];
        }
        return ris;
    }
    private static char[] rimuoviVocali(char[] v){
        char[] v2= new char[v.length];
        int c=0;
        for (int i=0; i<v.length;i++){
            if (v[i] != 'a' && v[i] != 'e' && v[i] != 'i' && v[i] != 'o' && v[i] != 'u'){
                v2[c]=v[i];
                c++;
            }
        }
        char[] r= copiaVettore(v2, c);
        return r; 
        
    }
    public static void main(String[] args) {
        char[] c= {'a','c','i','q','e'};
        char[] ris= rimuoviVocali(c);
        IO.print("Ris= {");
        for (int i = 0; i < ris.length; i++) {
            if (i<ris.length-1)
                IO.print(ris[i]+", ");
            else
                IO.print(ris[i]+"}");
        }
    }
}
