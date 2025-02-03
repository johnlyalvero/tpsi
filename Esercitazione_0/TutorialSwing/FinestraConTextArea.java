import javax.swing.*;
	public class FinestraConTextArea {
		public static void main(String[] args) {
		// Creiamo la finestra
		JFrame finestra = new JFrame("Finestra con JTextArea");
		finestra.setSize(400, 300);
		finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Creiamo una JTextArea
		JTextArea areaTesto = new JTextArea(5, 30); // 5 righe e 30 colonne
		// Creiamo uno JScrollPane per permettere lo scorrimento
		JScrollPane scrollPane = new JScrollPane(areaTesto);
		finestra.add(scrollPane); // Aggiungiamo l'area testo dentro uno scroll pane
		// Rendiamo la finestra visibile
		finestra.setVisible(true);
	}
}