package esercitazione1803;
public class spaziVocali2 {
    //1.Scrivere  un metodospaziVocaliche  datauna  stringa restituisce il  numero  complessivo  di  spazi  che  sono immediatamente  seguiti da  una  vocale. Per esempio, se la  stringa  è "A  ogni uomo, ogni giorno, I suoi diritti", il metodo restituisce 4.
    public static int spaziVocali(String s) {
        String vocali= "aeiouAEIOU";
        int cont=0;
        int current = s.indexOf(' ');
        while (current !=-1 && current+1< s.length()){
            if (vocali.indexOf(s.charAt(current+1))!=-1)
                cont++;
            current = s.indexOf(' ',current +1);
        }
        return cont;
    }   
}
