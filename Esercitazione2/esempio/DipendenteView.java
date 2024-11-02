import javax.swing.*;
import java.awt.*;

public class DipendenteView extends JFrame {
	
    private JTextArea textArea;
    private JTextField inputField;

    public DipendenteView() {
		
        setTitle("Geotione Anagrafica Dipendenti");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = new JTextArea(10, 40);
        JScrollPane scrollPane = new JScrollPane(textArea);
        inputField = new JTextField(15);

        JButton aggiungiButton = new JButton("Aggiungi");
		JButton rimuoviButton = new JButton("Rimuovi ");
		JButton caricaButton = new JButton("  Carica ");
		JButton salvaButton = new JButton("   Salva  ");
		
        JPanel panel_0 = new JPanel();
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));

        DipendenteController controller = new DipendenteController(aggiungiButton, rimuoviButton, caricaButton, salvaButton, textArea, inputField);		

        aggiungiButton.addActionListener(controller);
		rimuoviButton.addActionListener(controller);
		caricaButton.addActionListener(controller);
		salvaButton.addActionListener(controller);
		
        panel_0.add(scrollPane);
        panel_1.add(aggiungiButton);
        panel_1.add(rimuoviButton);
        panel_2.add(caricaButton);
        panel_2.add(salvaButton);
        panel_0.add(panel_1);
		panel_0.add(inputField);
		panel_0.add(panel_2);
        add(panel_0);

        
    }

}