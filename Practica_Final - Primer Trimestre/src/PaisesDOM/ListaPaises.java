package PaisesDOM;

import java.util.LinkedList;

public class ListaPaises {
    private LinkedList<Pais> listapaises;

    public ListaPaises() {
        this.listapaises = new LinkedList<>();
    }
    public void addPais(Pais pais){
        this.listapaises.add(pais);
    }
}
