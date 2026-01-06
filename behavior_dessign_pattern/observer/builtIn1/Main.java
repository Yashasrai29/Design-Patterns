package behavior_dessign_pattern.observer.builtIn1;

public class Main {

    public static void main(String [] args){
        TopNewsAgency agency = new TopNewsAgency();
        AChannel aChannel = new AChannel();
        BChannel bChannel = new BChannel();
        agency.addObserver(aChannel);
        agency.addObserver(bChannel);
        agency.setNews("Happy new Year");
    }
}
