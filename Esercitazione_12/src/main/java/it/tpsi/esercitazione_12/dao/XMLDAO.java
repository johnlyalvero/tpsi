/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tpsi.esercitazione_12.dao;

/**
 *
 * @author Johnly
 */
import it.tpsi.esercitazione_12.model.Dipendente;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;
import org.jdom2.output.Format;

import java.io.*;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import org.jdom2.JDOMException;

public class XMLDAO implements IDipendenteDAO{
private static final String FILE = "src/main/resources/dipendenti.xml";

    @Override
    public void save(List<Dipendente> lista) {
        
        Element root = new Element("dipendenti");
        Document doc = new Document(root);
        
        for (Dipendente d : lista) {
            Element e = new Element("dipendente");
            
            e.addContent(new Element("nome").setText(d.getNome()));
            e.addContent(new Element("cognome").setText(d.getCognome()));
            e.addContent(new Element("id").setText(String.valueOf(d.getId())));
            e.addContent(new Element("eta").setText(String.valueOf(d.getEta())));
            e.addContent(new Element("stipendio").setText(String.valueOf(d.getStipendio())));
            
            root.addContent(e);
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE))) {
            new XMLOutputter(Format.getPrettyFormat()).output(doc,writer);
        } catch (IOException e) {
            System.out.println("Errore scrittura XML: " + e.getMessage());
        }
    }

    @Override
    public List<Dipendente> readAll() {
        List<Dipendente> lista = new ArrayList<>();
        File file = new File(FILE);
        if (!file.exists()) return lista;

        try {
            Document doc = new SAXBuilder().build(file);
            Element root = doc.getRootElement();

            for (Element e : root.getChildren("dipendente")) {
                Dipendente d = new Dipendente(
                    e.getChildText("nome"),
                    e.getChildText("cognome"),
                    Integer.parseInt(e.getChildText("id")),
                    Integer.parseInt(e.getChildText("eta")),
                    Double.parseDouble(e.getChildText("stipendio"))
                );
                lista.add(d);
            }
        } catch (IOException | NumberFormatException | JDOMException ex) {
            System.out.println("Errore lettura XML: " + ex.getMessage());
        }

        return lista;
    }

    @Override
    public Dipendente readById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateDipendente(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteDipendente(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}