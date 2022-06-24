package settembre092019;

public class Votazione {
    private int codice;
    private String codiceFiscale;
    private int disegnoDiLegge;
    private boolean voto;
    public Votazione(int codice, String codiceFiscale, int disegnoDiLegge, boolean voto) {
        this.codice = codice;
        this.codiceFiscale = codiceFiscale;
        this.disegnoDiLegge = disegnoDiLegge;
        this.voto = voto;
    }
    public int getCodice() {
        return codice;
    }
    public void setCodice(int codice) {
        this.codice = codice;
    }
    public String getCodiceFiscale() {
        return codiceFiscale;
    }
    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }
    public int getDisegnoDiLegge() {
        return disegnoDiLegge;
    }
    public void setDisegnoDiLegge(int disegnoDiLegge) {
        this.disegnoDiLegge = disegnoDiLegge;
    }
    public boolean isVoto() {
        return voto;
    }
    public void setVoto(boolean voto) {
        this.voto = voto;
    }
    public String toString() {
        return "Votazione [codice=" + codice + ", codiceFiscale=" + codiceFiscale + ", disegnoDiLegge=" + disegnoDiLegge
                + ", voto=" + voto + "]";
    }
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Votazione other = (Votazione) obj;
        if (codice != other.codice)
            return false;
        if (codiceFiscale == null) {
            if (other.codiceFiscale != null)
                return false;
        } else if (!codiceFiscale.equals(other.codiceFiscale))
            return false;
        return true;
    }
    
}
