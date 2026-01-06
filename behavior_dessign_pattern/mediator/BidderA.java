package behavior_dessign_pattern.mediator;

public class BidderA implements Colleague{

    private AuctionMediator auctionMediator;

    public BidderA(AuctionMediator mediator){
        this.auctionMediator = mediator;
    }

    @Override
    public void placeBid(Double amount) {
        auctionMediator.placeBid(this, amount);
    }

    @Override
    public void receiveNotification(Colleague colleague, Double amount) {
        System.out.println("BidderA received new bid from "+colleague.getName()+ " of bid amount : "+amount);
    }

    @Override
    public String getName() {
        return "BidderA";
    }
}
