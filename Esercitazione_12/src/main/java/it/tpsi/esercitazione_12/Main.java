/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package it.tpsi.esercitazione_12;

/**
 *
 * @author Johnly
 */

import java.util.List;

import it.tpsi.esercitazione_12.dao.DBDAO;
import it.tpsi.esercitazione_12.dao.IDipendenteDAO;
import it.tpsi.esercitazione_12.model.Dipendente;

public class Main {
    public static void main(String[] args) {
        List<Dipendente> lista = List.of(
            new Dipendente("Mario", "Rossi",1, 30, 1500.0),
            new Dipendente("Luca", "Bianchi",2, 40, 2000.0)
        );

        IDipendenteDAO dao = new DBDAO(); // ← Sostituisci con altri DAO per testare
        dao.save(lista);
        List<Dipendente> letti = dao.readAll();

        letti.forEach(System.out::println); 
    }
}
