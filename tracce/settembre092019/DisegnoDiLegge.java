package settembre092019;

import java.util.ArrayList;

public class DisegnoDiLegge {
    private int codice;
    private String nome;
    private ArrayList<String> listaParlamentari;
    private int data;
    private boolean Votazione;
    public DisegnoDiLegge(int codice, String nome, ArrayList<String> listaParlamentari, int data, boolean votazione) {
        this.codice = codice;
        this.nome = nome;
        this.listaParlamentari = listaParlamentari;
        this.data = data;
        Votazione = votazione;
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
    public ArrayList<String> getListaParlamentari() {
        return listaParlamentari;
    }
    public void setListaParlamentari(ArrayList<String> listaParlamentari) {
        this.listaParlamentari = listaParlamentari;
    }
    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }
    public boolean isVotazione() {
        return this.Votazione;
    }
    public void setVotazione(boolean votazione) {
        Votazione = votazione;
    }
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DisegnoDiLegge other = (DisegnoDiLegge) obj;
        if (codice != other.codice)
            return false;
        return true;
    }
    public String toString() {
        return "DisegnoDiLegge: Votazione=" + Votazione + ", codice=" + codice + ", data=" + data
                + ", listaParlamentari=" + listaParlamentari + ", nome=" + nome + "";
    }
    
    
}
