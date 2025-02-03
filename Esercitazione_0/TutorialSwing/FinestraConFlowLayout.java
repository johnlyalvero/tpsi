import javax.swing.*;
import java.awt.*;
public class FinestraConFlowLayout {
    public static void main(String[] args) {
        JFrame finestra = new JFrame("Finestra con Layout");
        finestra.setSize(400, 300);
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Impostiamo il Flowlayout
        finestra.setLayout(new FlowLayout());
        // Aggiungiamo 4 pulsanti
        finestra.add(new JButton("Pulsante 1"));
        finestra.add(new JButton("Pulsante 2"));
        finestra.add(new JButton("Pulsante 3"));
        finestra.add(new JButton("Pulsante 4"));
        finestra.setVisible(true);
    }
}