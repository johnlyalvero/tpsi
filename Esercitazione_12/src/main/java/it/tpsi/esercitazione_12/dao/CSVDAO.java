/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tpsi.esercitazione_12.dao;

/**
 *
 * DAO che gestisce la lettura e scrittura dei dipendenti
 * in formato CSV.
 * 
 * @author Johnly
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import it.tpsi.esercitazione_12.model.Dipendente;

public class CSVDAO implements IDipendenteDAO {
    private static final String FILE = "src/main/resources/dipendenti.csv";

    @Override
    public void save(List<Dipendente> lista) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE))) {
            for (Dipendente d : lista) {
                writer.write(d.getId() + "," + d.getNome() + "," + d.getCognome() + "," + d.getEta() + ","
                        + d.getStipendio());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Errore scrittura CSV: " + e.getMessage());
        }
    }

    @Override
    public List<Dipendente> readAll() {
        List<Dipendente> lista = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            String riga;
            while ((riga = reader.readLine()) != null) {
                String[] dati = riga.split(",");
                Dipendente d = new Dipendente(
                        Integer.parseInt(dati[0]),
                        dati[1],
                        dati[2],
                        Integer.parseInt(dati[3]),
                        Double.parseDouble(dati[4]));
                lista.add(d);
            }
        } catch (IOException e) {
            System.out.println("Errore lettura CSV: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public Dipendente readById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateDipendente(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteDipendente(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from
                                                                       // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
