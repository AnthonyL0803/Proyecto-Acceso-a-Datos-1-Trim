package AlmacenarPaises;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

import java.io.FileInputStream;

public class LeerXMLXstream {
    public ListaPaises leerXML(XStream xstream, FileInputStream fis, ListaPaises listaPaises){
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

        listaPaises = (ListaPaises) xstream.fromXML(fis);

        return listaPaises;
    }
}
