import java.awt.event.*;
import java.io.IOException;
import java.util.*;

public class StudenteController {
    private List<Studente> studenti;
    private StudenteView view;

    public StudenteController(StudenteView view) {
        this.view = view;
        this.studenti = new ArrayList<>();

        this.view.addAddButtonListener(e -> aggiungiStudente());
        this.view.addDeleteButtonListener(e -> cancellaStudente());
        this.view.addSaveButtonListener(e -> salvaStudenti());
        this.view.addLoadButtonListener(e -> caricaStudenti());
    }

    private void aggiungiStudente() {
        try {
            int id = Integer.parseInt(view.getId());
            String nome = view.getNome();
            String cognome = view.getCognome();
            float media = Float.parseFloat(view.getMediaVoti());

            studenti.add(new Studente(id, nome, cognome, media));
            view.setDisplayArea(studenti);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Errore nei dati inseriti", "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cancellaStudente() {
        if (!studenti.isEmpty()) {
            studenti.remove(studenti.size() - 1);
            view.setDisplayArea(studenti);
        }
    }

    private void salvaStudenti() {
        try {
            StudenteDAO.salvaStudenti(studenti);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(view, "Errore nel salvataggio", "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void caricaStudenti() {
        try {
            studenti = StudenteDAO.caricaStudenti();
            view.setDisplayArea(studenti);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(view, "Errore nel caricamento", "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }
}