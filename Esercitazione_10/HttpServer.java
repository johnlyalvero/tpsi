import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.util.Date;
import java.util.StringTokenizer;

/**
 * Classe HttpServer - Implementa un server HTTP minimale in Java
 * che risponde alle richieste GET e restituisce file locali.
 * 
 */
public class HttpServer implements Runnable {
    private Socket clientSocket;

    public static void main(String[] args) {
        int port = 8080; // Porta di default
        
        // Controlla se è stata passata una porta come argomento
        if (args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Porta non valida, uso 8080 di default.");
            }
        }
        
        // Creazione del socket del server sulla porta specificata
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server HTTP in ascolto sulla porta " + port);
            
            while (true) {
                // Attende una connessione da un client
                Socket clientSocket = serverSocket.accept();
                System.out.println("Nuova connessione da " + clientSocket.getInetAddress().getHostAddress());
                
                // Gestisce la richiesta del client su un nuovo thread
                new Thread(new HttpServer(clientSocket)).start();
            }
        } catch (IOException e) {
            System.err.println("Errore durante l'avvio del server: " + e.getMessage());
        }
    }

    /**
     * Costruttore della classe, riceve il socket del client
     */
    public HttpServer(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }
    
    @Override
    public void run() {
        try (
            // Stream per leggere la richiesta del client
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            // Stream per scrivere la risposta al client
            DataOutputStream outToClient = new DataOutputStream(clientSocket.getOutputStream())
            ) {
            
            // Legge la prima riga della richiesta HTTP
            String requestString = inFromClient.readLine();
            if (requestString == null) {
                return; // Se la richiesta è nulla, termina la connessione
            }
            System.out.println("Richiesta del client: " + requestString);
            
            // Analizza la richiesta per ottenere il nome del file richiesto
            StringTokenizer tokenizer = new StringTokenizer(requestString);
            tokenizer.nextToken(); // Salta il metodo HTTP (GET)
            String fileName = tokenizer.nextToken();
            
            // Se il file richiesto è la root "/", carica index.html
            if (fileName.equals("/")) {
                fileName = "w3school/index.html";
            } else {
                fileName = fileName.substring(1); // Rimuove lo slash iniziale
            }
            
            // Cerca il file richiesto
            File file = new File(fileName);
            if (!file.exists() || file.isDirectory()) {
                // Se il file non esiste, carica la pagina di errore 404
                file = new File("404.html");
                outToClient.writeBytes("HTTP/1.1 404 Not Found\r\n");
            } else {
                outToClient.writeBytes("HTTP/1.1 200 OK\r\n");
            }
            
            // Legge il contenuto del file richiesto
            byte[] fileBytes = Files.readAllBytes(file.toPath());
            
            // Scrive gli header HTTP
            outToClient.writeBytes("Content-Type: text/html\r\n");
            outToClient.writeBytes("Content-Length: " + fileBytes.length + "\r\n");
            outToClient.writeBytes("Date: " + new Date() + "\r\n");
            outToClient.writeBytes("\r\n"); // Linea vuota per separare header da contenuto
            
            // Scrive il contenuto del file
            outToClient.write(fileBytes);
            outToClient.flush();
            
            System.out.println("Connessione chiusa con il client.");
        } catch (IOException e) {
            System.err.println("Errore nella gestione della richiesta: " + e.getMessage());
        }
    }
}
