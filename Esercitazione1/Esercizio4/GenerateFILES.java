/*
 * 4) Scrivere una classe Java che generi automaticamente i file XML e JSON di cui sopra.
Specificatamente, il programma dovrà chiedere all’utente se è intenzionato ad inserire una
nuova persona oppure se termina. Se viene chiesto di inserire una nuova persona, il
programma deve gestire il caso in cui l’utente inserisce un’età errata e deve richiedere di
ridigitare il dato. In caso invece di terminazione, il programma salva entrambi i file.
Controllare sempre gli input immessi nel programma e visualizzare i messaggi di errore
opportuni. Implementare la classe in modo che sia conforme al pattern Singleton
 */

package Esercitazione1.Esercizio4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import java.util.Scanner;

public class GenerateFILES {

    private static final GenerateFILES generator = new GenerateFILES();
    private PrintWriter outputJSON, outputXML;
    private Scanner scan = new Scanner(System.in);
    private String input;

    private GenerateFILES() {
    }

    public synchronized static GenerateFILES getInstance() {
        return generator;
    }

    public void generateJSONXML() {
        try {
            outputJSON = new PrintWriter("./Esercitazione1/Esercizio4/outputJSON.json"); // Crea o apri file
            outputXML = new PrintWriter("./Esercitazione1/Esercizio4/outputXML.xml"); // Crea o apri file

            outputJSON.println("{");
            outputJSON.println("\"persone\": [");

            outputXML.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            outputXML.println("<persona>");

            while (true) {
                System.out.println("Vuoi creare una persona?[Y/N]");
                input = scan.nextLine();

                if (input == "Y" || input == "y") {
                    outputJSON.println();
                } else if (input == "N" || input == "n") {
                    break; // finisce il programma
                } else {
                    System.out.println("input non valido");
                }
            }

            outputJSON.println("]");
            outputJSON.println("}");

            outputXML.println("</persona>");

            outputXML.close();
            outputJSON.close(); // Chiude il File
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String generatePersonJSON(String nome, String cognome, String eta) {
        return "{\n\"nome\": \"" + nome + "\",\n" + "\"cognome\": \"" + cognome + "\",\n" + "\"eta\": \"" + eta
                + "\"\n}";
    }
}
