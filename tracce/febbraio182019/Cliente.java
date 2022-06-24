package febbraio182019;

public class Cliente{
    private String nome;
    private String citta;
    public Cliente(String nome, String citta) {
        this.nome = nome;
        this.citta = citta;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCitta() {
        return citta;
    }
    public void setCitta(String citta) {
        this.citta = citta;
    }
    public String toString() {
        return "Cliente [citta=" + citta + ", nome=" + nome + "]";
    }
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente other = (Cliente) obj;
        if (citta == null) {
            if (other.citta != null)
                return false;
        } else if (!citta.equals(other.citta))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }
    
}