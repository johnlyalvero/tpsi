/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tpsi.esercitazione_12.dao;

/**
 *
 * @author Johnly
 */
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import it.tpsi.esercitazione_12.model.Dipendente;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JSONDAO implements IDipendenteDAO{
    private static final String FILE = "src/main/resources/dipendenti.json";
    private final Gson gson = new Gson();

    @Override
    public void save(List<Dipendente> lista) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE))) {
            gson.toJson(lista,writer);
        } catch (IOException e) {
            System.out.println("Errore scrittura JSON: " + e.getMessage());
        }
    }

    @Override
    public List<Dipendente> readAll() {
        List<Dipendente> lista = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            Type listType = new TypeToken<List<Dipendente>>() {}.getType();
            lista = gson.fromJson(reader, listType);
        } catch (IOException e) {
            System.out.println("Errore lettura JSON: " + e.getMessage());
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
