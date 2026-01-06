package bridge;

public class Main {
    public static void main(String [] args){

        Remote newRemote = new SonyNewRemote();
        Remote oldRemote = new SonyOldRemote();

        TV tv = new Sony(newRemote);
        tv.on();
        tv.off();

        TV tv1 = new Sony(oldRemote);
        tv1.on();
        tv1.off();

    }
}
