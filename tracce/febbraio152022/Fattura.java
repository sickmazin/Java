package febbraio152022;

import java.util.LinkedList;

public class Fattura {
    private int ID;
    private String Cliente;
    private int data;
    LinkedList<String> prodotti;
    LinkedList<Integer> quantita;
    public String getCliente() {
        return Cliente;
    }
    public int getData() {
        return data;
    }
    public int getID() {
        return ID;
    }
    public LinkedList<String> getProdotti() {
        return prodotti;
    }
    public LinkedList<Integer> getQuantita() {
        return quantita;
    }

    public String toString() {
        return "Fattura [Cliente=" + Cliente + ", ID=" + ID + ", data=" + data + ", prodotti=" + prodotti
                + ", quantita=" + quantita + "]";
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj== this) return true;
        if(!(obj instanceof Fattura)) return false;
        Fattura a= (Fattura) obj;
        return a.getID()==this.getID();
    }


}
