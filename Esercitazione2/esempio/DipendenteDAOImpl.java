import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DipendenteDAOImpl implements IDipendenteDAO{
	
    private ArrayList<Dipendente> dipendenti;
    private String fileName;

    public DipendenteDAOImpl(String fileName) {
        this.fileName = fileName;
        this.dipendenti = new ArrayList<Dipendente>();
        caricaDipendenti();
    }

    public DipendenteDAOImpl(String fileName,ArrayList<Dipendente> dipendenti){
	    this.fileName = fileName;
        this.dipendenti = dipendenti;		
	}
	
    public Dipendente getDipendente(int matricola){
		for(Dipendente dipendente : dipendenti) {
            if(dipendente.getMatricola() == matricola) {
                return dipendente;
            }
        }
        return null; 
	}
	
	public void salvaDipendenti(ArrayList<Dipendente> dipendenti){
	    this.dipendenti = dipendenti;
		salvaDipendenti();
	}
	
    public void salvaDipendente(Dipendente dipendente) {
        dipendenti.add(dipendente);
        salvaDipendenti();
    }

    public void cancellaDipendente(int matricola) {
        dipendenti.removeIf(d -> d.getMatricola() == matricola);
        salvaDipendenti();
    }

    public ArrayList<Dipendente> getAllDipendenti() {
        return dipendenti;
    }

    private void caricaDipendenti() {
        try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName)); 
            String line;
            while((line = reader.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line, ",");
                if(tokenizer.countTokens() == 4) {
                    String nome = tokenizer.nextToken();
                    String cognome = tokenizer.nextToken();
                    int matricola = Integer.parseInt(tokenizer.nextToken());
                    float stipendio = Float.parseFloat(tokenizer.nextToken().replace(" euro",""));
                    Dipendente dipendente = new Dipendente(nome, cognome, stipendio, matricola);
                    dipendenti.add(dipendente);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void salvaDipendenti() {
        try {
			PrintWriter writer = new PrintWriter(new FileWriter(fileName)); 
            for(Dipendente dipendente : dipendenti) {
                writer.println(dipendente.getNome()+","+dipendente.getCognome()+","+dipendente.getMatricola()+","+dipendente.getStipendio()+" euro");
            }
			writer.flush();
			writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
