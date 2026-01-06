package behavior_dessign_pattern.observer.buitIn2;

public class Main {

    public static void main(String [] args){
        Agency agency = new Agency();
        AListener aListener = new AListener();
        BListener bListener = new BListener();
        agency.addChannel(aListener);
        agency.addChannel(bListener);
        agency.setNews("tomorrow is christmas");
    }
}
