package AlmacenarPaises;

import java.sql.*;

public class DAOPaises {
    private String url;
    private String proyectPath;

    public DAOPaises() {
        this.proyectPath = System.getProperty("user.dir");
        this.url = ("jdbc:h2:file:" + this.proyectPath + "\\Practica_Final - Primer Trimestre\\src\\Paises.db");
    }

    public void crearTablaPaises() throws SQLException {
        try (Connection conexion = DriverManager.getConnection(this.url);
             PreparedStatement sentencia = conexion.prepareStatement(
                     "CREATE TABLE IF NOT EXISTS TABLAPAISES (NOMBRE VARCHAR(50) PRIMARY KEY, PRESIDENTE VARCHAR(50), PIB BIGINT, COEFICIENTEDEGINI DOUBLE)"
             )) {
            sentencia.execute();
        }
    }

    public boolean existePais(Pais a) throws SQLException {
        Connection conexion = DriverManager.getConnection(this.url);
        PreparedStatement sentencia = conexion.prepareStatement("SELECT * FROM TABLAPAISES WHERE NOMBRE = ?");
        sentencia.setString(1, a.getNombre());                   // NOMBRE
        ResultSet result = sentencia.executeQuery();
        return result.next();
    }

    public void insertarPais(Pais a) throws SQLException {
        Connection conexion = DriverManager.getConnection(this.url);
        if (!existePais(a)) {
            PreparedStatement sentencia = conexion.prepareStatement("INSERT INTO TABLAPAISES VALUES(?, ?, ?, ?)");
            sentencia.setString(1, a.getNombre());                // NOMBRE
            sentencia.setString(2, a.getPresidente());            //PRESIDENTE
            sentencia.setLong(3, a.getPib());                     // PIB
            sentencia.setDouble(4, a.getCoeficienteDeGini());     // COEFICIENTEDEGINI
            sentencia.execute();
            conexion.close();
        }
    }

    public void mostrarTabla() throws SQLException {
        Connection conexion = DriverManager.getConnection(this.url);
        PreparedStatement sentencia = conexion.prepareStatement("SELECT * FROM TABLAPAISES");
        ResultSet resultado = sentencia.executeQuery();
        while (resultado.next()) {
            System.out.println("\nSiguiente país: ");
            System.out.print(resultado.getString("NOMBRE") + " ");
            System.out.print(resultado.getString("PRESIDENTE") + " ");
            System.out.print(resultado.getLong("PIB") + " ");
            System.out.print(resultado.getDouble("COEFICIENTEDEGINI") + " ");
        }
    }

    public void incrementarPIB() throws SQLException {
        Connection conexion = DriverManager.getConnection(this.url);
        PreparedStatement sentencia = conexion.prepareStatement("UPDATE TABLAPAISES SET PIB = PIB + 10000000");
        sentencia.execute();
        conexion.close();
    }

    public void reduccionCoeficienteDeGini() throws SQLException {
        Connection conexion = DriverManager.getConnection(this.url);
        PreparedStatement sentencia = conexion.prepareStatement("UPDATE TABLAPAISES " +
                "SET COEFICIENTEDEGINI = COEFICIENTEDEGINI * 2 / 3 " +
                "WHERE NOMBRE = 'El Salvador' OR NOMBRE = 'Honduras' OR NOMBRE = 'México'");
        sentencia.execute();
        conexion.close();
    }
}
