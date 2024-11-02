package esercitazioni.Esercitazioni0.Esercizio5;
import java.util.LinkedList;

public interface UtenteDAO { //Interfaccai DAO con definizione dei metodi CRUD
    public void saveUtente(Utente utente);  //Create
    public Utente getUtentiById(int id);    //Read
    public void updateUtente(int id);       //Update
    public void deleteUtente(int id);       //Delete
    public LinkedList<Utente> getAllUtenti(); 
}
