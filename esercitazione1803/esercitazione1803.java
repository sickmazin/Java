package esercitazione1803;
import IO.*;

public class esercitazione1803 {
    public static void stampaMatrici(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                IO.print(m[i][j]+"\t");
            }
            IO.println();
        }
    }
    public static int[][] elaboraMatrice(int[][] M) {
        int n = M.length;
        int m = M[0].length;
        int[][] A= new int[n][m];
        int r=0;
        int c=0;
        for (int i = 0; i < n; i++) {
            c=0;
            for (int j = 0; j < m; j++) {
                if (j != m-i-1){
                    A[r][c] = M[i][j];
                    c++;
                }
            }
            r++;
        }
        return A;
    }
    //8.Si scriva un metodo mediaViciniche riceve una matrice di interi, e restituisce una matrice M2 contenente per ogni elemento M[i][j] la media ottenuta da M[i][j] e dai suoi vicini. 
    /*
    public static float[][] mediaVicini(int[][] M) {
        float[][] M2 = new float [M.length][M[0].length];
        int ir=0;
        int ic=0;
        int fr=0;
        int fc=0;
        for (int i = 0; i < M2.length; i++) {
            for (int j = 0; j < M2[0].length; j++) {
                ir=i-1;
                ic=j-1;
                fr=i+1;
                fc=j+1;
                break;
            }
        }
        return M2;
    }
    public static float media(int[][] M, int iR, int iC, int fR, int fC) {
        float somma =0;
        float media=0;
        float cont=0;
        for (int i = iR; i < fR; i++) {
            for (int j = iC; j < fC; j++) {
                somma+=M[i][j];
                cont++;
            }
        }
        media = (float) somma/cont;
        return media;
    }*/
    public static void main(String[] args) {
        int n= IO.readInt("n= ");
        int m=IO.readInt("m= ");
        int [][] M= new int [n][m];
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
            M[i][j]= IO.readInt("M["+i+"]  ["+j+"]= ");
            }
        }
        stampaMatrici(M);
        int[][] eM= elaboraMatrice(M);
        IO.println("la nuova matrice risultante e' ");
        stampaMatrici(eM);
    }
}
