import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.lang.Object; 

/**
 * Classe HttpClient - Implementa un client HTTP minimale
 * che si connette a un server web, invia una richiesta GET
 * e stampa la risposta ricevuta.
 * 
 * ✔ Si connette a un server HTTP specificato dall'utente
 * ✔ Invia una richiesta GET per ottenere una pagina
 * ✔ Riceve e stampa la risposta dal server
 */
public class HttpClient {
    public static void main(String[] args) {
        // Imposta i valori di default per l'host, la porta e il file richiesto
        String host = "localhost";
        int port = 8080;
        String file = "/";

        // Se l'utente fornisce argomenti, aggiorna le impostazioni
        if (args.length > 0) {
            host = args[0]; // Imposta l'host
        }
        if (args.length > 1) {
            try {
                port = Integer.parseInt(args[1]); // Imposta la porta
            } catch (NumberFormatException e) {
                System.out.println("Porta non valida, uso 8080 di default.");
            }
        }
        if (args.length > 2) {
            file = args[2]; // Imposta il file richiesto
        }

        // Prova a connettersi al server e inviare la richiesta
        try (
            Socket socket = new Socket(host, port); // Crea il socket per la connessione
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true); // Stream per inviare dati
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())) // Stream per ricevere dati
        ) {
            // Invia la richiesta HTTP al server
            out.println("GET " + file + " HTTP/1.1"); // Richiesta GET per il file specificato
            out.println("Host: " + host); // Specifica l'host
            out.println("Connection: close"); // Indica che la connessione verrà chiusa dopo la risposta
            out.println(); // Linea vuota per terminare gli header della richiesta

            // Legge e stampa la risposta ricevuta dal server
            String responseLine;
            while ((responseLine = in.readLine()) != null) {
                System.out.println(responseLine); // Stampa ogni linea della risposta
            }
        } catch (IOException e) {
            System.err.println("Errore nella comunicazione con il server: " + e.getMessage());
        }
    }
}
