import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.*;

import java.io.*;
import java.util.*;

/**
 * Classe DAO per la gestione della persistenza dell'entità Persona nel formato XML.
 */
public class PersonaXMLDAO {
    private static final String FILE_NAME = "persone.xml";

    public static void salvaPersone(List<Persona> persone) throws IOException {
        Document document = new Document();
        Element root = new Element("persone");
        document.setRootElement(root);

        for (Persona p : persone) {
            Element personaElement = new Element("persona");
            personaElement.addContent(new Element("id").setText(String.valueOf(p.getId())));
            personaElement.addContent(new Element("nome").setText(p.getNome()));
            personaElement.addContent(new Element("cognome").setText(p.getCognome()));
            personaElement.addContent(new Element("eta").setText(String.valueOf(p.getEta())));
            root.addContent(personaElement);
        }

        XMLOutputter xmlOutput = new XMLOutputter(Format.getPrettyFormat());
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            xmlOutput.output(document, writer);
        }
    }

    public static List<Persona> caricaPersone() throws Exception {
        List<Persona> persone = new ArrayList<>();
        File inputFile = new File(FILE_NAME);
        if (!inputFile.exists()) return persone;

        SAXBuilder saxBuilder = new SAXBuilder();
        Document document = saxBuilder.build(inputFile);
        Element root = document.getRootElement();

        for (Element personaElement : root.getChildren("persona")) {
            int id = Integer.parseInt(personaElement.getChildText("id"));
            String nome = personaElement.getChildText("nome");
            String cognome = personaElement.getChildText("cognome");
            int eta = Integer.parseInt(personaElement.getChildText("eta"));
            persone.add(new Persona(id, nome, cognome, eta));
        }
        return persone;
    }
}
