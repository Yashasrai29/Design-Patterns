package consumer_subscriber;

public class AsyncProcessor {

    private int data;
    private boolean hasData = false;

    private int consumers = 0;

    private final static int count = 3;

    public synchronized void produce(int value) throws InterruptedException {
        while (hasData) {
            wait(); // wait until consumer consumes
        }
        data = value;
        hasData = true;
        consumers = 0;
        System.out.println("Produced: " + data);
        notifyAll(); // wake up consumer
    }

    public synchronized int consume() throws InterruptedException {
        while (!hasData) {
            wait(); // wait until producer produces
        }
//        System.out.println("1 : Consumed: " + data);
        consumers++;
        if(consumers == count) {
            hasData = false;
        }
        notifyAll(); // wake up producer
        return data;
    }


}
