package gennaio302018;
import java.util.*;
public class Acquisto {
    private Cliente cliente;
    private int data;
    ArrayList<Articolo> acquisti;
    public Acquisto(Cliente cliente, int data, ArrayList<Articolo> acquisti) {
        this.cliente = cliente;
        this.data = data;
        this.acquisti = acquisti;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public int getData() {
        return data;
    }
    public ArrayList<Articolo> getAcquisti() {
        return acquisti;
    }
    public String toString() {
        return "Acquisto [acquisti=" + acquisti + ", cliente=" + cliente + ", data=" + data + "]";
    }
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Acquisto other = (Acquisto) obj;
        if (acquisti == null) {
            if (other.acquisti != null)
                return false;
        } else if (!acquisti.equals(other.acquisti))
            return false;
        if (cliente == null) {
            if (other.cliente != null)
                return false;
        } else if (!cliente.equals(other.cliente))
            return false;
        if (data != other.data)
            return false;
        return true;
    }
    
}
