package giugno292018;

import java.util.Objects;

public class Citta {
    private String nome;
    private int popolazione;

    public Citta(String nome, int popolazione) {
        this.nome = nome;
        this.popolazione = popolazione;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPopolazione() {
        return popolazione;
    }

    public void setPopolazione(int popolazione) {
        this.popolazione = popolazione;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Citta citta = (Citta) o;
        return nome.equals(citta.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public String toString() {
        return "Citta{" +
                "nome='" + nome + '\'' +
                ", popolazione=" + popolazione +
                '}';
    }
}
