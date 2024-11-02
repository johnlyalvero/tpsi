package Esercitazione2;

import javax.swing.*;
import java.awt.*;

public class StudenteView extends JFrame{    // estende la classe per creare le finestre


   public StudenteView() {
		
      setTitle("Geotione Anagrafica Studenti");
      setSize(500, 400);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // Creo i pulsanti
      JButton aggiungiButton = new JButton("Aggiungi");
      JButton rimuoviButton = new JButton("Rimuovi ");
      JButton salvaButton = new JButton("Salva");
      JButton caricaButton = new JButton("Carica ");
      
      // Definisco il pannello box
		JPanel boxPanel_1 = new JPanel();
		boxPanel_1.setLayout(new BoxLayout(boxPanel_1, BoxLayout.Y_AXIS));

		JPanel boxPanel_2 = new JPanel();
		boxPanel_2.setLayout(new BoxLayout(boxPanel_2, BoxLayout.Y_AXIS));
		
      // Aggiungo i bottoni nel pannello box
      boxPanel_1.add(aggiungiButton);
      boxPanel_1.add(rimuoviButton);

      boxPanel_2.add(salvaButton);
      boxPanel_2.add(caricaButton);

      // Aggiungo gli elementi nella finestra
   }

}  
