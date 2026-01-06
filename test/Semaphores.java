package test;


import java.util.concurrent.Semaphore;

public class Semaphores {




    public static class SharedResourceAccess {

        private static final int MAX_AVAILABLE_RESOURCES = 3;

        private final Semaphore semaphore = new Semaphore(MAX_AVAILABLE_RESOURCES);



        public void accessResource(String threadName) {

            try {

                System.out.println(threadName + " is trying to acquire a permit.");

                semaphore.acquire(); // Acquire a permit

                System.out.println(threadName + " acquired a permit and is accessing the resource.");

                // Simulate resource usage

                Thread.sleep(4000);

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();

            } finally {

                semaphore.release(); // Release the permit

                System.out.println(threadName + " released the permit.");

            }

        }



        public static void main(String[] args) {

            SharedResourceAccess manager = new SharedResourceAccess();

            for (int i = 0; i < 5; i++) {

                final int threadNum = i;

                new Thread(() -> manager.accessResource("Thread-" + threadNum)).start();

            }

        }

    }

}
