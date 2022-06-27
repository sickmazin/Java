package listeconcatenate;
class NodoInt {
    private int info;
    private NodoInt next;
    public NodoInt(int info, NodoInt next){
        this.info=info;
        this.next=next;
    }
    public void setInfo(int info) {
        this.info = info;
    }
    public void setNext(NodoInt next) {
        this.next = next;
    }
    public int getInfo() {
        return info;
    }
    public NodoInt getNext() {
        return next;
    }
    public String toString() {
        return ""+info;
    }
    /*
    private boolean hainfo(int info) {
        return this.info==info;
    }
    */ 
}
