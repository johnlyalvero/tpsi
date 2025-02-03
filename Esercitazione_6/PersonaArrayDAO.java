import java.util.ArrayList;
import java.util.List;

public class PersonaArrayDAO implements IPersonaDAO {
    private List<Persona> persone;

    public PersonaArrayDAO() {
        this.persone = new ArrayList<>();
    }

    @Override
    public List<Persona> findAll() {
        return new ArrayList<>(persone); // Ritorna una copia per preservare l'integrità dei dati
    }

    @Override
    public Persona findById(String codiceFiscale) {
        for (Persona persona : persone) {
            if (persona.getCodiceFiscale().equals(codiceFiscale)) {
                return persona;
            }
        }
        return null; // Se non trova la persona con il codice fiscale dato
    }

    @Override
    public void save(Persona persona) {
        if (findById(persona.getCodiceFiscale()) == null) {
            persone.add(persona); // Aggiunge solo se la persona non esiste già
        } else {
            throw new IllegalArgumentException("Persona con codice fiscale esistente: " + persona.getCodiceFiscale());
        }
    }

    @Override
    public void update(Persona persona) {
        for (int i = 0; i < persone.size(); i++) {
            if (persone.get(i).getCodiceFiscale().equals(persona.getCodiceFiscale())) {
                persone.set(i, persona); // Aggiorna l'elemento con la nuova versione della persona
                return;
            }
        }
        throw new IllegalArgumentException("Persona non trovata con codice fiscale: " + persona.getCodiceFiscale());
    }

    @Override
    public void delete(String codiceFiscale) {
        persone.removeIf(p -> p.getCodiceFiscale().equals(codiceFiscale)); // Rimuove la persona se presente
    }
}
