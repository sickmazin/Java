/* import IO.*;
public class oggetti {
    public static void main(String[] args) {
        Persona p= new Persona(IO.readString("Nome: "), IO.readInt("Eta': "));
        Persona q=p; //ALIASING , non è una copia dell'oggetto bensi è dare allo stesso indirizzo dello stack un nome diverso.
        //copia profonda è una copia che restituisce gli stessi valori che stanno nell'oggetto principale
        Persona r= new Persona(p);
        IO.println("Persona p: ");
        IO.println(p);
        IO.println("Persona q: ");
        IO.println(q);
        IO.println("Persona r: ");
        IO.println(r);
        
    }
}
*/