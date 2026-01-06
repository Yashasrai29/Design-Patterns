package behavior_dessign_pattern.visitor;

public class SingleRoom implements Room {

    private Double cost = 1000.0;

    public Double getCost(){
        return this.cost;
    }

    public Double setCost(Double nc){
        this.cost = nc;
        return this.cost;
    }
    @Override
    public void accept(RoomVisitor roomVisitor) {
        roomVisitor.visit(this);
    }

}