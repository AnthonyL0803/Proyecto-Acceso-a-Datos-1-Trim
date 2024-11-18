package AlmacenarPaises;
import java.io.*;
import java.sql.SQLException;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

/*
Introduce en el Proyect structure > Module > jar = kxml y el xstream
 */
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        XStream xstream = new XStream();
        FileInputStream fis = new FileInputStream("Paises.xml");
        ListaPaises listaPaises = new ListaPaises();
        DAOPaises daoPaises = new DAOPaises();

        //En este paso leemos el archivo xml y almacenamos los objetos en la lista
        LeerXMLXstream leerXMLXstream = new LeerXMLXstream();
        listaPaises = leerXMLXstream.leerXML(xstream, fis, listaPaises);
        //Comprobamos que los objetos se han almacenado correctamente
        for (Pais pais : listaPaises.getPais()) {
            System.out.println(pais);
        }
        //En este paso creamos el fichero .dat
        PaisesBinario paisesBinario = new PaisesBinario();
        paisesBinario.crearFicheroDat(listaPaises);

        //En este paso creamos la tabla insertamos los paises y posteriormente mostramos todos los datos
        daoPaises.crearTablaPaises();
        for (Pais pais : listaPaises.getPais()){
            daoPaises.insertarPais(pais);
        }
        System.out.println("\n");
        daoPaises.mostrarTabla();
        System.out.println("\n");
        daoPaises.incrementarPIB();

    }
}
