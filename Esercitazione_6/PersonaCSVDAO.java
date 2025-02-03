import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PersonaCSVDAO implements IPersonaDAO {
    private String filePath;

    public PersonaCSVDAO(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Persona> findAll() throws IOException {
        List<Persona> persone = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line, ",");
                String nome = tokenizer.nextToken();
                String cognome = tokenizer.nextToken();
                String codiceFiscale = tokenizer.nextToken();
                int eta = Integer.parseInt(tokenizer.nextToken());
                persone.add(new Persona(nome, cognome, codiceFiscale, eta));
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
            for (Persona persona : persone) {
                bw.write(persona.getNome() + "," + persona.getCognome() + "," +
                        persona.getCodiceFiscale() + "," + persona.getEta());
                bw.newLine();
            }
        }
    }
}