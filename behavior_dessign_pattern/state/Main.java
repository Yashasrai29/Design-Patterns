package behavior_dessign_pattern.state;

public class Main {
    public static void main(String [] args){
        Context context = new Context();
        State on = new OnState();
        State off = new OffState();
        on.set(context);
        System.out.println("? "+(context.state instanceof OnState));
//        context.setState(off);

        System.out.println("? "+(context.state instanceof OffState));

    }
}
