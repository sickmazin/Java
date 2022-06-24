package novembre082019;

public class Partita{
    private String codice;
    private String nomeCasa;
    private String nomeOspiti;
    private int data;

    public Partita(String codice, String casa, String ospiti, int data){
        this.codice= codice;
        this.nomeCasa= casa;
        this.nomeOspiti= ospiti;
        this.data=data;
    }
    public String getCodice(){
        return this.codice;
    }
    public void setCodice(String codice){
        this.codice= codice;
    }
    public String getNomeCasa() {
        return nomeCasa;
    }
    public void setNomeCasa(String nomeCasa) {
        this.nomeCasa = nomeCasa;
    }
    public String getNomeOspiti() {
        return nomeOspiti;
    }
    public void setNomeOspiti(String nomeOspiti) {
        this.nomeOspiti = nomeOspiti;
    }
    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }
    public String toString() {
        return "Partita [codice=" + codice + ", data=" + data + ", nomeCasa=" + nomeCasa + ", nomeOspiti=" + nomeOspiti+ "]";
    }
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Partita other = (Partita) obj;
        if (codice == null) {
            if (other.codice != null)
                return false;
        } else if (!codice.equals(other.codice))
            return false;
        return true;
    }
    
}