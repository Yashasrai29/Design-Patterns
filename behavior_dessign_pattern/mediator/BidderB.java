package behavior_dessign_pattern.mediator;

public class BidderB implements Colleague {

    private AuctionMediator auctionMediator;

    public BidderB(AuctionMediator mediator) {
        this.auctionMediator = mediator;
    }

    @Override
    public void placeBid(Double amount) {
        auctionMediator.placeBid(this, amount);
    }

    @Override
    public void receiveNotification(Colleague colleague, Double amount) {
        System.out.println("BidderB received new bid from "+colleague.getName()+ " of bid amount : "+amount);
    }

    @Override
    public String getName() {
        return "BidderB";
    }
}