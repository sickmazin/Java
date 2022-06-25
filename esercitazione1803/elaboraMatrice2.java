package esercitazione1803;
public class elaboraMatrice2 {
    //3.Un metodo elaboraMatriceche riceve una matrice quadrata di interi Me restituisce una matrice Aottenuta da Meliminando gli elementi che appartengono alla diagonale secondaria.
    
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
}
