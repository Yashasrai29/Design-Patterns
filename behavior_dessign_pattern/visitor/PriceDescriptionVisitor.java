package behavior_dessign_pattern.visitor;

public class PriceDescriptionVisitor implements RoomVisitor{
    @Override
    public void visit(SingleRoom singleRoom) {
//        return singleRoom.setCost();
    }

    @Override
    public void visit(DoubleRoom doubleRoom) {
//        return null;
    }

    @Override
    public void visit(DuplexRoom duplexRoom) {
//        return null;
    }
}
