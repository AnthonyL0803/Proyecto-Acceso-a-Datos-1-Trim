package AlmacenarPaises;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListaPaises implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Pais> paises;

    public ListaPaises() {
        this.paises = new ArrayList<>();
    }

    public List<Pais> getPais() {
        return paises;
    }

    public void setPaises(List<Pais> paises) {
        this.paises = paises;
    }



}
