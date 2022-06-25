package esercitazione1103;
import IO.*;
public class es_11_03 {
     /* es1:
        Scrivere un metodo "Verifica Palindromo" 
    */
    private static boolean verificaPalindromoWhile(char [] v){
        boolean verificato=true;
        int i=0;
        while (verificato && i<v.length/2){
            if (v[i]!=v[v.length-i-1])
                verificato=false;
        }
        return verificato;
    }
    private static boolean verificaPalindromoFor(char[]v){
        boolean verificato=true;
        for(int i =0; i< v.length/2 && verificato; i++){
            if (v[i]!= v[v.length-i-1])
                verificato=false;
        }
        return verificato;
    }
    public static void main(String[]  args){
        char [] v= {'a','n','n','a'};
        boolean isPalindromo= verificaPalindromoFor(v);
        boolean isPalindromo2= verificaPalindromoWhile(v);
        IO.print(isPalindromo);
        IO.print(isPalindromo2);
    }
    
    /*es 2:
        Rimuovi vocali, da un char elimina le vocali
    */
    

}

