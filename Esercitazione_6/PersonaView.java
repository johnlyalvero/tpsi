import javax.swing.*;
import java.awt.*;

public class PersonaView extends JFrame {
    private JButton loadButton;
    private JTextArea textArea;
    private PersonaController controller;

    public PersonaView() {
        // Impostazioni della finestra
        setTitle("File Loader");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Inizializzazione componenti
        loadButton = new JButton("Carica");
        textArea = new JTextArea(12,33);
        textArea.setEditable(false);
        textArea.setLineWrap(true);

        // Layout dell'interfaccia
        JPanel panel = new JPanel();
		panel.add(new JScrollPane(textArea));
        panel.add(loadButton);
        add(panel);

        // Crea il controller, passandogli il riferimento al pulsante "Carica"
        controller = new PersonaController(this, loadButton);
    }

    public void setTextAreaContent(String content) {
        textArea.setText(content);
    }

    public void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(this, message, "Problema", JOptionPane.ERROR_MESSAGE);
    }
}
