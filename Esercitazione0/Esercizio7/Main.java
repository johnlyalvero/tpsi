package tpsi.esercitazioni.Esercitazione0.Esercizio7;

import javax.swing.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {
		// Creiamo la finestra
		JFrame finestra = new JFrame("Esercitazione 0, Esercizio 7");
		finestra.setSize(800, 400);
		finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Specifica cosa fare quando si chiude la finestra (terminare il programma)
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Creiamo una JLabel
		JLabel etichetta = new JLabel("Non hai cliccato il pulsante");
		// Creiamo un pulsante
		JButton bottone = new JButton("Cliccami!");
        
        // Aggiungiamo un listener per catturare l'evento di click
		bottone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                etichetta.setText("Hai cliccato il pulsante!");
			}
		});

		// Aggiungiamo gli elementi
        JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		panel.add(etichetta);
		panel.add(bottone);

        // Aggiungiamo il layout creato
        finestra.add(panel);
		// Rendiamo la finestra visibile
		finestra.setVisible(true);
    }
}
