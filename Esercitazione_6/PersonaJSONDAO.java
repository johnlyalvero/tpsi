import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaJSONDAO implements IPersonaDAO {
    private String filePath;

    public PersonaJSONDAO(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Persona> findAll() throws IOException {
        List<Persona> persone = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder jsonContent = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                jsonContent.append(line.trim());
            }
            String content = jsonContent.toString();

            // Rimozione dei caratteri iniziali e finali dell'array JSON: "[" e "]"
            content = content.substring(1, content.length() - 1).trim();
            String[] personaObjects = content.split("\\},\\{");

            for (String obj : personaObjects) {
                // Pulizia delle parentesi graffe di inizio e fine per ogni oggetto
                obj = obj.replace("{", "").replace("}", "").trim();
                String[] fields = obj.split(",");

                String nome = null, cognome = null, codiceFiscale = null;
                int eta = -1;

                for (String field : fields) {
                    String[] keyValue = field.split(":");
                    String key = keyValue[0].replaceAll("\"", "").trim();
                    String value = keyValue[1].replaceAll("\"", "").trim();

                    switch (key) {
                        case "nome":
                            nome = value;
                            break;
                        case "cognome":
                            cognome = value;
                            break;
                        case "codiceFiscale":
                            codiceFiscale = value;
                            break;
                        case "eta":
                            eta = Integer.parseInt(value);
                            break;
                    }
                }

                if (nome != null && cognome != null && codiceFiscale != null && eta != -1) {
                    persone.add(new Persona(nome, cognome, codiceFiscale, eta));
                }
            }
        }
        return persone;
    }

    @Override
    public Persona findById(String codiceFiscale) throws IOException {
        List<Persona> persone = findAll();
        for (Persona persona : persone) {
            if (persona.getCodiceFiscale().equals(codiceFiscale)) {
                return persona;
            }
        }
        return null;
    }

    @Override
    public void save(Persona persona) throws IOException {
        List<Persona> persone = findAll();
        persone.add(persona);
        saveAll(persone);
    }

    @Override
    public void update(Persona persona) throws IOException {
        List<Persona> persone = findAll();
        for (int i = 0; i < persone.size(); i++) {
            if (persone.get(i).getCodiceFiscale().equals(persona.getCodiceFiscale())) {
                persone.set(i, persona);
                saveAll(persone);
                return;
            }
        }
    }

    @Override
    public void delete(String codiceFiscale) throws IOException {
        List<Persona> persone = findAll();
        persone.removeIf(p -> p.getCodiceFiscale().equals(codiceFiscale));
        saveAll(persone);
    }

    private void saveAll(List<Persona> persone) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write("[");
            bw.newLine();
            for (int i = 0; i < persone.size(); i++) {
                Persona persona = persone.get(i);
                bw.write("  {");
                bw.write("\"nome\": \"" + persona.getNome() + "\", ");
                bw.write("\"cognome\": \"" + persona.getCognome() + "\", ");
                bw.write("\"codiceFiscale\": \"" + persona.getCodiceFiscale() + "\", ");
                bw.write("\"eta\": " + persona.getEta());
                bw.write("}");
                if (i < persone.size() - 1) {
                    bw.write(",");
                }
                bw.newLine();
            }
            bw.write("]");
        }
    }
}
