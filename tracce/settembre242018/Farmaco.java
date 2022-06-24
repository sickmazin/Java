package settembre242018;
import java.util.*;

public class Farmaco {
    private int codice;
    private String nome;
    private int codProd;
    private double prezzo;
    private ArrayList<String> principiAttivi;
    public Farmaco(int codice, String nome, int codProd, double prezzo, ArrayList<String> principiAttivi) {
        this.codice = codice;
        this.nome = nome;
        this.codProd = codProd;
        this.prezzo = prezzo;
        this.principiAttivi = principiAttivi;
    }
    public int getCodice() {
        return codice;
    }
    public String getNome() {
        return nome;
    }
    public int getCodProd() {
        return codProd;
    }
    public double getPrezzo() {
        return prezzo;
    }
    public ArrayList<String> getPrincipiAttivi() {
        return principiAttivi;
    }
    public String toString() {
        return "Farmaco " + nome;
    }
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Farmaco other = (Farmaco) obj;
        if (codice != other.codice)
            return false;
        return true;
    }

}
