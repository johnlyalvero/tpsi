import java.util.List;

public class TestMainDAO {
    public static void main(String[] args) {
        try {
            // Test PersonaCSVDAO
            System.out.println("=== Test PersonaCSVDAO ===");
            IPersonaDAO csvDao = new PersonaCSVDAO("persone.csv");
            testDao(csvDao);

            // Test PersonaXMLDAO
            System.out.println("\n=== Test PersonaXMLDAO ===");
            IPersonaDAO xmlDao = new PersonaXMLDAO("persone.xml");
            testDao(xmlDao);

            // Test PersonaJSONDAO
            System.out.println("\n=== Test PersonaJSONDAO ===");
            IPersonaDAO jsonDao = new PersonaJSONDAO("persone.json");
            testDao(jsonDao);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Metodo di test generico per eseguire operazioni CRUD su un DAO
    public static void testDao(IPersonaDAO dao) throws Exception {
        // Creare alcune persone di esempio
        Persona persona1 = new Persona("Mario", "Rossi", "RSSMRA80A01H501Z", 30);
        Persona persona2 = new Persona("Luigi", "Bianchi", "BNCLGU80A01H501Y", 25);

        // Salva persone nel DAO
        dao.save(persona1);
        dao.save(persona2);

        // Visualizza tutte le persone
        System.out.println("Tutte le persone:");
        List<Persona> persone = dao.findAll();
        persone.forEach(System.out::println);

        // Trova una persona per codice fiscale
        System.out.println("\nTrova Mario Rossi:");
        System.out.println(dao.findById("RSSMRA80A01H501Z"));

        // Aggiorna una persona
        Persona updatedPersona = new Persona("Mario", "Rossi", "RSSMRA80A01H501Z", 31);
        dao.update(updatedPersona);
        System.out.println("\nDopo aggiornamento:");
        System.out.println(dao.findById("RSSMRA80A01H501Z"));

        // Elimina una persona
        dao.delete("BNCLGU80A01H501Y");
        System.out.println("\nDopo eliminazione:");
        dao.findAll().forEach(System.out::println);
    }
}
