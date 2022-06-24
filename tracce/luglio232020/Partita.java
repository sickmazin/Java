package luglio232020;

public class Partita {
    private String nomeSquadraCasa;
    private String nomeSquadraOspite;
    private int golCasa;
    private int golOspite;
    private String nomeArbitro;
    private String cittaArbitro;

    public Partita(String nomeSquadraCasa, String nomeSquadraOspite, int golCasa, int golOspite, String nomeArbitro,
            String cittaArbitro) {
        this.nomeSquadraCasa = nomeSquadraCasa;
        this.nomeSquadraOspite = nomeSquadraOspite;
        this.golCasa = golCasa;
        this.golOspite = golOspite;
        this.nomeArbitro = nomeArbitro;
        this.cittaArbitro = cittaArbitro;
    }

    public String getNomeSquadraCasa(){
        return nomeSquadraCasa;
    }
    public String getNomeSquadraOspite(){
        return nomeSquadraOspite;
    }

    public int getGolCasa() {
        return golCasa;
    }

    public void setGolCasa(int golCasa) {
        this.golCasa = golCasa;
    }

    public int getGolOspite() {
        return golOspite;
    }

    public void setGolOspite(int golOspite) {
        this.golOspite = golOspite;
    }

    public String getNomeArbitro() {
        return nomeArbitro;
    }

    public void setNomeArbitro(String nomeArbitro) {
        this.nomeArbitro = nomeArbitro;
    }

    public String getCittaArbitro() {
        return cittaArbitro;
    }

    public void setCittaArbitro(String cittaArbitro) {
        this.cittaArbitro = cittaArbitro;
    }
    public boolean equals(Object o){
        if(o==null) return false;
        if(o==this) return true;
        if(o.getClass() != this.getClass()) return false;
        Partita a= (Partita) o;
        return a.nomeSquadraCasa== nomeSquadraCasa && a.nomeSquadraOspite== nomeSquadraOspite && a.golCasa== golCasa && a.golOspite== golOspite;
    }
    public String toString() {
        return "Partita [cittaArbitro=" + cittaArbitro + ", golCasa=" + golCasa + ", golOspite=" + golOspite
                + ", nomeArbitro=" + nomeArbitro + ", nomeSquadraCasa=" + nomeSquadraCasa + ", nomeSquadraOspite="
                + nomeSquadraOspite + "]";
    }
    
}
