package listeconcatenate;

public class EccezioneListaVuota extends RuntimeException {
    public String toString() {
        return "La lista e' vuota";
    }
}
