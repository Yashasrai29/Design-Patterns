package behavior_dessign_pattern.mediator;

import java.util.ArrayList;
import java.util.List;

public class AuctionMediator {

    private List<Colleague> colleagueList;


    Double currentPrice;

    Colleague colleague;

    public AuctionMediator(Double initialBidAmount){
        this.colleagueList = new ArrayList<>();
        this.currentPrice = initialBidAmount;
        this.colleague = null;
    }

    public void addBidder(Colleague colleague){
        colleagueList.add(colleague);
    }

    public synchronized void placeBid(Colleague colleague1, Double amount){
        if(amount < currentPrice){
            throw new IllegalArgumentException("bid price cannot be less");
        }
        if(!colleagueList.contains(colleague1)){
            colleagueList.add(colleague1);
        }
        this.colleague = colleague1;
        this.currentPrice = amount;
        for(Colleague each : colleagueList){
            if(colleague1 != each){
                colleague1.receiveNotification(each, currentPrice);
            }
        }
    }

    public String finalBid(){
        return "Bidder "+colleague.getName()+" with bid of "+currentPrice;
    }
}
