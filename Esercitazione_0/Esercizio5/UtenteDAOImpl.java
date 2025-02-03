package esercitazioni.Esercitazioni0.Esercizio5;

import java.util.LinkedList;
import java.util.Scanner;

public class UtenteDAOImpl implements UtenteDAO{ //Implementazioen della classe DAO e dei metodi CRUD
    
    private LinkedList<Utente> utenti;
    private Scanner scan = new Scanner(System.in);

    public UtenteDAOImpl(){
        utenti = new LinkedList<>();
    }

    public void saveUtente(Utente utente){
        utenti.add(utente);
        System.out.println("CREATED!");
    }

    public Utente getUtentiById(int id){
        for(Utente u : utenti)
            if(u.getId() == id)
                return u;

        return null;
    }

    public void updateUtente(int id){
        Utente utente = null;
        String stringa;
        int intero;

        for(Utente u : utenti)
            if(u.getId() == id){
                utente = u;
                break;
            }

        if(utente == null)
            return;
        
        System.out.println("WHERE id = "+id+" has NOME: " + utente.getNome() + ", CONGNOME: " + utente.getCognome() 
        + ", INDIRIZZO: " + utente.getIndirizzo() + ", NUMERO CIVICO: " + utente.getNumeroCivico()) ;

        System.out.print("New NAME: ");
        stringa = scan.nextLine();
        if(stringa != "")
            utente.setNome(stringa);

        System.out.print("New COGNOME: ");
        stringa = scan.nextLine();
        if(stringa != "")
            utente.setCognome(stringa);
        
        System.out.print("New INDIRIZZO: ");
        stringa = scan.nextLine();
        if(stringa != "")
            utente.setIndirizzo(stringa);

        System.out.print("New NUMERO CIVICO: ");
        stringa = scan.nextLine();
        if(stringa != ""){
            utente.setNumeroCivico(Integer.parseInt(stringa));
        }

        System.out.println("WHERE id = "+id+" has NOME: " + utente.getNome() + ", CONGNOME: " + utente.getCognome() 
        + ", INDIRIZZO: " + utente.getIndirizzo() + ", NUMERO CIVICO: " + utente.getNumeroCivico()) ;
        System.out.println("UPDATED!");

    }

    public void deleteUtente(int id){
        for(Utente u : utenti)
            if(u.getId() == id){
                utenti.remove(u);
                System.out.println("DELETED!");
            }
        
    }

    public LinkedList<Utente> getAllUtenti(){
        return utenti;
    }
}
