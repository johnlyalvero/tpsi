/**
 * Classe che rappresenta una Persona con attributi di base.
 */
public class Persona {
    private int id;
    private String nome;
    private String cognome;
    private int eta;

    public Persona(int id, String nome, String cognome, int eta) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getCognome() { return cognome; }
    public int getEta() { return eta; }

    @Override
    public String toString() {
        return id + "," + nome + "," + cognome + "," + eta;
    }
}
