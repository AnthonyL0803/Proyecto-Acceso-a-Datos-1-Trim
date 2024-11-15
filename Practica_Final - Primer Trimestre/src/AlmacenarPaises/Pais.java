package AlmacenarPaises;

import java.io.Serializable;

public class Pais implements Serializable{
    private static final long serialVersionUID = 1L;
    private String Nombre;
    private String Presidente;
    private long PIB;
    private double CoeficienteDeGini;

    public Pais(String nombre, String presidente, long PIB, double coeficienteDeGini) {
        this.Nombre = nombre;
        this.Presidente = presidente;
        this.PIB = PIB;
        this.CoeficienteDeGini = coeficienteDeGini;
    }

    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }
    public String getPresidente() {
        return Presidente;
    }
    public void setPresidente(String presidente) {
        this.Presidente = presidente;
    }
    public long getPIB() {
        return PIB;
    }
    public void setPIB(long PIB) {
        this.PIB = PIB;
    }
    public double getCoeficienteDeGini() {
        return this.CoeficienteDeGini;
    }
    public void setCoeficienteDeGini(double coeficienteDeGini) {
        this.CoeficienteDeGini = coeficienteDeGini;
    }

    @Override
    public String toString() {
        return "Pais: " +
                "Nombre:'" + Nombre + '\'' +
                "Presidente: " + Presidente + '\'' +
                "PIB: " + PIB +
                "Coeficiente de Gini:" + CoeficienteDeGini;
    }
}
