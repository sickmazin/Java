package febbraio012022;

public class Tecnico {
    private String Nome;
    private int CostoOrario;

    
    public Tecnico(String nome, int costoOrario) {
        this.Nome = nome;
        this.CostoOrario = costoOrario;
    }
    public String getNome() {
        return Nome;
    }
    public void setNome(String nome) {
        Nome = nome;
    }
    public int getCostoOrario() {
        return CostoOrario;
    }
    public void setCostoOrario(int costoOrario) {
        CostoOrario = costoOrario;
    }
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Tecnico other = (Tecnico) obj;
        return Nome.equals(other.Nome);
    }
    public String toString() {
        return "Tecnico [Nome=" + Nome +"CostoOrario=" + CostoOrario + " ]";
    }
    
    
}
