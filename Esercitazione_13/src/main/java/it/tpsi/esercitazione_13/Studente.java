/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tpsi.esercitazione_13;

/**
 *
 * @author Johnly
 */

import org.apache.commons.codec.digest.DigestUtils;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "studenti") // Specifica il nome della tabella se è diverso dal nome della classe
public class Studente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "cognome", nullable = false, length = 100)
    private String cognome;

    @Column(name = "telefono", nullable = false, length = 10)
    private String telefono;

    @Column(name = "utente", nullable = false, length = 10)
    private String utente;

    @Column(name = "password", nullable = false, length = 8)
    private String password;

    // Costruttori
    public Studente() {
    }

    public Studente(String nome, String cognome, String telefono, String utente, String password) {
        this.nome = nome;
        this.cognome = cognome;
        try {
            Integer.parseInt(telefono);
        } catch (NumberFormatException e) {
            System.out.println("The input is not a valid number.");
        }
        this.telefono = telefono;
        this.utente = utente;
        this.password = DigestUtils.sha256Hex(password);
    }

    // Getter e Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUtente() {
        return utente;
    }

    public void setUtente(String utente) {
        this.utente = utente;
    }

    // NB Ha senso mettere il setter e il getter per la password?
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
