package behavior_dessign_pattern.observer;

public class Main {
    public static void main(String [] args){
        NewsAgency newsAgency = new NewsAgency();
        AajTakChannel aajTakChannel = new AajTakChannel();
        RepublicTV republicTV = new RepublicTV();
        newsAgency.addChannel(aajTakChannel);
        newsAgency.addChannel(republicTV);
        newsAgency.addNews("supreme court withdrawing the aravali judgement");
    }
}
