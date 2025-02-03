import javax.swing.*;
import java.awt.*;
public class FinestraConBorderLayout {
    public static void main(String[] args) {
        JFrame finestra = new JFrame("Finestra con Layout");
        finestra.setSize(400, 300);
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Impostiamo il layout a BorderLayout
        finestra.setLayout(new BorderLayout());
        // Aggiungiamo 4 pulsanti
        finestra.add(new JButton("Pulsante 1"),BorderLayout.NORTH);
        finestra.add(new JButton("Pulsante 2"),BorderLayout.SOUTH);
        finestra.add(new JButton("Pulsante 3"),BorderLayout.EAST);
        finestra.add(new JButton("Pulsante 4"),BorderLayout.WEST);
        finestra.setVisible(true);
    }
}