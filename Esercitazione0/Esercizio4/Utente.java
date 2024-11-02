package EsercitazioniTPSI_Alvero_5AI.Esercitazione0.Esercizio4;

/*
 4) Implementare in Java l’entità Utente con i rispettivi metodi accessors avente i seguenti attributi:
id (intero positivo), nome, cognome, indirizzo, numero civico
 */

public class Utente {
    
    private int id;
    private String nome;
    private String cognome;
    private String indirizzo;
    private int numeroCivico;

    public Utente(){}

    public Utente(int id, String nome, String cognome, String indirizzo, int numeroCivico) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzo = indirizzo;
        this.numeroCivico = numeroCivico;
    }



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
    public String getIndirizzo() {
        return indirizzo;
    }
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }
    public int getNumeroCivico() {
        return numeroCivico;
    }
    public void setNumeroCivico(int numeroCivico) {
        this.numeroCivico = numeroCivico;
    }

    
}
