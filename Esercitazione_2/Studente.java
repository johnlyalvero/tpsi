public class Studente {
    private int id;
    private String nome;
    private String cognome;
    private float mediaVoti;

    public Studente(int id, String nome, String cognome, float mediaVoti) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.mediaVoti = mediaVoti;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getCognome() { return cognome; }
    public float getMediaVoti() { return mediaVoti; }

    @Override
    public String toString() {
        return id + "," + nome + "," + cognome + "," + mediaVoti;
    }
}