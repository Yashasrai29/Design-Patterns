package bridge;

public class Sony implements TV{

    private Remote remote;
    public Sony(Remote remote){
        this.remote = remote;
    }
    @Override
    public void on() {
        remote.on();
    }

    @Override
    public void off() {
        remote.off();
    }
}
