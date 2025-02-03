package EsercitazioniTPSI_Alvero_5AI.Esercitazione0.Esercizio5;


public class Main {
    public static void main(String[] args){
        UtenteDAOImpl Utenti = new UtenteDAOImpl();

        Utenti.saveUtente(new Utente(1, "Kakarot", "Saiyan", "Montagna", 0));
        Utenti.saveUtente(new Utente(2, "Vegeta", "Saiyan", "Pianeta Vegeta", 9999));
        Utenti.saveUtente(new Utente(3, "Whis", "Angel", "Casa di Beerus", 100000000));
        System.out.println(Utenti.getAllUtenti());

        Utenti.deleteUtente(2);
        System.out.println(Utenti.getAllUtenti());

        System.out.println(Utenti.getUtentiById(1));

        Utenti.updateUtente(3);
    }
}
