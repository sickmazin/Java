package settembre092019;

public class Parlamentare{
    private String codiceFiscale;
    private String regione;
    private String partitoPolitico;
    public Parlamentare(String codiceFiscale, String regione, String partitoPolitico) {
        this.codiceFiscale = codiceFiscale;
        this.regione = regione;
        this.partitoPolitico = partitoPolitico;
    }
    public String getCodiceFiscale() {
        return codiceFiscale;
    }
    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }
    public String getRegione() {
        return regione;
    }
    public void setRegione(String regione) {
        this.regione = regione;
    }
    public String getPartitoPolitico() {
        return partitoPolitico;
    }
    public void setPartitoPolitico(String partitoPolitico) {
        this.partitoPolitico = partitoPolitico;
    }
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Parlamentare other = (Parlamentare) obj;
        if (codiceFiscale == null) {
            if (other.codiceFiscale != null)
                return false;
        } else if (!codiceFiscale.equals(other.codiceFiscale))
            return false;
        return true;
    }
    public String toString() {
        return "Parlamentare " + codiceFiscale;
    }

}