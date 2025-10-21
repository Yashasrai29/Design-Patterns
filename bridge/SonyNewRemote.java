package bridge;

public class SonyNewRemote implements Remote{
    @Override
    public void on() {
        System.out.println("turning on using Sony new remote");
    }

    @Override
    public void off() {
        System.out.println("Turing off using Sony new remote");
    }
}
