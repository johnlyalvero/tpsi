import java.io.*;
import java.util.*;

public class StudenteDAO {
    private static final String FILE_NAME = "studenti.csv";

    public static void salvaStudenti(List<Studente> studenti) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Studente s : studenti) {
                writer.write(s.toString());
                writer.newLine();
            }
        }
    }

    public static List<Studente> caricaStudenti() throws IOException {
        List<Studente> studenti = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line, ",");
                int id = Integer.parseInt(tokenizer.nextToken());
                String nome = tokenizer.nextToken();
                String cognome = tokenizer.nextToken();
                float mediaVoti = Float.parseFloat(tokenizer.nextToken());
                studenti.add(new Studente(id, nome, cognome, mediaVoti));
            }
        }
        return studenti;
    }
}