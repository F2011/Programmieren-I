package exercises.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Gazetteer {
    private static org.w3c.dom.Element geoInfo;

    // Einlesen: formatted_address, long_name des address_component-Elements mit type="locality" + Lage (location, bounds)
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            String url = "https://www.iai.kit.edu/javavl/data/static/karlsruhe.xml";
            Document doc = builder.parse(url);

            geoInfo = doc.getDocumentElement();

            System.out.println("Adresse: " + getFullAddress());
            System.out.println("Long Name: " + getLongName());
            System.out.println("Location: " + getLocation());
            System.out.println("Bounds: " + getBounds());

        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getFullAddress() {
        return geoInfo.getElementsByTagName("formatted_address").item(0).getTextContent();
    }
    private static String getLongName() {
        return ((Element) geoInfo.getElementsByTagName("address_component").item(0))
                .getElementsByTagName("long_name").item(0).getTextContent();
    }

    private static String getLocation() {
        var element =  (Element) geoInfo.getElementsByTagName("location").item(0);
        return String.format("(latitude=%s, longitude=%s)",
                element.getElementsByTagName("lat").item(0).getTextContent(),
                element.getElementsByTagName("lng").item(0).getTextContent());
    }

    private static String getBounds() {
        Element bounds = (Element) geoInfo.getElementsByTagName("bounds").item(0);
        Element southwest = (Element) bounds.getElementsByTagName("southwest").item(0);
        Element northeast = (Element) bounds.getElementsByTagName("northeast").item(0);
        return String.format("(east=%s, north=%s, west=%s, south=%s",
                northeast.getElementsByTagName("lng").item(0).getTextContent(),
                northeast.getElementsByTagName("lat").item(0).getTextContent(),
                southwest.getElementsByTagName("lng").item(0).getTextContent(),
                southwest.getElementsByTagName("lat").item(0).getTextContent());
    }
}
