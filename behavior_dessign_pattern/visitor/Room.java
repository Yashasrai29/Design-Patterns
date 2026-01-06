package behavior_dessign_pattern.visitor;

public interface Room {

    void accept(RoomVisitor roomVisitor);
}
