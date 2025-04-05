/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.tpsi.esercitazione_12.model;

/**
 *
 * Classe che rappresenta un'entità Dipendente con ID, nome, cognome, eta e stipendio
 * 
 * @author Johnly
 */
public class Dipendente {
    private int id;
    private String nome;
    private String cognome;
    private int eta;
    private double stipendio;

    public Dipendente(int id, String nome, String cognome, int eta, double stipendio) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.stipendio = stipendio;
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

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        this.eta = eta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getStipendio() {
        return stipendio;
    }

    public void setStipendio(double stipendio) {
        this.stipendio = stipendio;
    }

    @Override
    public String toString() {
        return "Dipendente{" + "id=" + id + "nome=" + nome + ", cognome=" + cognome + " eta=" + eta +  ", stipendio=" + stipendio + '}';
    }
    
    
}
