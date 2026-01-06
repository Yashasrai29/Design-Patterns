package test.test2;

public class SharedResource {

    private boolean hasData;

    public SharedResource(){
        this.hasData = false;
    }
    public synchronized void produce() throws InterruptedException{
        while(hasData){
            wait();
        }
        System.out.println("odd");
        hasData = true;
        notify();
    }

    public synchronized void consume() throws InterruptedException{
        while(!hasData){
            wait();
        }
        System.out.println("even");
        hasData = false;
        notify();
    }
}
