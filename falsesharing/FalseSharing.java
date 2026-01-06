package falsesharing;

import jdk.internal.vm.annotation.Contended;
public class FalseSharing {
    public static class Sharing{
//        @Contended
//        volatile long count1 = 0;
//        @Contended
//        volatile
        long count2 = 0;

        long l1, l2, l3, l4, l5 , l6, l7;
        public Sharing(){

        }
    }

    public static void main(String [] args) throws InterruptedException {
        Sharing sharing = new Sharing();
        Sharing sharing2 = new Sharing();

        long start = System.currentTimeMillis();

        Thread t1 = new Thread(() -> {
            for(int i = 0; i < 1_000_000_000; i++){
                sharing.count2 = i;
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i = 0; i < 1_000_000_000; i++){
                sharing2.count2 = i;
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        long end = System.currentTimeMillis();
        System.out.println("time elasped is "+(end - start));
    }
}
