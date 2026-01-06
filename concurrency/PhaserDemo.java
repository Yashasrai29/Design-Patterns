package concurrency;

import java.util.concurrent.Phaser;

public class PhaserDemo {

    /**
     * Represents a worker thread that completes three phases of work,
     * synchronizing with other workers and the main thread at each step.
     */
    public static class Worker implements Runnable {

        private final Phaser phaser;
        private final String name;

        public Worker(Phaser phaser, String name) {
            this.phaser = phaser;
            this.name = name;
//            this.phaser.register();
        }

        @Override
        public void run() {
            // --- Phase 0 ---
            System.out.println(name + " starting Phase 0 tasks.");
            // Simulate work
            try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }

            // Arrive and wait for others to complete Phase 0
            phaser.arriveAndAwaitAdvance();
            System.out.println(name + " completed Phase 0. Advancing to Phase " + phaser.getPhase());

            // --- Phase 1 ---
            System.out.println(name + " starting Phase 1 tasks.");
            // Simulate work
            try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }

            // Arrive and wait for others to complete Phase 1
            phaser.arriveAndAwaitAdvance();
            System.out.println(name + " completed Phase 1. Advancing to Phase " + phaser.getPhase());

            // --- Phase 2 (Final Phase) ---
            System.out.println(name + " starting Phase 2 tasks.");
            // Simulate work
            try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }

            // FIX: Use arriveAndDeregister() as the single final synchronization point for Phase 2.
            phaser.arriveAndAwaitAdvance();
            phaser.arriveAndDeregister();
            System.out.println(name + " completed Phase 2 and deregistered.");
        }
    }

    public static void main(String [] args) {
        // Initializing with 3 parties for the three worker threads
        Phaser phaser = new Phaser(3);
        System.out.println("Phaser initialized with 3 parties. Initial phase: " + phaser.getPhase());

        // Create and start worker threads
        new Thread(new Worker(phaser, "Worker 1")).start();
        new Thread(new Worker(phaser, "Worker 2")).start();
        new Thread(new Worker(phaser, "Worker 3")).start();

        // --- Main thread synchronization for Phase 0 ---
        int currentPhase = phaser.getPhase();
        // Main thread waits for the 3 registered workers to complete Phase 0
        phaser.arriveAndAwaitAdvance();
        System.out.println("Main thread: All workers completed Phase " + currentPhase + ". Advancing to Phase " + phaser.getPhase());

        // --- Main thread synchronization for Phase 1 ---
        currentPhase = phaser.getPhase();
        // Main thread waits for the 3 registered workers to complete Phase 1
        phaser.arriveAndAwaitAdvance();
        System.out.println("Main thread: All workers completed Phase " + currentPhase + ". Advancing to Phase " + phaser.getPhase());

        // --- Main thread synchronization for Phase 2 ---
        // FIX: Main thread must wait for the final phase of work (Phase 2).
        currentPhase = phaser.getPhase();
        // Main thread waits for the 3 registered workers to complete Phase 2
        phaser.arriveAndAwaitAdvance();
        System.out.println("Main thread: All workers completed Phase " + currentPhase + ". Advancing to Phase " + phaser.getPhase());

//        phaser.arriveAndDeregister();
        // Main thread is a supervisor, it was not counted in the initial registration.
        // It does not need to deregister.
        System.out.println("Main thread is done supervising. All phases completed. Phaser is terminated: " + phaser.isTerminated());
    }
}