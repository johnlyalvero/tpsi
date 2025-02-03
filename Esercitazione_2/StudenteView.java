import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class StudenteView extends JFrame {
    private JTextField idField = new JTextField(5);
    private JTextField nomeField = new JTextField(10);
    private JTextField cognomeField = new JTextField(10);
    private JTextField mediaVotiField = new JTextField(5);
    private JTextArea displayArea = new JTextArea(10, 30);
    private JButton addButton = new JButton("Aggiungi");
    private JButton deleteButton = new JButton("Cancella");
    private JButton saveButton = new JButton("Salva");
    private JButton loadButton = new JButton("Carica");

    public StudenteView() {
        setTitle("Gestione Studenti");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("ID:"));
        inputPanel.add(idField);
        inputPanel.add(new JLabel("Nome:"));
        inputPanel.add(nomeField);
        inputPanel.add(new JLabel("Cognome:"));
        inputPanel.add(cognomeField);
        inputPanel.add(new JLabel("Media:"));
        inputPanel.add(mediaVotiField);
        inputPanel.add(addButton);
        inputPanel.add(deleteButton);

        JPanel controlPanel = new JPanel();
        controlPanel.add(saveButton);
        controlPanel.add(loadButton);

        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
    }

    public String getId() { return idField.getText(); }
    public String getNome() { return nomeField.getText(); }
    public String getCognome() { return cognomeField.getText(); }
    public String getMediaVoti() { return mediaVotiField.getText(); }

    public void setDisplayArea(List<Studente> studenti) {
        displayArea.setText("");
        for (Studente s : studenti) {
            displayArea.append(s + "\n");
        }
    }

    public void addAddButtonListener(ActionListener listener) { addButton.addActionListener(listener); }
    public void addDeleteButtonListener(ActionListener listener) { deleteButton.addActionListener(listener); }
    public void addSaveButtonListener(ActionListener listener) { saveButton.addActionListener(listener); }
    public void addLoadButtonListener(ActionListener listener) { loadButton.addActionListener(listener); }
}