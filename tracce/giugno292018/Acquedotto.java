package giugno292018;

import java.util.Objects;

public class Acquedotto {
    private int codice;
    private String nome;

    public Acquedotto(int codice, String nome) {
        this.codice = codice;
        this.nome = nome;
    }

    public int getCodice() {
        return codice;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Acquedotto that = (Acquedotto) o;
        return codice == that.codice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codice);
    }

    @Override
    public String toString() {
        return "Acquedotto{" +
                "codice=" + codice +
                ", nome='" + nome + '\'' +
                '}';
    }
}
