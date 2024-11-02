public class Thread implements Runnable{
    
    private BabboNatale babbo;

    public Thread(BabboNatale babbo){
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
