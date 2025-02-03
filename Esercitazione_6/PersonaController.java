import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class PersonaController {
    private PersonaView view;

    public PersonaController(PersonaView view, JButton loadButton) {
        this.view = view;
        
        // Aggiungi il listener al pulsante "Carica"
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onLoadButtonClick();
            }
        });
    }

    // Metodo per gestire il clic sul pulsante "Carica"
    public void onLoadButtonClick() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(view);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String fileName = selectedFile.getName().toLowerCase();

            try {
                List<Persona> persone;
                if (fileName.endsWith(".csv")) {
                    PersonaCSVDAO csvDao = new PersonaCSVDAO(selectedFile.getAbsolutePath());
                    persone = csvDao.findAll();
                } else if (fileName.endsWith(".xml")) {
                    PersonaXMLDAO xmlDao = new PersonaXMLDAO(selectedFile.getAbsolutePath());
                    persone = xmlDao.findAll();
                } else if (fileName.endsWith(".json")) {
                    PersonaJSONDAO jsonDao = new PersonaJSONDAO(selectedFile.getAbsolutePath());
                    persone = jsonDao.findAll();
                } else {
                    throw new IllegalArgumentException("Formato file non supportato");
                }

                // Visualizza i dati delle persone nell'area di testo della vista
                StringBuilder content = new StringBuilder();
                for (Persona persona : persone) {
                    content.append(persona).append("\n");
                }
                view.setTextAreaContent(content.toString());

            } catch (IOException | IllegalArgumentException ex) {
                view.showErrorDialog("C'e' un problema");
            }
        }
    }
}
