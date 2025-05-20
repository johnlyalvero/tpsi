/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package it.tpsi.esercitazione_13;

import org.hibernate.cfg.Configuration;

/**
 *
 * @author Johnly
 */
public class Esercitazione_13 {

    public static void main(String[] args) {
        IStudenteDAO studenteDAO = new StudenteDAO(new Configuration().configure().buildSessionFactory());

        // Creazione di un nuovo studente
        Studente nuovoStudente = new Studente("Giovanni", "Bianchi", "1234567890", "gbianchi", "password");
        studenteDAO.save(nuovoStudente);

        // Recupero di un studente
        Studente studente = studenteDAO.findById(1);
        if (studente != null) {
            System.out.println("Studente trovato: " + studente.getNome() + " " + studente.getCognome());
        }

        // Aggiornamento di un utente
        if (studente != null) {
            studente.setCognome("Verdi");
            studenteDAO.update(studente);
        }

        // Eliminazione di un utente
        if (studente != null) {
            studenteDAO.delete(studente);
        }

        // Trovare tutti gli utenti
        System.out.println("Lista degli studenti:");
        studenteDAO.findAll().forEach(u -> System.out.println(u.getNome() + " " + u.getCognome()));

    }
}
