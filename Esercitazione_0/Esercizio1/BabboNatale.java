//Singletong Lazy implementation
public class BabboNatale{
    private static BabboNatale babboNatale; 
    private int regaliAttuali;

    private BabboNatale(int regaliAttuali){
        this.regaliAttuali = regaliAttuali;
    }

    public synchronized static BabboNatale getInstance(){
        if(babboNatale == null)
            babboNatale = new BabboNatale(5);
        return babboNatale;
    }

    public void distribuisciRegali(){
        if(this.regaliAttuali!=0){
            this.regaliAttuali--;
            System.out.println("Babbo Natale ha ancora " + this.regaliAttuali + " regali");
        } else{
            System.out.println("Babbo Natale ha terminato i regali");
        }
    }
}