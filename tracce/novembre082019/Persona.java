package novembre082019;

public class Persona {
    private String codiceFiscale;
    private int data;
    private String luogoNascita;

    public Persona(String cf, int data, String luogoNascita){
        this.codiceFiscale= cf;
        this.data= data;
        this.luogoNascita= luogoNascita;
    }
    public String getCodiceFiscale(){
        return codiceFiscale;
    }
    public void setCodiceFiscale(String cf){
        this.codiceFiscale=cf;
    }
    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }
    public String getLuogoNascita() {
        return luogoNascita;
    }
    public void setLuogoNascita(String luogoNascita) {
        this.luogoNascita = luogoNascita;
    }
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Persona other = (Persona) obj;
        if (codiceFiscale == null) {
            if (other.codiceFiscale != null)
                return false;
        } else if (!codiceFiscale.equals(other.codiceFiscale))
            return false;
        return true;
    }
    
    public String toString() {
        return "Persona [codiceFiscale=" + codiceFiscale + ", data=" + data + ", luogoNascita=" + luogoNascita + "]";
    }
    
}
