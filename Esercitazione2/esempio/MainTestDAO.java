import java.util.ArrayList;

public class MainTestDAO {

    public static void main(String[] args) {
        // Crea un'istanza di DipendenteDAO con il nome del file "dipendenti.csv"
        IDipendenteDAO dao = new DipendenteDAOImpl("dipendenti.csv");

        // Aggiungi un nuovo dipendente
        Dipendente nuovoDipendente = new Dipendente("Mario", "Rossi", 1000.0f,12345678);
        dao.salvaDipendente(nuovoDipendente);

        // Rimuovi un dipendente in base alla matricola
        int matricolaDaRimuovere = 53682342;
        dao.cancellaDipendente(matricolaDaRimuovere);

        // Ottieni un dipendente in base alla matricola
        int matricolaDaCercare = 90909090;
        Dipendente dipendenteTrovato = dao.getDipendente(matricolaDaCercare);
        if (dipendenteTrovato != null) {
            System.out.println("Dipendente trovato: " + dipendenteTrovato.toString());
        } else {
            System.out.println("Dipendente non trovato.");
        }

        // Ottieni l'elenco completo dei dipendenti
        ArrayList<Dipendente> dipendenti = dao.getAllDipendenti();
        for (Dipendente dipendente : dipendenti) {
            System.out.println(dipendente.toString());
        }
    }
}
