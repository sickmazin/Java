import IO.IO;

public class Matrici {
    private int numRighe;
    private int numColonne;
    private int[][] M;

    public  Matrici(int numRighe, int numColonne) {
       this.numRighe=numRighe;
       this.numColonne=numColonne;
       M=new int[numRighe][numColonne];
    }
    public void setValue(int x,int i, int j) {
        M[i][j]=x;
    }
    public int getValue(int i, int j) {
        return M[i][j];
    }
    public int getNumRighe() {
        return  numRighe ;
    }
    public int getNumColonne() {
        return numColonne;
    }
    public boolean esisteValore(int x) {
        return trovaValRec(x, 0, 0);
    }
    private boolean trovaValRec(int x,int i, int j) {
        if (i==numRighe||j==numColonne) {
            return false;
        }if(M[i][j]==x)
            return true; 
        return trovaValRec(x, i, j+1)|| trovaValRec(x, i+1, 0);
    }
    //prodotto tra matrici
    public Matrici prodotto(Matrici m2) {
        if (this.numColonne!=m2.numRighe) {
            throw   new EccezioneLunghezzeDiverse();
        }
        Matrici p=new Matrici(this.numRighe, m2.numColonne);
        for (int i = 0; i < p.numRighe; i++) {
            for (int j = 0; j < p.numColonne; j++) {
                p.setValue(prodottoScalare(m2, i, j, this.numColonne-1),i,j);
            }
        }
        return p;
    }
    private int prodottoScalare(Matrici m2, int i, int j, int k) {
        if(k<0)
            return 0;
        return prodottoScalare(m2, i, j, k-1)+M[i][k]*m2.getValue(k, j);
    }
    //trasposta
    public Matrici trasposta() {
        return traspostaRec(new Matrici(numColonne,numRighe),0,0);
    }
    private Matrici traspostaRec(Matrici T, int i, int j) {
        if (i==numRighe) {
            return T;
        }
        if (j==numColonne) {
            return traspostaRec(T, i+1, 0);
        }
        else
            T.setValue(M[i][j], j, i);
            return traspostaRec(T, i, j+1);
    }
    //simmetrica
    public boolean verificaSimmetrica() {
        if(numRighe!=numColonne)
            throw new EccezioneLunghezzeDiverse();
        return simmetricaRec(1, 0);
    }
    private boolean simmetricaRec(int i, int j) {
        if (i==numRighe|| j==i) {
            return true;
        } 
        if (M[i][j]!=M[j][i]) {
            return false;
        }
        return simmetricaRec(i, j+1) && simmetricaRec(+1, 0);
    }
    //determinante
    public int determinante() {
        if(numColonne!=numRighe)
            throw new EccezioneLunghezzeDiverse();
            return 0;
    }
    public int detRic(int[][ ] m2){
        if (m2.length== 1) {
            return m2[0][0];
        }
        int d=0;
        for (int i = 0; i < m2[0].length; i++) {
            int[][] minore= restituisciMinore(m2,i);
            d=d+(int)Math.pow(-1, i)*m2[0][i]*detRic(minore);
        }
        return d;
    }
    private static int[][] restituisciMinore(int [][]c, int k){
		int [][] min = new int[c.length-1][c[0].length-1];
		int rm =0;
		for (int i = 1; i < c.length; i++) {
			int cm =0;
			for (int j = 0; j < c[0].length; j++) {
				if(j!=k) {
					min[rm][cm]= c[i][j];
					cm++;
				}
			}
			rm++;
		}
		return min;
	}
    private static void leggiMatrice(Matrici m) {
		for (int i = 0; i < m.getNumRighe() ; i++) {
			for (int j = 0; j < m.getNumColonne(); j++) {
				m.setValue(IO.readInt("valore "), i, j);
			}
		}

	}
    public void stampaMatrice() {
		for (int i = 0; i < numRighe; i++) {
			for (int j = 0; j <numColonne; j++) {
				IO.print(M[i][j]+" ");
			}
			IO.println();
		}
		IO.println();
	}
	   

    public static void main(String[] args) {
        Matrici m1 = new Matrici(IO.readInt("n. righe matrice 1?"),IO.readInt("n. colonne matrice 1?"));
        
        leggiMatrice(m1);
        m1.stampaMatrice();
        
        Matrici tr= m1.trasposta();
        tr.stampaMatrice();
        

        int d= m1.determinante();
        IO.println("det "+d);

        
        int x= IO.readInt("valore da cercare? ");
        boolean trovato= m1.esisteValore(x);
        if(trovato) {
            IO.println(x+ "è presente");
        }else {
            IO.println(x+ "non è presente");
        }
        
        

        boolean isSimmetrica = m1.verificaSimmetrica();
        IO.println("simmetrica= "+isSimmetrica);

    
        
        Matrici m2 = new Matrici(IO.readInt("n. righe matrice 2?"),IO.readInt("n. colonne matrice 2?"));

        leggiMatrice(m2);
        m1.stampaMatrice();
        m2.stampaMatrice();
        
        Matrici p= m1.prodotto(m2);
        IO.println("prodotto= ");
        p.stampaMatrice();
    
    }
}
        
