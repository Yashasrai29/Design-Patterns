package test.test2;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantLock;

public class Problem {


    public static class WorkerA extends Thread{
        private int val;
        private CyclicBarrier cyclicBarrier;
        public WorkerA(int val, CyclicBarrier cyclicBarrier){
            this.val = val;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run(){
            try {
                cyclicBarrier.await();
                System.out.println((val%2==0 ? "EVEN" : "ODD" )+"-"+val);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public static void main(String [] args) {

        ReentrantLock lock = new ReentrantLock(true);
        new Thread(() -> {
            for(int i = 1; i <= 10; i++){
                try{
                    lock.lock();
                    Thread.sleep(500);
                    if(i % 2 == 0){
                        System.out.println("even-"+i);
                    }
                }catch(Exception e){

                }
                finally{
                    lock.unlock();
                }
            }
        }).start();

        new Thread(() -> {
            for(int i = 1; i <= 10; i++){
                try{
                    lock.lock();
                    Thread.sleep(500);
                    if(i % 2 != 0){
                        System.out.println("odd-"+i);
                    }
                }catch(Exception e){

                }
                finally{
                    lock.unlock();
                }
            }
        }).start();
//        CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
//        for(int i = 1; i <= 10; i += 2 ) {
//            WorkerA w1 = new WorkerA(0+i, cyclicBarrier);
//            WorkerA w2 = new WorkerA(1+i, cyclicBarrier);
//            w1.start();
//            w2.start();
//        }
//        for(int i = 2; i <= 10; i += 2) {
//
//        }
//        SharedResource sharedResource = new SharedResource();
//        new Thread(() -> {
//           for(int i = 1 ; i <= 5 ; i++){
//               try {
//                   sharedResource.produce();
//               }catch (InterruptedException e){
//
//               }
//           }
//        }).start();
//
//        new Thread(() -> {
//            for(int i = 1 ; i <= 5 ; i++){
//                try {
//                    sharedResource.consume();
//                }catch (InterruptedException e){
//
//                }
//            }
//        }).start();
//        for(int i = 1 ; i <= 10 ; i++){
//            System.out.println((i%2==0 ? "EVEN" : "ODD" )+"-"+i);
//        }




    }
}
