package luglio032020;
import java.util.*;

public class Sistema {
    private ArrayList<Negozio> negozi;
    private ArrayList<Acquisto> acquisti;

    public Sistema(ArrayList<Negozio> negozi, ArrayList<Acquisto> acquisti) {
        this.acquisti = acquisti;
        this.negozi = negozi;
    }

    public ArrayList<String> negoziPreferiti(int data) {
        ArrayList<String> ret = new ArrayList<>();
        int massimo = massimoAcqinData(data);
        for (int i = 0; i < negozi.size(); i++) {
            if (acquistoNegozioData(negozi.get(i), data) == massimo) {
                ret.add(negozi.get(i).getNome());
            }
        }
        return ret;
    }

    private int acquistoNegozioData(Negozio negozio, int data) {
        int c = 0;
        for (int i = 0; i < acquisti.size(); i++) {
            String Nome = negozio.getNome();
            if (acquisti.get(i).getNomeNegozio().equals(Nome) && acquisti.get(i).getData() == data) {
                c++;
            }
        }
        return c;
    }

    private int massimoAcqinData(int data) {
        int max = -1;
        for (int i = 0; i < negozi.size(); i++) {
            int numAcquisto = acquistoNegozioData(negozi.get(i), data);
            if (numAcquisto > max) {
                max = numAcquisto;
            }
        }
        return max;
    }

    // Il metodo restituisce la lista dei codici fiscali dei clienti che, nel
    // periodo compreso tra il giorno dataInizio e il giorno dataFine (estremi
    // inclusi), hanno effettuato acquisti solo in negozi ubicati in una città
    // diversa da quella in cui risiedono.
    public ArrayList<String> clientiEsterniPeriodo(int dataInizio, int dataFine) {
        ArrayList<String> ret = new ArrayList<>();
        for (int i = 0; i < acquisti.size(); i++) {
            Acquisto a = acquisti.get(i);
            String cliente = a.getCFCliente();
            String cittaCliente = a.getCittacliente();
            int dataAcquisto = a.getData();
            String cittaNegozio = cittadAcquisto(a);
            if (dataAcquisto >= dataInizio && dataAcquisto <= dataFine && cittaNegozio != cittaCliente) {
                ret.add(cliente);
            }
        }
        return ret;
    }

    private String cittadAcquisto(Acquisto a) {
        String n = a.getNomeNegozio();
        String citta = "";
        for (int i = 0; i < negozi.size(); i++) {
            Negozio negozio = negozi.get(i);
            if (negozio.getNome().equals(n)) {
                citta = negozio.getCitta();
            }
        }
        return citta;
    }

    // Il metodo restituisce la lista dei codici fiscali dei clienti che hanno
    // effettuato acquisti presso almeno 2 città diverse (un acquisto si intende
    // effettuato presso una città se è effettuato presso un negozio di tale città).
    public ArrayList<String> clientiCittaDiverse() {
        ArrayList<String> ret = new ArrayList<>();
        for (int i = 0; i < acquisti.size(); i++) {
            Acquisto a = acquisti.get(i);
            String citta = cittadAcquisto(a);
            int numAcquisti = AcquistiCittaCliente(a.getCFCliente(), citta);
            if (numAcquisti >= 2)
                ret.add(a.getCFCliente());
        }
        return ret;
    }

    private int AcquistiCittaCliente(String cliente, String citta) {
        int num = 1;
        for (int i = 0; i < acquisti.size(); i++) {
            Acquisto n = acquisti.get(i);
            if (n.getCFCliente().equals(cliente) && cittadAcquisto(n) != citta)
                num++;
        }
        return num;
    }

    public static void main(String[] args) {
        ArrayList<Negozio> negozi = new ArrayList<>();
        Negozio n = new Negozio("Negozio A", "Roma");
        negozi.add(n);
        n = new Negozio("Negozio B", "Roma");
        negozi.add(n);
        n = new Negozio("Negozio C", "Milano");
        negozi.add(n);

        ArrayList<Acquisto> acquisti = new ArrayList<>();
        Acquisto a = new Acquisto("Negozio A", 10, "ABCDEF", "Roma");
        acquisti.add(a);
        a = new Acquisto("Negozio A", 10, "GHIJKL", "Napoli");
        acquisti.add(a);
        a = new Acquisto("Negozio A", 10, "MNOPQR", "Palermo");
        acquisti.add(a);
        a = new Acquisto("Negozio B", 10, "MNOPQR", "Palermo");
        acquisti.add(a);
        a = new Acquisto("Negozio B", 20, "GHIJKL", "Napoli");
        acquisti.add(a);
        a = new Acquisto("Negozio C", 20, "MNOPQR", "Palermo");
        acquisti.add(a);
        a = new Acquisto("Negozio C", 20, "ABCDEF", "Roma");
        acquisti.add(a);

        Sistema s = new Sistema(negozi, acquisti);
        System.out.println(s.negoziPreferiti(10));
        System.out.println(s.clientiEsterniPeriodo(10, 20));
        System.out.println(s.clientiCittaDiverse());

    }
}
