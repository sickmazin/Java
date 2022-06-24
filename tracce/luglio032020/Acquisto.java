package luglio032020;
public class Acquisto {
    private String NomeNegozio;
    private int Data;
    private String CFCliente;
    private String Cittacliente;
    public Acquisto(String nomenegozio, int data, String CFCliente, String citta){
        this.NomeNegozio=nomenegozio;
        this.Data=data;
        this.CFCliente=CFCliente;
        this.Cittacliente=citta;
    }
    public String getNomeNegozio(){
        return NomeNegozio;
    }
    public int getData(){
        return Data;
    }
    public String getCFCliente() {
        return CFCliente;
    }
    public String getCittacliente(){
        return Cittacliente;
    }
    public String toString() {
        return "Nome negozio: "+NomeNegozio+" effettuato il: "+Data+" dal cliente: "+CFCliente+" da: "+Cittacliente;  
    }
    public boolean equals(Object o) {
        if (o == null) return false;
        if(o==this) return true;
        if(o.getClass()!=this.getClass()) return false;
        Acquisto a=(Acquisto)o;
        return this.NomeNegozio.equals(a.NomeNegozio) && this.Data==a.Data && this.CFCliente.equals(a.CFCliente) &&this.Cittacliente.equals(a.Cittacliente);
    }
}
