package luglio202021;

import java.util.LinkedList;

public class Contratto {
    private String squadra;
    private String calciatore;
    private int prezzo;
    private LinkedList<Integer> premi;

    public Contratto(String squadra, String calciatore, int prezzo, LinkedList<Integer> premi) {
        this.squadra = squadra;
        this.calciatore = calciatore;
        this.prezzo = prezzo;
        this.premi = new LinkedList<>(premi);
    }
    public String getSquadra() {
        return squadra;
    }
    public void setSquadra(String squadra) {
        this.squadra = squadra;
    }
    public String getCalciatore() {
        return calciatore;
    }
    public void setCalciatore(String calciatore) {
        this.calciatore = calciatore;
    }
    public int getPrezzo() {
        return prezzo;
    }
    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }
    public LinkedList<Integer> getPremi() {
        return new LinkedList<>(premi);
    }
    public void setPremi(LinkedList<Integer> premi) {
        this.premi = premi;
    }
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Contratto other = (Contratto) obj;
        if (calciatore == null) {
            if (other.calciatore != null)
                return false;
        } else if (!calciatore.equals(other.calciatore))
            return false;
        if (premi == null) {
            if (other.premi != null)
                return false;
        } else if (!premi.equals(other.premi))
            return false;
        if (prezzo != other.prezzo)
            return false;
        if (squadra == null) {
            if (other.squadra != null)
                return false;
        } else if (!squadra.equals(other.squadra))
            return false;
        return true;
    }
    
}
