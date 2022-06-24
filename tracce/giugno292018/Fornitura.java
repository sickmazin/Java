package giugno292018;

import java.util.Objects;

public class Fornitura {
    private int codice, codAcquedotto;
    private double portata;
    private String citta;

    public Fornitura(int codice, double portata, int codAcquedotto, String citta) {
        this.codice = codice;
        this.codAcquedotto = codAcquedotto;
        this.portata = portata;
        this.citta = citta;
    }

    public int getCodice() {
        return codice;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public int getCodAcquedotto() {
        return codAcquedotto;
    }

    public void setCodAcquedotto(int codAcquedotto) {
        this.codAcquedotto = codAcquedotto;
    }

    public double getPortata() {
        return portata;
    }

    public void setPortata(double portata) {
        this.portata = portata;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fornitura fornitura = (Fornitura) o;
        return codice == fornitura.codice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codice);
    }

    @Override
    public String toString() {
        return "Fornitura{" +
                "codice=" + codice +
                ", codAcquedotto=" + codAcquedotto +
                ", portata=" + portata +
                ", citta='" + citta + '\'' +
                '}';
    }
}
