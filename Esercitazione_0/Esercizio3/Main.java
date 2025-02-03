public class Main {
    public static void main(String[] args) {
        BabboNatale babbo = BabboNatale.getInstance();
        Thread[] t = new Thread[4];
        for(int i=0;i<4;i++)
            t[i] = new Thread(new Bimbo(babbo));
    
        for(int i=0;i<4;i++)
            t[i].start();
    }
}
