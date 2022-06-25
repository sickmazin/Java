package esercitazione1803;
import IO.*;

public class elaboraArray1 {
    //5.Si scriva  un metodo elaboraArrayche  riceve  una  matrice  quadrata  di interi Me  due  interi xe ye  restituisce un vettore V contenente gli elementi diMescludendo la riga x e la colonnay(si veda l’esempio sottostante). 
    public static int[][] elaboraArray (int[][] M, int x, int y) {
        int n = M.length;
        int m = M[0].length;
        int[][] nM = new int [n-1][m-1];
        for (int i = 0; i < nM.length; i++) {
            if(i!=x){
                for (int j = 0; j < nM.length; j++) {
                    if (j!=y)
                        nM[i][j]= M[i][j];
                }
            }
        }
        return nM;
    }
    public static void main(String[] args) {
        int n= IO.readInt("Numero di righe della colonna: ");
        int m= IO.readInt("Numero di colonne della colonna: ");
        int[][] M = IO.matriceInt(n, m);
        int[][] nM= elaboraArray(M, 2, 2);
        IO.printMatrici(nM);
    }
}
