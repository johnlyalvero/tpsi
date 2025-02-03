/*
6) Implementare in Java il pattern DTO per l’entità Utente nell’ipotesi che un’applicazione
distribuita debba trasferire solo id, nome e cognome della suddetta entità
 */

public class UtenteDTO { // Implementazione dell’entità come POJO
    private int id;
    private String nome, cognome;

    public UtenteDTO(int id, String nome, String cognome) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
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

    
}
