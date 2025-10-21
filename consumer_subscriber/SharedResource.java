package consumer_subscriber;
class SharedResource {
    private int data;
    private boolean hasData = false;

    public synchronized void produce(int value) throws InterruptedException {
        while (hasData) {
            wait(); // wait until consumer consumes
        }
        data = value;
        hasData = true;
        System.out.println("Produced: " + data);
        notify(); // wake up consumer
    }

    public synchronized int consume() throws InterruptedException {
        while (!hasData) {
            wait(); // wait until producer produces
        }
        hasData = false;
        System.out.println("Consumed: " + data);
        notify(); // wake up producer
        return data;
    }
}

