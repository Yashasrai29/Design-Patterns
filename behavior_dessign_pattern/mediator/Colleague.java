package behavior_dessign_pattern.mediator;

public interface Colleague {


    void placeBid(Double amount);
    void receiveNotification(Colleague colleague, Double amount);

    String getName();
}
