package gennaio302018;

public class Cliente {
    private String codiceFiscale;
    private String nome;
    private String citta;
    public Cliente(String codiceFiscale, String nome, String citta) {
        this.codiceFiscale = codiceFiscale;
        this.nome = nome;
        this.citta = citta;
    }
    public String getCodiceFiscale() {
        return codiceFiscale;
    }
    public String getNome() {
        return nome;
    }
    public String getCitta() {
        return citta;
    }
    public String toString() {
        return "Cliente " + nome;
    }
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente other = (Cliente) obj;
        if (codiceFiscale == null) {
            if (other.codiceFiscale != null)
                return false;
        } else if (!codiceFiscale.equals(other.codiceFiscale))
            return false;
        return true;
    }
    
}
