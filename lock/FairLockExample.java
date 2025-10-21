package lock;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class FairLockExample {



    public static void main(String[] args) {
        FairLockExample example = new FairLockExample();
        Lock lock = new Lock();

//        ReadWriteLock readWriteLock = new ReadWriteLock();
        // Create multiple threads
//        Runnable task = example::criticalSection;
//        for (int i = 1; i <= 5; i++) {
////            new Thread(task, "Thread-" + i).start();
//
//            int temp = i;
//            try(var executor = Executors.newVirtualThreadPerTaskExecutor()){
//                executor.submit(() -> {
//                    lock.criticalSection("Thread-" + temp, temp);
//                });
//            }
//        }

        ReadWriteLock.write("vuhusbxbubuhbsuxhbscuhbubuhsbuhbkkmnamk nicbiubw");

//        for (int i = 0; i <= 5; i++) {
////            new Thread(task, "Thread-" + i).start();
//
//            int temp = i;
//            try(var executor = Executors.newVirtualThreadPerTaskExecutor()){
//                executor.submit(ReadWriteLock::read);
//            }
//        }
    }
}

