package behavior_dessign_pattern.state;

public class OnState implements State{

    @Override
    public void set(Context context) {
        System.out.println("turning to on state");
        context.setState(this);
    }
}
