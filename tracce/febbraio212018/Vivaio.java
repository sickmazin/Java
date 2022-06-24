package febbraio212018;
import java.util.*;
public class Vivaio {
    private ArrayList<Giardino> giardini;
    public Vivaio(ArrayList<Proprietario> proprietari2, ArrayList<Fiore> fiori2, ArrayList<Giardino> giardini2) {
        this.giardini = giardini2;
    }
    public ArrayList<Proprietario> metodo1(double p1,double p2){
        ArrayList<Proprietario> ret = new ArrayList<>();
        for(Giardino g: giardini){
            if(costoUnitario(g,p1,p2)) ret.add(g.getProprietario());
        }
        return ret;
    }
    public boolean costoUnitario(Giardino g,double p1, double p2) {
        for(Fiore f: g.getFiori()){
            if(f.getCosto()<p1 || f.getCosto()> p2 ) return false;
        }
        return true;
    }
    public ArrayList<Fiore> metodo2(int d,String c){
        ArrayList<Fiore> ret= new ArrayList<>();
        for(Giardino g: giardini){
            if(g.getDimensione()>=d && g.getProprietario().getCitta()==c) aggiungi(ret,g.getFiori());
        }
        return ret;
    }
    private void aggiungi(ArrayList<Fiore> ret, Fiore[] fiori2) {
        for (Fiore f :fiori2) {
            ret.add(f);
        }
    }
    public ArrayList<Giardino>metodo3(){
        ArrayList<Giardino> ret= new ArrayList<>();
        int min=minVarieta();
        int c=3;
        int max=maxVarieta();
        for (Giardino g : giardini) {
            if(c>0){
                if(g.getFiori().length<min) min=g.getFiori().length;
                if(g.getFiori().length>max){
                    max=g.getFiori().length;
                    ret.add(g);c=c-1;
                }
                if(g.getFiori().length>min && g.getFiori().length<max) ret.add(g);
            }
            
        }
        return ret;
    }


    
    private int maxVarieta() {
        int min=534153;
        for (Giardino g: giardini) {
            if(g.getFiori().length<min) min=g.getFiori().length;
        }
        return min;
    }
    private int minVarieta() {
        int max=-1;
        for (Giardino g: giardini) {
            if(g.getFiori().length>max) max=g.getFiori().length;
        }
        return max;
    }
    public static void main(String[] args) {
        Proprietario c1 = new Proprietario("Rossi", "Roma");
        Proprietario c2 = new Proprietario("Bianchi", "Torino");
        Proprietario c3 = new Proprietario("Verdi", "Cosenza");
        Proprietario c4 = new Proprietario("Neri", "Cosenza");
        Proprietario c5 = new Proprietario("Gialli", "Milano");

        Fiore f1 = new Fiore("Oleandro", 0.50);
        Fiore f2 = new Fiore("Camelia", 1.30);
        Fiore f3 = new Fiore("Iris", 2.90);
        Fiore f4 = new Fiore("Tulipano", 3.52);
        Fiore f5 = new Fiore("Ciclamino", 1.89);
        Fiore f6 = new Fiore("Geranio", 4.36);
        Fiore f7 = new Fiore("Gelsomino",  1.99);
        Fiore f8 = new Fiore("Ortensia", 5.19);

        Giardino g1 = new Giardino(1, c1, "via Condotti", 20, new Fiore[]{f1, f3}, new int[]{2, 5});
        Giardino g2 = new Giardino(2, c2, "via Druento", 35, new Fiore[]{f1, f4}, new int[]{4, 8});
        Giardino g3 = new Giardino(3, c1, "via Cristoforo Colombo", 40, new Fiore[]{f1, f2, f5, f7, f8}, new int[]{4, 3, 3, 1, 2});
        Giardino g4 = new Giardino(4, c2, "via Andrea Sansovino", 30, new Fiore[]{f4, f6, f7, f8}, new int[]{3, 5, 2, 2});
        Giardino g5 = new Giardino(5, c3, "viale Trieste", 35, new Fiore[]{f1, f2, f3}, new int[]{10, 4, 2});
        Giardino g6 = new Giardino(6, c4, "via Francesco Petrarca", 25, new Fiore[]{f1, f2, f3, f4, f6, f8}, new int[]{1, 2, 2, 3, 2, 1});
        Giardino g7 = new Giardino(7, c5, "via Francesco Sforza", 25, new Fiore[]{f4, f8}, new int[]{6, 3});

        ArrayList<Proprietario> proprietari = new ArrayList<>();
        proprietari.add(c1);
        proprietari.add(c2);
        proprietari.add(c3);
        proprietari.add(c4);
        proprietari.add(c5);

        ArrayList<Fiore> fiori = new ArrayList<>();
        fiori.add(f1);
        fiori.add(f2);
        fiori.add(f3);
        fiori.add(f4);
        fiori.add(f5);
        fiori.add(f6);
        fiori.add(f7);
        fiori.add(f8);

        ArrayList<Giardino> giardini = new ArrayList<>();
        giardini.add(g1);
        giardini.add(g2);
        giardini.add(g3);
        giardini.add(g4);
        giardini.add(g5);
        giardini.add(g6);
        giardini.add(g7);

        Vivaio s = new Vivaio(proprietari, fiori, giardini);

        System.out.println(s.metodo1(3.0, 6.0));
        System.out.println(s.metodo2(30, "Cosenza"));
        System.out.println(s.metodo3());
    }


}
