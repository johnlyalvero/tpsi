package it.tpsi.esercitazione_12.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.tpsi.esercitazione_12.model.Dipendente;

/**
 * DAO per la gestione dei dipendenti nel database MySQL.
 * Implementa le operazioni CRUD di base (salva e leggi).
 * Utilizza JDBC per la connessione al database 'azienda'.
 * 
 * @author Johnly
 */
public class DBDAO implements IDipendenteDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/azienda";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    /**
     * Salva una lista di dipendenti nel database.
     * 
     * @param lista la lista dei dipendenti da salvare
     */
    @Override
    public void save(List<Dipendente> lista) {
        String sql = "INSERT INTO dipendenti (id, nome, cognome, eta, stipendio) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            for (Dipendente d : lista) {
                stmt.setInt(1, d.getId());
                stmt.setString(2, d.getNome());
                stmt.setString(3, d.getCognome());
                stmt.setInt(4, d.getEta());
                stmt.setDouble(5, d.getStipendio());
                stmt.executeUpdate();
            }

            System.out.println("Dati salvati correttamente nel database MySQL.");
        } catch (SQLException e) {
            System.out.println("Errore durante il salvataggio nel DB: " + e.getMessage());
        }
    }

    /**
     * Legge tutti i dipendenti dal database.
     * 
     * @return una lista di oggetti Dipendente letti dal DB
     */
    @Override
    public List<Dipendente> readAll() {
        List<Dipendente> lista = new ArrayList<>();
        String sql = "SELECT * FROM dipendenti";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Dipendente d = new Dipendente(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("cognome"),
                    rs.getInt("eta"),
                    rs.getDouble("stipendio")
                );
                lista.add(d);
            }

        } catch (SQLException e) {
            System.out.println("Errore durante la lettura dal DB: " + e.getMessage());
        }

        return lista;
    }

    /**
     * Metodo non implementato per leggere un dipendente per ID.
     * 
     * @param id l'identificativo del dipendente
     * @return l'oggetto Dipendente corrispondente (da implementare)
     */
    @Override
    public Dipendente readById(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Metodo non implementato per aggiornare un dipendente.
     * 
     * @param id l'identificativo del dipendente da aggiornare
     */
    @Override
    public void updateDipendente(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Metodo non implementato per eliminare un dipendente.
     * 
     * @param id l'identificativo del dipendente da eliminare
     */
    @Override
    public void deleteDipendente(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
