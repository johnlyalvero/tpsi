import java.io.IOException;
import java.util.*;

/**
 * Classe Main per testare la gestione della persistenza dell'entità Persona.
 */
public class Main {
    public static void main(String[] args) {
        List<Persona> persone = Arrays.asList(
            new Persona(1, "Mario", "Rossi", 25),
            new Persona(2, "Luca", "Bianchi", 30),
            new Persona(3, "Giulia", "Verdi", 28)
        );

        try {
            PersonaDAO.salvaPersone(persone);
            System.out.println("Persone salvate in CSV.");
            
            PersonaJSONDAO.salvaPersone(persone);
            System.out.println("Persone salvate in JSON.");
            
            PersonaXMLDAO.salvaPersone(persone);
            System.out.println("Persone salvate in XML.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
