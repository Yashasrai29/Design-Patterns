package concurrency;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {


    public static class CountLatch extends Thread {

        private CountDownLatch latch;
        public CountLatch(CountDownLatch latch){
            this.latch = latch;
        }
        @Override
        public void run() {
            try{
                Thread.sleep(1000);
                System.out.println("latch name "+latch.getCount());
                latch.countDown();
                System.out.println("time stamp "+ LocalDateTime.now().toString());
            }catch (Exception e){

            }
        }
    }

    public static void main(String [] args){

        CountDownLatch latch = new CountDownLatch(2);

        CountLatch l1 = new CountLatch(latch);

        CountLatch l2 = new CountLatch(latch);
        l1.start();
        l2.start();
        try {
            latch.await();
            System.out.println("latch executed successfully");
        }catch (Exception e){

        }
    }
}
