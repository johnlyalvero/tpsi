public class Persona {
    // Attributi della classe
    private String nome;
    private String cognome;
    private String codiceFiscale; // stringa di 16 caratteri
    private int eta;

    // Costruttore
    public Persona(String nome, String cognome, String codiceFiscale, int eta) {
        this.nome = nome;
        this.cognome = cognome;
        setCodiceFiscale(codiceFiscale); // per la validazione della lunghezza
        this.eta = eta;
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

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        if (codiceFiscale != null && codiceFiscale.length() == 16) {
            this.codiceFiscale = codiceFiscale;
        } else {
            throw new IllegalArgumentException("Il codice fiscale deve essere di 16 caratteri");
        }
    }

    public int getEta() {
        return eta;
    }

    public void setEta(int eta) {
        if (eta >= 0) {
            this.eta = eta;
        } else {
            throw new IllegalArgumentException("L'età deve essere un numero positivo");
        }
    }

    public PersonaDTO toDTO() {
        return new PersonaDTO(this.nome, this.cognome);
    }
	
    // Metodo toString per rappresentazione della Persona nel formato richiesto
    @Override
    public String toString() {
        return nome + " " + cognome + " " + codiceFiscale + " " + eta;
    }
}
