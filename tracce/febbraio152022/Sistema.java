package febbraio152022;

import java.util.LinkedList;

public class Sistema {
    private LinkedList<Prodotto> prodotti;
    private LinkedList<Fattura> fatture;
    public Sistema(LinkedList<Prodotto> prodotti, LinkedList<Fattura> fatture) {
        this.prodotti = prodotti;
        this.fatture = fatture;
    }
    public int numeroEsemplariMarca(String m){
        LinkedList<String> nomiProdotti= getProdottiMarca(m);
        int c=0;
        for (Fattura f : fatture) {
            LinkedList<String> prodottiFattura= f.getProdotti();
            LinkedList<Integer> quantitaProdotti = f.getQuantita();
            for (int i = 0; i < prodottiFattura.size(); i++) {
                if(nomiProdotti.contains(prodottiFattura.get(i)))
                    c+= quantitaProdotti.get(i);
            }
        }
        return c;

    }
    private LinkedList<String> getProdottiMarca(String m) {
        LinkedList<String> ret= new LinkedList<>();
        for (Prodotto prodotto : prodotti) {
            if(prodotto.getMarca().equals(m))
                ret.add(prodotto.getNome());
        }
        return ret;
    }
    public LinkedList<String> marcheInComune(String nomeCliente){
        LinkedList<String> marcheComuni= getMarcheProdottiCliente(nomeCliente);
        LinkedList<String> ret= new LinkedList<>();
        for (Fattura fattura : fatture) {
            if (!(fattura.getCliente().equals(nomeCliente)) && !(ret.contains(fattura.getCliente())) ) {
                for (String nomeP : fattura.getProdotti()) {
                    Prodotto p= getProdotto(nomeP);
                    if(marcheComuni.contains(p.getMarca())); ret.add(fattura.getCliente());
                    break;
                }
            }
        }
        return ret;
    }
    private Prodotto getProdotto(String nomeP) {
        for (Prodotto prodotto: prodotti) {
            if(prodotto.getNome().equals(nomeP)) return prodotto;
        }
        return null;
    }
    private LinkedList<String> getMarcheProdottiCliente(String nomeCliente) {
        LinkedList<String> ret=new LinkedList<>();
        for (Fattura fattura : fatture) {
            if(fattura.getCliente().equals(nomeCliente));

        }
        return ret;
    }
    public float maxCostoFattura(int d){
        float max=0;
        for (Fattura fattura : fatture) {
            if(fattura.getData()==d){
                float costo=calcoloCosto(fattura);
                if(costo>max) max=costo;
            }
        }
        return max;
    }
    private float calcoloCosto(Fattura fattura) {
        float ret=0;
        for (int i = 0; i < prodotti.size(); i++) {
            Prodotto p=getProdotto(fattura.getProdotti().get(i));
            ret+=p.getPrezzo()*fattura.getQuantita().get(i);
        }
        return ret;
    }


}
