package lock;

import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLock {

    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
    private static final ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    private static final ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

    private static StringBuilder message = new StringBuilder("Welcome ");


    public static void write(String msg) {
        try {
//            writeLock.lock();
            System.out.println("Writer: Writing started...");
            for (char ch : msg.toCharArray()) {
                try {
                    writeLock.lock();
                    message.append(ch);
                    Thread.sleep(500); // Simulate typing
                } finally {
                    writeLock.unlock();
                }
            }
            System.out.println("Writer: Writing finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    public static void read(String threadId) {
        try {
            while (!Thread.currentThread().isInterrupted()) { // Allow graceful interruption
                readLock.lock();
                try {
                    System.out.println("Reader " + threadId + ": " + message.toString());
                } finally {
                    readLock.unlock();
                }
                Thread.sleep(500); // Simulate reading frequency
            }
        } catch (InterruptedException e) {
            System.out.println("Reader " + threadId + " interrupted.");
            Thread.currentThread().interrupt(); // Restore interrupt flag
        }
    }

    public static void main(String[] args) {
        Thread writer = new Thread(() -> write(" to ReentrantReadWriteLock!"));

        writer.start();

        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 5; i++) {
                int ind = i;
                executor.submit(() -> read("Reader-" + ind));
            }

            // Allow the readers and writer to execute for 10 seconds
//            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Main thread completed.");
    }
}
