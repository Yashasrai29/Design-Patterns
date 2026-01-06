package behavior_dessign_pattern.visitor;

public class RoomPricingVisitor implements RoomVisitor{
    @Override
    public void visit(SingleRoom singleRoom) {
//        return singleRoom;
    }

    @Override
    public void visit(DoubleRoom doubleRoom) {
//        return doubleRoom;
    }

    @Override
    public void visit(DuplexRoom duplexRoom) {
//        return duplexRoom;
    }
}
