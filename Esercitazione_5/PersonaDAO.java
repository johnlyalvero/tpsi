import java.io.*;
import java.util.*;

/**
 * Classe DAO per la gestione della persistenza dell'entità Persona nel formato CSV.
 */
public class PersonaDAO {
    private static final String FILE_NAME = "persone.csv";

    public static void salvaPersone(List<Persona> persone) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Persona p : persone) {
                writer.write(p.toString());
                writer.newLine();
            }
        }
    }

    public static List<Persona> caricaPersone() throws IOException {
        List<Persona> persone = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line, ",");
                int id = Integer.parseInt(tokenizer.nextToken());
                String nome = tokenizer.nextToken();
                String cognome = tokenizer.nextToken();
                int eta = Integer.parseInt(tokenizer.nextToken());
                persone.add(new Persona(id, nome, cognome, eta));
            }
        }
        return persone;
    }
}
