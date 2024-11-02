import java.io.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DipendenteController implements ActionListener{
	
	private JButton aggiungiButton;
	private JButton rimuoviButton;
	private JButton caricaButton;
	private JButton salvaButton;
	private JTextArea textArea; 
	private JTextField inputField; 
	private DipendenteDAOImpl dipendenteDAO;
	private ArrayList<Dipendente> dipendenti;
	
	public DipendenteController(JButton aggiungiButton, JButton rimuoviButton, JButton caricaButton, JButton salvaButton, JTextArea textArea, JTextField inputField){
		
	    this.aggiungiButton = aggiungiButton;
		this.rimuoviButton = rimuoviButton;
		this.caricaButton = caricaButton;
		this.salvaButton = salvaButton;
		this.textArea = textArea;
		this.inputField = inputField;
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
	    Object source = e.getSource();
		
		if(source == aggiungiButton)
			aggiungiDipendente();
		
	    if(source == rimuoviButton)
		    rimuoviDipendente();
	
		if(source == salvaButton)
            salvaDipendenti();
			
		if(source == caricaButton)
		    caricaDipendenti();
	}

    private void rimuoviDipendente(){
		dipendenti.removeIf(d -> d.getMatricola() == Integer.parseInt(inputField.getText()));
		refreshTextArea();
	}
	
    private void salvaDipendenti(){
	    JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(new JFrame());
        if (result == JFileChooser.APPROVE_OPTION) {
           File selectedFile = fileChooser.getSelectedFile();
		   try{
		       selectedFile.createNewFile();
               this.dipendenteDAO = new DipendenteDAOImpl(selectedFile.getAbsolutePath(),dipendenti);
               this.dipendenteDAO.salvaDipendenti(dipendenti);
		   }catch(Exception e){
			   e.printStackTrace();
		   }
        }
	
    }
	
    private void caricaDipendenti(){
		JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(new JFrame());
        if (result == JFileChooser.APPROVE_OPTION) {
           File selectedFile = fileChooser.getSelectedFile();
           this.dipendenteDAO = new DipendenteDAOImpl(selectedFile.getAbsolutePath());
		   this.dipendenti = dipendenteDAO.getAllDipendenti();
           refreshTextArea();
        }
    }
	
    private void aggiungiDipendente(){
		
        String input = inputField.getText();
        
        if (!input.isEmpty()) {
		    StringTokenizer tokenizer = new StringTokenizer(input, ",");
                if(tokenizer.countTokens() == 4) {
                    String nome = tokenizer.nextToken();
                    String cognome = tokenizer.nextToken();
                    int matricola = Integer.parseInt(tokenizer.nextToken());
                    float stipendio = Float.parseFloat(tokenizer.nextToken().replace(" euro",""));
                    Dipendente dipendente = new Dipendente(nome, cognome, stipendio, matricola);
                    dipendenti.add(dipendente);
                }			
            inputField.setText("");
            refreshTextArea();
        }	
    }

    
    private void refreshTextArea() {
		String dipendentiString = "";
		textArea.setText(dipendentiString);
		for(Dipendente dipendente: dipendenti)
		   dipendentiString = dipendentiString+dipendente+"\n";
	    // System.out.println(dipendentiString); DEBUG
	    textArea.setText(dipendentiString);
    }		
	
	
}