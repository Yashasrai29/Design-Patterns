package concurrency;

import java.util.concurrent.SynchronousQueue;

public class Exchange {


    public static void main(String[] args) {
        SynchronousQueue<Integer> queue = new SynchronousQueue<>();

        new Thread(() -> {
           for(int i = 1; i < 5; i++){
               try {
                   Thread.sleep(1000);
                   System.out.println("producing "+i);
                   queue.put(i);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
        }).start();


        new Thread(() -> {
            for(int i = 1; i < 5; i++){
                try {
                    int take = queue.take();

                    Thread.sleep(500);
                    System.out.println("consuming "+take);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

    }
}