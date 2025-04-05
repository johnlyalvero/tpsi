/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package it.tpsi.esercitazione_12;

/**
 * Classe principale che esegue il programma: legge i
 * dati da CSV, JSON e XML e li inserisce nel databse
 * @author Johnly
 */
import java.util.ArrayList;
import java.util.List;

import it.tpsi.esercitazione_12.dao.CSVDAO;
import it.tpsi.esercitazione_12.dao.DBDAO;
import it.tpsi.esercitazione_12.dao.IDipendenteDAO;
import it.tpsi.esercitazione_12.dao.JSONDAO;
import it.tpsi.esercitazione_12.dao.XMLDAO;
import it.tpsi.esercitazione_12.model.Dipendente;

public class Main {

    public static void main(String[] args) {

        // Lista finale di tutti i dipendenti
        List<Dipendente> tuttiIDipendenti = new ArrayList<>();

        IDipendenteDAO csvDAO = new CSVDAO();
        List<Dipendente> csvDipendenti = csvDAO.readAll();
        System.out.println("Dipendenti da CSV:");
        csvDipendenti.forEach(System.out::println);
        tuttiIDipendenti.addAll(csvDipendenti);

        IDipendenteDAO jsonDAO = new JSONDAO();
        List<Dipendente> jsonDipendenti = jsonDAO.readAll();
        System.out.println("\nDipendenti da JSON:");
        jsonDipendenti.forEach(System.out::println);
        tuttiIDipendenti.addAll(jsonDipendenti);

        IDipendenteDAO xmlDAO = new XMLDAO();
        List<Dipendente> xmlDipendenti = xmlDAO.readAll();
        System.out.println("\nDipendenti da XML:");
        xmlDipendenti.forEach(System.out::println);
        tuttiIDipendenti.addAll(xmlDipendenti);

        System.out.println("\nTutti i dipendenti da salvare:");
        tuttiIDipendenti.forEach(System.out::println);

        IDipendenteDAO dbDAO = new DBDAO();
        dbDAO.save(tuttiIDipendenti);

        System.out.println("\nDipendenti salvati nel DB:");
        List<Dipendente> dbDipendenti = dbDAO.readAll();
        dbDipendenti.forEach(System.out::println);

    }
}
