import javax.swing.*;
public class FinestraConTextField {
	public static void main(String[] args) {
		// Creiamo la finestra
		JFrame finestra = new JFrame("Finestra con JTextField");
		finestra.setSize(400, 200);
		finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Creiamo un JTextField
		JTextField campoTesto = new JTextField(20); // Il numero indica la lunghezza
		finestra.add(campoTesto);
		// Rendiamo la finestra visibile
		finestra.setVisible(true);
	}
}