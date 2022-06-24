package settembre162020;

public class Messaggio {
    private String NomeMittente;
    private String NomeDestinatario;
    private int data;
    private boolean letto;

    public Messaggio(String nomeMittente, String nomeDestinatario, int data){
        this.NomeMittente= nomeMittente;
        this.NomeDestinatario= nomeDestinatario;
        this.data=data;
    }

    public String getNomeMittente() {
        return NomeMittente;
    }

    public void setNomeMittente(String nomeMittente) {
        NomeMittente = nomeMittente;
    }

    public String getNomeDestinatario() {
        return NomeDestinatario;
    }

    public void setNomeDestinatario(String nomeDestinatario) {
        NomeDestinatario = nomeDestinatario;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
    public boolean letto(){
        return letto;
    }
    public String toString() {
        return "Messaggio [NomeDestinatario=" + NomeDestinatario + ", NomeMittente=" + NomeMittente + ", data=" + data + ", letto=" + letto + "]";
    }
    public boolean equals(Object o){
        if(o==null) return false;
        if(o==this) return true;
        if(o.getClass()!= this.getClass()) return false;
        Messaggio a= (Messaggio) o;
        return a.NomeMittente.equals(this.NomeMittente) && a.NomeDestinatario.equals(this.NomeDestinatario) && a.data==this.data && a.letto==this.letto; 
    }
}
