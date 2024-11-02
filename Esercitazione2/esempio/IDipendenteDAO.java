import java.util.ArrayList;

public interface IDipendenteDAO{
	
	public void salvaDipendente(Dipendente dipendente);
	public void cancellaDipendente(int matricola);
	public ArrayList<Dipendente> getAllDipendenti();
	public Dipendente getDipendente(int matricola);
	
}
