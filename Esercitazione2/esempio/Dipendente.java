public class Dipendente{
    
    private String nome;
    private String cognome;
    private float stipendio;
	private int matricola;
	
	public Dipendente(String nome,String cognome,float stipendio, int matricola){

        this.nome = nome;
		this.cognome = cognome;
		this.stipendio = stipendio;
		this.matricola = matricola;
		
    }	

    public String getNome(){
        return this.nome;
    }

    public String getCognome(){
        return this.cognome;
    }		
	
	public float getStipendio(){
	    return this.stipendio;	
	}
	
	public int getMatricola(){
	    return this.matricola;	
	}
	
	public void setNome(String nome){
	    this.nome = nome;	
	}
	
	public void setCognome(String cognome){
	    this.cognome = cognome;	
	}
	
	public void setMatricola(int matricola){
	    this.matricola = matricola;	
	}
	
	public void setStipendio(float stipendio){
	    this.stipendio = stipendio;	
	}
	
	public String toString(){
	    return this.nome+" "+this.cognome+" "+this.matricola+" "+this.stipendio+" euro";	
	}
}