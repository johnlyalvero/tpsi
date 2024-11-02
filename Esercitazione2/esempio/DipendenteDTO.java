public class DipendenteDTO{
    
    private String nome;
    private String cognome;
    private int matricola;
	
	public DipendenteDTO(String nome,String cognome,int matricola){

        this.nome = nome;
		this.cognome = cognome;
		this.matricola = matricola;
		
    }	

    public String getNome(){
        return this.nome;
    }

    public String getCognome(){
        return this.cognome;
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
}