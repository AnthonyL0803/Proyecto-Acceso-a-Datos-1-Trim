package AlmacenarPaises;
import java.io.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

/*
Introduce en el Proyect structure > Module > jar = kxml y el xstream
 */
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        XStream xstream = new XStream();
        FileInputStream fis = new FileInputStream("Paises.xml");

        XStream.setupDefaultSecurity(xstream); // Configuración básica
        xstream.addPermission(NoTypePermission.NONE); // No permitir nada por defecto
        xstream.addPermission(NullPermission.NULL); // Permitir nulos
        xstream.addPermission(PrimitiveTypePermission.PRIMITIVES); // Permitir tipos primitivos
        xstream.allowTypesByRegExp(new String[] { ".*" });


        xstream.alias("Pais", Pais.class);
        xstream.alias("ListaPaises", ListaPaises.class);

        xstream.useAttributeFor(Pais.class, "Nombre");
        xstream.useAttributeFor(Pais.class, "Presidente");
        xstream.useAttributeFor(Pais.class, "PIB");
        xstream.useAttributeFor(Pais.class, "CoeficienteDeGini");
        xstream.addImplicitCollection(ListaPaises.class, "paises");

        xstream.alias("Paises", ListaPaises.class);
        xstream.alias("Pais", Pais.class);

        ListaPaises listaPaises = (ListaPaises) xstream.fromXML(fis);

        for (Pais pais : listaPaises.getPais()) {
            System.out.println(pais);
        }

        //En este paso creamos el fichero .dat
        PaisesBinario paisesBinario = new PaisesBinario();
        paisesBinario.crearFicheroDat(listaPaises);

    }
}
