public class PersonaDTO {
    private String nome;
    private String cognome;

    // Costruttore
    public PersonaDTO(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    // Metodi getter e setter
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

    // Metodo toString per visualizzare il DTO
    @Override
    public String toString() {
        return nome + " " + cognome;
    }
}
