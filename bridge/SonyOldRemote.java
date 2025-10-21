package bridge;

public class SonyOldRemote implements Remote{
    @Override
    public void on() {
        System.out.println("Turing on using Sony old remote");
    }

    @Override
    public void off() {
        System.out.println("Turing off using Sony old remote");
    }
}
