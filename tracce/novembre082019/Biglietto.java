package novembre082019;

public class Biglietto {
    private int numSerie;
    private String codice;
    private int Posto;
    private String settore;
    private String codiceFiscale;

    public Biglietto(int numSerie, String codice, int posto, String settore, String cf){
        this.numSerie=numSerie;
        this.codice=codice;
        this.Posto=posto;
        this.settore=settore;
        this.codiceFiscale=cf;
    }
    public int getNumSerie(){
        return numSerie;
    }
    public void setNumSerie(int numSerie){
        this.numSerie=numSerie;
    }
    public String getCodice() {
        return codice;
    }
    public void setCodice(String codice) {
        this.codice = codice;
    }
    public int getPosto() {
        return Posto;
    }
    public void setPosto(int posto) {
        Posto = posto;
    }
    public String getSettore() {
        return settore;
    }
    public void setSettore(String settore) {
        this.settore = settore;
    }
    public String getCodiceFiscale() {
        return codiceFiscale;
    }
    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }
    public String toString() {
        return "Biglietto [Posto=" + Posto + ", codice=" + codice + ", codiceFiscale=" + codiceFiscale +
        ", numSerie=" + numSerie + ", settore=" + settore + "]";
    }
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Biglietto other = (Biglietto) obj;
        if (numSerie != other.numSerie)
            return false;
        return true;
    }

}
