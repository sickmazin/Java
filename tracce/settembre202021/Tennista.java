package settembre202021;

public class Tennista {
    private String nome;
    private int  classifica;
    public String getNome() {
        return nome;
    }
    public int getClassifica() {
        return classifica;
    }
    public Tennista(String nome, int classifica) {
        this.nome = nome;
        this.classifica = classifica;
    }
    public String toString() {
        return "Tennista " + nome ;
    }
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Tennista other = (Tennista) obj;
        if (classifica != other.classifica)
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }
    
}
