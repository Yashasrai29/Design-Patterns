package behavior_dessign_pattern.visitor;

public interface RoomVisitor {

    void visit(SingleRoom singleRoom);
    void visit(DoubleRoom doubleRoom);
    void visit(DuplexRoom duplexRoom);

}
