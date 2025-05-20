/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tpsi.esercitazione_13;

/**
 *
 * @author Johnly
 */

import java.util.List;

public interface IStudenteDAO {
    Studente findById(int id);
    void save(Studente utente);
    void update(Studente utente);
    void delete(Studente utente);
    List<Studente> findAll();
}
