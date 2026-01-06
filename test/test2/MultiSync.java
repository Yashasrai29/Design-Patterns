package test.test2;

import java.util.concurrent.locks.ReentrantLock;

public class MultiSync {

    public static int data = 0;

    public static class MyTask extends Thread {

        private ReentrantLock lock;
        private String name;
        public MyTask(ReentrantLock lock, String name) {
            this.lock = lock;
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 1; i < 6; i++) {
                try {
                    lock.lock();
                    data += 1;
                    System.out.println((data % 2 == 0 ? "EVEN" : "ODD") + "-" + data+" thread-"+name);
                    Thread.sleep(500);
                } catch (Exception e) {

                } finally {
                    lock.unlock();
                }
            }
        }
    }
    public static void main(String [] args){

        ReentrantLock lock = new ReentrantLock(true);
        MyTask t1 = new MyTask(lock, "t1");
        MyTask t2 = new MyTask(lock, "t2");
        t1.start();
        t2.start();
    }
}
