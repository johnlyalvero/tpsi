import javax.swing.*;

public class Main{
	
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DipendenteView view = new DipendenteView();
            view.setVisible(true);
        });
    }	
	
}