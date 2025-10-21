package lock;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.ArrayBlockingQueue;

public class Lock {

    private static final ReentrantLock lock = new ReentrantLock(true); // Fair lock

    private static Integer value = 0;

    public static void criticalSection(String name, Integer count) {
        try {
            lock.lock();
            System.out.println(name + " acquired the lock.");
            System.out.println("previous value "+value);
            value = count;
            Thread.sleep(3000); // Simulate some work
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(name + " released the lock. ");
            lock.unlock();
        }
    }
}
