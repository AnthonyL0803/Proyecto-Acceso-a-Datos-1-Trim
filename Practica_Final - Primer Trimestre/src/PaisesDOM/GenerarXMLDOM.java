package PaisesDOM;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.EOFException;
import java.io.File;

public class GenerarXMLDOM {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException {
        String[] nombre = {"Belice", "El Salvador", "Guatemala", "Honduras", "Nicaragua", "México", "Panamá", "Costa Rica"};
        String[] presidente = {"Froyla Tzalam", "Nayib Bukele", "Alejandro Giammattei", "Xiomara Castro", "Daniel Ortega", "Andrés Manuel López Obrador", "Laurentino Cortizo", "Rodrigo Chaves"};
        String[] PIB = {"1987", "74818", "185473", "85625", "47770", "2890685", "128500", "129950"};
        String[] CoeficienteDeGini = {"53.3", "38.8", "48.3", "48.2", "46.2", "45.4", "50.9", "47.2"};
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.newDocument();

        Element rootElement = doc.createElement("Paises");
        doc.appendChild(rootElement);

        for (int i = 0; i<nombre.length;i++){
            Element pais = doc.createElement("Pais");

            Element nombreNodo = doc.createElement("Nombre");
            nombreNodo.appendChild(doc.createTextNode(nombre[i]));
            pais.appendChild(nombreNodo);

            Element presidenteNodo = doc.createElement("Presidente");
            presidenteNodo.appendChild(doc.createTextNode(presidente[i]));
            pais.appendChild(presidenteNodo);

            Element PIBNodo = doc.createElement("PIB");
            PIBNodo.appendChild(doc.createTextNode(PIB[i]));
            pais.appendChild(PIBNodo);

            Element CoeficienteDeGiniNodo = doc.createElement("CoeficienteDeGini");
            CoeficienteDeGiniNodo.appendChild(doc.createTextNode(CoeficienteDeGini[i]));
            pais.appendChild(CoeficienteDeGiniNodo);

            rootElement.appendChild(pais);
        }
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("Paises.xml"));
        transformer.transform(source, result);

        System.out.println("Archivo 'Paises.xml' generado exitosamente.");
    }
}
