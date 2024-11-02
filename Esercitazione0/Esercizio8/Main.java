package tpsi.esercitazioni.Esercitazione0.Esercizio8;

import javax.swing.*;
import java.awt.event.*;
/*
 * 8) Creare una finestra con due campi di testo (JTextField) per inserire due numeri:
        • Aggiungere un pulsante "Somma" e una JLabel per visualizzare il risultato. Quando l'utente
            inserisce due numeri e clicca il pulsante, la somma dovrebbe essere visualizzata nell'etichetta
 */

public class Main {
    public static void main(String[] args) {
		// Creiamo la finestra
		JFrame finestra = new JFrame("Esercitazione 0, Esercizio 7");
		finestra.setSize(800, 400);
		finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Specifica cosa fare quando si chiude la finestra (terminare il programma)
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Creiamo i JTextField
		JTextField input1 = new JTextField(20); // Il numero indica la lunghezza
		JTextField input2 = new JTextField(20); // Il numero indica la lunghezza

		// Creiamo un pulsante
		JButton bottone = new JButton("Somma!");
        
		// Creiamo una JLabel
		JLabel etichetta = new JLabel("");

        // Aggiungiamo un listener per catturare l'evento di click
		bottone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                String risultato;
                if(isInteger(input1.getText()) && isInteger(input2.getText()))
                    risultato = Integer.toString(Integer.parseInt(input1.getText()) + Integer.parseInt(input2.getText()));
                else
                    risultato = "Input non validi";
                etichetta.setText(risultato);
			}
		});

        // Aggiungiamo gli elementi
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.add(input1);
        panel.add(input2);
        panel.add(bottone);
        panel.add(etichetta);

        // Aggiungo gli elementi
		finestra.add(panel);
        
		// Rendiamo la finestra visibile
		finestra.setVisible(true);
    }

    public static boolean isInteger(String s) {
        try { 
            Integer.parseInt(s); 
        } catch(NumberFormatException e) { 
            return false; 
        } catch(NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }
}
