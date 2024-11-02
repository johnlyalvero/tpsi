package Esercitazione2;

public class Studente {
    private int id;
    private String nome, cognome;
    private float mediaVoti;
    
    public Studente(int id, String nome, String cognome, float mediaVoti) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.mediaVoti = mediaVoti;
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

    public float getMediaVoti() {
        return mediaVoti;
    }

    public void setMediaVoti(float mediaVoti) {
        this.mediaVoti = mediaVoti;
    }

    
}
