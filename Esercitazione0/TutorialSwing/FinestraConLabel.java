import javax.swing.*;
public class FinestraConLabel {
	public static void main(String[] args) {
		// Creiamo la finestra
		JFrame finestra = new JFrame("Finestra con JLabel");
		finestra.setSize(400, 200);
		finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Creiamo una JLabel
		JLabel etichetta = new JLabel("Questa è una semplice etichetta.");
		// Aggiungiamo la JLabel alla finestra
		finestra.add(etichetta);
		// Rendiamo la finestra visibile
		finestra.setVisible(true);
	}
}