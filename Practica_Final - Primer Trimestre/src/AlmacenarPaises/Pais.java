package AlmacenarPaises;

import java.io.Serializable;

public class Pais implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nombre;
    private String presidente;
    private long pib;
    private double coeficienteDeGini;

    public Pais(String nombre, String presidente, long pib, double coeficienteDeGini) {
        this.nombre = nombre;
        this.presidente = presidente;
        this.pib = pib;
        this.coeficienteDeGini = coeficienteDeGini;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPresidente() {
        return presidente;
    }
    public void setPresidente(String presidente) {
        this.presidente = presidente;
    }
    public long getPib() {
        return pib;
    }
    public void setPib(long pib) {
        this.pib = pib;
    }
    public double getCoeficienteDeGini() {
        return coeficienteDeGini;
    }
    public void setCoeficienteDeGini(double coeficienteDeGini) {
        this.coeficienteDeGini = coeficienteDeGini;
    }

    @Override
    public String toString() {
        return "Pais: " +
                "Nombre:'" + nombre + '\'' +
                "Presidente: " + presidente + '\'' +
                "PIB: " + pib +
                "Coeficiente de Gini:" + coeficienteDeGini;
    }
}
