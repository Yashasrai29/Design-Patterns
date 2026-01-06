package behavior_dessign_pattern.visitor;

public class Main {

    public static void main(String [] args){
        SingleRoom singleRoom = new SingleRoom();
        DoubleRoom doubleRoom = new DoubleRoom();
        DuplexRoom duplexRoom = new DuplexRoom();
        PriceDescriptionVisitor priceDescriptionVisitor = new PriceDescriptionVisitor();
        singleRoom.accept(priceDescriptionVisitor);
        doubleRoom.accept(priceDescriptionVisitor);
        duplexRoom.accept(priceDescriptionVisitor);

        RoomPricingVisitor roomPricingVisitor = new RoomPricingVisitor();

        singleRoom.accept(roomPricingVisitor);
        doubleRoom.accept(roomPricingVisitor);
        duplexRoom.accept(roomPricingVisitor);
    }
}
