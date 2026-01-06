package behavior_dessign_pattern.mediator;

public class Main {

    public static void main(String [] args){
        AuctionMediator mediator = new AuctionMediator(12000.0);
        BidderA bidderA = new BidderA(mediator);
        BidderB bidderB = new BidderB(mediator);
        mediator.addBidder(bidderA);
        mediator.addBidder(bidderB);
        bidderA.placeBid( 12700.0);
        bidderB.placeBid( 13500.0);
        System.out.println("final bid " + mediator.finalBid());
    }
}
