package esercitazione0104;

import IO.IO;

public class esercizi {
    
    // 1) stampare una stringa al contrario con metodo ricorsivo.
    private static void reverseString(String str) {
        if(str==null || str.length()<=1)
            IO.println(str);
        else{
            IO.print(str.charAt(str.length()-1));
            reverseString(str.substring(0,str.length()-1));
        }
    }
    private static void reverseStringInd(String str, int i) {
        if (str==null || i<0) {
            IO.print(" ");
        }
        else{
            IO.print(str.charAt(i));
            reverseStringInd(str, i-1);
        }

    }
    //2) verifica numeri primi
    private static void scomponi(int n) {
        int quoziente, resto;
        int divisore=1;
        if (n>=1 && n<=3) {
            IO.print(n+" e' un fattore primo");
        }  
            do{
                ++divisore;
                quoziente=n/divisore;
                resto=n%divisore;
            }while(resto!=0);
            if (divisore!=n) {
                scomponi(quoziente);
                scomponi(divisore);
            } else {
                if(n!=1)
                    IO.println(n+"è un fattore primo");
            }
        
    }
    //3) massimo comune divisore con algoritmo di euclide
    private static int mcd(int a, int b) {
        if (a%b==0) {
            return b;            
        } else {
            if (a>b) {
                return mcd(b,a%b);
            }
            else return mcd(a,b%a);
        }
    }
    public static void main(String[] args) {
        String input="abcde";
        reverseString(input);
        reverseStringInd(input, input.length()-1);
        IO.println("\n"+mcd(35, 20));
        scomponi(100);
    }
}
