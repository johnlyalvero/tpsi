import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinestraConEvento {
	public static void main(String[] args) {
		JFrame finestra = new JFrame("Finestra con Evento");
		finestra.setSize(400, 300);
		finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton bottone = new JButton("Cliccami!");
		// Aggiungiamo un listener per catturare l'evento di click
		bottone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Hai cliccato il pulsante!");
			}
		});
		finestra.add(bottone);
		finestra.setVisible(true);
	}
}