package it.tpsi.esercitazione_13;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StudenteDAO implements IStudenteDAO {
    private SessionFactory sessionFactory;

    public StudenteDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Studente findById(int id) {
        Session session = sessionFactory.openSession();
        Studente utente = session.get(Studente.class, id);
        session.close();
        return utente;
    }

    @Override
    public void save(Studente utente) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(utente);
        tx.commit();
        session.close();
    }

    @Override
    public void update(Studente utente) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(utente);
        tx.commit();
        session.close();
    }

    @Override
    public void delete(Studente utente) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(utente);
        tx.commit();
        session.close();
    }

    @Override
    public List<Studente> findAll() {
        Session session = sessionFactory.openSession();
        List<Studente> list = session.createQuery("FROM Utente", Studente.class).list();
        session.close();
        return list;
    }
}
