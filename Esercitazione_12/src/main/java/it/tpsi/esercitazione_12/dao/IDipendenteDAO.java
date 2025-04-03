/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tpsi.esercitazione_12.dao;

/**
 *
 * @author Johnly
 */

import java.util.List;
import it.tpsi.esercitazione_12.model.Dipendente;

public interface IDipendenteDAO {
    void save(List<Dipendente> lista);     //C
    Dipendente readById(int id);   //R
    List<Dipendente> readAll();
    void updateDipendente(int id);          //U
    void deleteDipendente(int id);          //D
}
