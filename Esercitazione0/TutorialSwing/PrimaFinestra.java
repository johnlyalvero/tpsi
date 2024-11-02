import javax.swing.JFrame;

public class PrimaFinestra {
	public static void main(String[] args) {
		// Creiamo un oggetto JFrame
		JFrame finestra = new JFrame("La mia prima finestra");
		// Definiamo la dimensione della finestra (larghezza, altezza)
		finestra.setSize(400, 300);
		// Specifica cosa fare quando si chiude la finestra (terminare il programma)
		finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Rendiamo la finestra visibile
		finestra.setVisible(true);
	}
}

