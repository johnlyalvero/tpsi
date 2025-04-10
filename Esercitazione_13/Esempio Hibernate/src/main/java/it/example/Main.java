package it.example;

import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        IUtenteDAO utenteDAO = new UtenteDAO(new Configuration().configure().buildSessionFactory());

        // Creazione di un nuovo utente
        Utente nuovoUtente = new Utente("Giovanni", "Bianchi");
        utenteDAO.save(nuovoUtente);

        // Recupero di un utente
        Utente utente = utenteDAO.findById(1);
        if (utente != null) {
            System.out.println("Utente trovato: " + utente.getNome() + " " + utente.getCognome());
        }

        // Aggiornamento di un utente
        if (utente != null) {
            utente.setCognome("Verdi");
            utenteDAO.update(utente);
        }

        // Eliminazione di un utente
        if (utente != null) {
            utenteDAO.delete(utente);
        }

        // Trovare tutti gli utenti
        System.out.println("Lista degli utenti:");
        utenteDAO.findAll().forEach(u -> System.out.println(u.getNome() + " " + u.getCognome()));
    }
}