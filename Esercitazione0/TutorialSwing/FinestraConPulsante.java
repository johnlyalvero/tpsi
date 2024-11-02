import javax.swing.JButton;
import javax.swing.JFrame;

public class FinestraConPulsante {
	public static void main(String[] args) {
		// Creiamo la finestra
		JFrame finestra = new JFrame("Finestra con Pulsante");
		finestra.setSize(400, 300);
		finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Creiamo un pulsante
		JButton bottone = new JButton("Cliccami!");
		// Aggiungiamo il pulsante alla finestra
		finestra.add(bottone);
		// Rendiamo la finestra visibile
		finestra.setVisible(true);
	}
}