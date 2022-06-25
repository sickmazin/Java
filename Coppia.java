public class Coppia<T> { 
    private T element1; //elemento di tipo T, tipo generico cioè non specificato. Lo andremo ad indicare in seguito quando vado a definire la classe
    private T element2;
    public  Coppia (T element1, T element2) {
        this.element1=element1;
        this.element2=element2;
    }
    public T getElement1() {
        return element1;
    }
    public T getElement2() {
        return element2;
    }
    public void setElement1(T element1) {
        this.element1 = element1;
    }
    public void setElement2(T element2) {
        this.element2 = element2;
    }
    public String toString() {
        return "Coppia [elemento1: "+element1+"] e [elemento2: "+element2+"] ";
    }
}
