package concurrency;

import java.time.LocalDateTime;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {


    public static class Work extends Thread{
        private CyclicBarrier cyclicBarrier;

        public Work(CyclicBarrier cyclicBarrier){
            this.cyclicBarrier = cyclicBarrier;
        }
        @Override
        public void run() {
            try{
                Thread.sleep(2000);
                cyclicBarrier.await();
                System.out.println("barrier name time"+ LocalDateTime.now().toString());
            }catch (Exception e){

            }
        }
    }
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        Work w1 = new Work(cyclicBarrier);
        Work w2 = new Work(cyclicBarrier);
        Work w3 = new Work(cyclicBarrier);
        w1.start();
        w2.start();
        w3.start();
    }
}
