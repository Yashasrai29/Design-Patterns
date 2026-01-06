package behavior_dessign_pattern.visitor;

public class DoubleRoom implements Room{

    private Double cost = 2000.0;


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
