package test;

import java.util.concurrent.locks.ReentrantLock;

public class WissenR2 {

        public static class Task{
            private volatile Integer count;

            private ReentrantLock lock;

            public Task(){
                this.count = 0;
                this.lock = new ReentrantLock(true);
            }

            public void increment(){
                try{
                    lock.lock();
                    count++;
                    System.out.println("count "+count+" "+(count%2 == 0 ? "EVEN" : "ODD")+ " "+Thread.currentThread().getName());

                }
                catch(Exception e){

                }
                finally{
                    lock.unlock();
                }
            }


        }

        public static void main(String[] args) {
            Task task = new Task();
            Thread t1 = new Thread(() -> {
                for(int i = 0; i < 5; i++){
                    task.increment();
                }
            });

            Thread t2 = new Thread(() -> {
                for(int i = 0; i < 5; i++){
                    task.increment();
                }
            });

            t1.start();

            t2.start();

            try{

                t1.join();
                t2.join();
            }catch(Exception e){

            }
        }

}
