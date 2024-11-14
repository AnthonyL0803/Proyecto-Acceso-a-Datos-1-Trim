package PaisesDOM;

public class Pais {
    private String nombre;
    private String presidente;
    private long PIB;
    private double CoeficienteDeGini;

    public Pais(String nombre, String presidente, long PIB, double coeficienteDeGini) {
        this.nombre = nombre;
        this.presidente = presidente;
        this.PIB = PIB;
        CoeficienteDeGini = coeficienteDeGini;
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
    public long getPIB() {
        return PIB;
    }
    public void setPIB(long PIB) {
        this.PIB = PIB;
    }
    public double getCoeficienteDeGini() {
        return CoeficienteDeGini;
    }
    public void setCoeficienteDeGini(double coeficienteDeGini) {
        CoeficienteDeGini = coeficienteDeGini;
    }

    @Override
    public String toString() {
        return "Pais: " +
                "Nombre:'" + nombre + '\'' +
                "Presidente: " + presidente + '\'' +
                "PIB: " + PIB +
                "Coeficiente de Gini:" + CoeficienteDeGini;
    }
}
