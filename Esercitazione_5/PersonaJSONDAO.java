import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.util.*;

/**
 * Classe DAO per la gestione della persistenza dell'entità Persona nel formato JSON.
 */
public class PersonaJSONDAO {
    private static final String FILE_NAME = "persone.json";
    private static final Gson gson = new Gson();

    public static void salvaPersone(List<Persona> persone) throws IOException {
        try (Writer writer = new FileWriter(FILE_NAME)) {
            gson.toJson(persone, writer);
        }
    }

    public static List<Persona> caricaPersone() throws IOException {
        try (Reader reader = new FileReader(FILE_NAME)) {
            return gson.fromJson(reader, new TypeToken<List<Persona>>(){}.getType());
        }
    }
}
