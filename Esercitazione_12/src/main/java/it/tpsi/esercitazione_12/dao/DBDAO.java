/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tpsi.esercitazione_12.dao;

/**
 *
 * @author Johnly
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.tpsi.esercitazione_12.model.Dipendente;

public class DBDAO implements IDipendenteDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/azienda";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

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
        } catch (SQLException e) {
            System.out.println("Errore scrittura su DB: " + e.getMessage());
        }
    }

    @Override
    public List<Dipendente> readAll() {
        List<Dipendente> lista = new ArrayList<>();
        String sql = "SELECT * FROM dipendenti";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Dipendente d = new Dipendente(
                    rs.getString("nome"),
                    rs.getString("cognome"),
                    rs.getInt("id"),
                    rs.getInt("eta"),
                    rs.getDouble("stipendio")
                );
                lista.add(d);
            }
        } catch (SQLException e) {
            System.out.println("Errore lettura dal DB: " + e.getMessage());
        }

        return lista;
    }

    @Override
    public Dipendente readById(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void updateDipendente(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deleteDipendente(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}