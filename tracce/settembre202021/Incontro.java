package settembre202021;

public class Incontro {
    private int numEdizione;
    private String vincitore;
    private String vinto;
    private String fase;
    public Incontro(int numEdizione, String vincitore, String vinto, String fase) {
        this.numEdizione = numEdizione;
        this.vincitore = vincitore;
        this.vinto = vinto;
        this.fase = fase;
    }
    public int getNumEdizione() {
        return numEdizione;
    }
    public String getVincitore() {
        return vincitore;
    }
    public String getVinto() {
        return vinto;
    }
    public String getFase() {
        return fase;
    }
    public String toString() {
        return "Incontro "+ numEdizione ;
    }
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Incontro other = (Incontro) obj;
        if (fase == null) {
            if (other.fase != null)
                return false;
        } else if (!fase.equals(other.fase))
            return false;
        if (numEdizione != other.numEdizione)
            return false;
        if (vincitore == null) {
            if (other.vincitore != null)
                return false;
        } else if (!vincitore.equals(other.vincitore))
            return false;
        if (vinto == null) {
            if (other.vinto != null)
                return false;
        } else if (!vinto.equals(other.vinto))
            return false;
        return true;
    }
    
    
}
