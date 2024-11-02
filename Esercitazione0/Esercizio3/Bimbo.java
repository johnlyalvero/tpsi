public class Bimbo implements Runnable{
    
    private BabboNatale babbo;

    public Bimbo(BabboNatale babbo){
        this.babbo = babbo;
    }

    @Override
    public void run(){
        try {
            babbo.distribuisciRegali();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
