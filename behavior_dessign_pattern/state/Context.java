package behavior_dessign_pattern.state;

public class Context {
    State state;

    public Context(){
        this.state = new OffState();
    }

    public void setState(State state){
        this.state = state;
    }
}
