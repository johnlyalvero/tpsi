import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaXMLDAO implements IPersonaDAO {
    private String filePath;

    public PersonaXMLDAO(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Persona> findAll() throws IOException {
        List<Persona> persone = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            String nome = null, cognome = null, codiceFiscale = null;
            int eta = -1;

            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.startsWith("<nome>")) {
                    nome = line.replace("<nome>", "").replace("</nome>", "").trim();
                } else if (line.startsWith("<cognome>")) {
                    cognome = line.replace("<cognome>", "").replace("</cognome>", "").trim();
                } else if (line.startsWith("<codiceFiscale>")) {
                    codiceFiscale = line.replace("<codiceFiscale>", "").replace("</codiceFiscale>", "").trim();
                } else if (line.startsWith("<eta>")) {
                    eta = Integer.parseInt(line.replace("<eta>", "").replace("</eta>", "").trim());
                } else if (line.startsWith("</persona>")) {
                    if (nome != null && cognome != null && codiceFiscale != null && eta != -1) {
                        persone.add(new Persona(nome, cognome, codiceFiscale, eta));
                    }
                    nome = null;
                    cognome = null;
                    codiceFiscale = null;
                    eta = -1;
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
            bw.write("<persone>");
            bw.newLine();
            for (Persona persona : persone) {
                bw.write("  <persona>");
                bw.newLine();
                bw.write("    <nome>" + persona.getNome() + "</nome>");
                bw.newLine();
                bw.write("    <cognome>" + persona.getCognome() + "</cognome>");
                bw.newLine();
                bw.write("    <codiceFiscale>" + persona.getCodiceFiscale() + "</codiceFiscale>");
                bw.newLine();
                bw.write("    <eta>" + persona.getEta() + "</eta>");
                bw.newLine();
                bw.write("  </persona>");
                bw.newLine();
            }
            bw.write("</persone>");
        }
    }
}
