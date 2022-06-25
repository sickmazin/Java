package esercitazione1803;

public class maxConsecutivi {
    // 2.Scrivere  un metodo maxConsecutivi che,datauna  stringa,restituisce  la  massima  sottostringa  di  caratteri lessicograficamente  consecutivi. Per  esempio,  se la  stringa  è “sbCdeFgruodefozpkrstuv”, il  metodo  restituisce“bCdeFg”.
    public static String maxConsecutive(String s) {
        String lc= s.toLowerCase();
        int max=1;
        int indice=0;
        int cont =1;
        for (int i = 0; i < lc.length(); i++) {
            for (int j = i; j < lc.length()-1; j++) {
                if(lc.charAt(j+1)-lc.charAt(j)==1)
                    cont++;
                else
                    break;                
            }
            if (cont>max){
                max =cont;
                indice =i;
            }
            i+= cont;
            indice=i;
        }
        String maxSubString= s.substring(indice,indice+max);
        return maxSubString;
    }
}
