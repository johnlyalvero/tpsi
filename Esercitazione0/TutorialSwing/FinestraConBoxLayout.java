import javax.swing.*;
import java.awt.*;

public class FinestraConBoxLayout {
	public static void main(String[] args) {
		JFrame finestra = new JFrame("Finestra con Layout");
		finestra.setSize(400, 300);
		finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Impostiamo il layout a GridLayout (2 righe, 2 colonne)
		
		// Aggiungiamo 4 pulsanti
                JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		panel.add(new JButton("Pulsante 1"));
		panel.add(new JButton("Pulsante 2"));
		panel.add(new JButton("Pulsante 3"));
		panel.add(new JButton("Pulsante 4"));  
        	finestra.add(panel);

		finestra.setVisible(true);
	}
}