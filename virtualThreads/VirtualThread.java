package virtualThreads;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class VirtualThread {

    public static void main(String [] args){

        Runnable runnable = () -> {
           System.out.println("Running Runnable method");
        };

        Thread vt = Thread.ofVirtual().unstarted(runnable);
        vt.start();


        new Thread(() -> {
            try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
                long start = System.currentTimeMillis();
                for (int i = 0; i < 100000; i++) {
                    int finalI = i;
                    executor.submit(() -> {
                        AtomicInteger threadIndex = new AtomicInteger(finalI);
                        for (int j = 0; j < 25; j++) {
                            threadIndex.set(threadIndex.get() + threadIndex.get() * j);
                        }
                        threadIndex = null;

                        System.out.println("Result index " + finalI + " value " + threadIndex.get());
                    });
                }
                System.gc();
//                Map<String, String > map = System.getenv();
//                for(Map.Entry<String, String> entry : map.entrySet()){
//                    System.out.println("key "+entry.getKey() +" value "+ entry.getValue());
//                }
                long end = System.currentTimeMillis();
                System.out.println("execution time is : " + (end - start));
            }
        }).start();

//        new Thread(() -> {
//            try (var executor = java.util.concurrent.Executors.newVirtualThreadPerTaskExecutor()) {
//                long start = System.currentTimeMillis();
//                for (int i = 0; i < 300001; i++) {
//                    int finalI = i;
//                    executor.submit(() -> {
//                        AtomicInteger threadIndex = new AtomicInteger(finalI);
//                        for (int j = 0; j < 25; j++) {
//                            threadIndex.set(threadIndex.get() + threadIndex.get() * j);
//                        }
//                        System.out.println("Result index " + finalI + " value " + threadIndex.get());
//                    });
//                }
//                long end = System.currentTimeMillis();
//                System.out.println("execution time is : " + (end - start));
//            }
//        }).start();
//
//        new Thread(() -> {
//            try (var executor = java.util.concurrent.Executors.newVirtualThreadPerTaskExecutor()) {
//                long start = System.currentTimeMillis();
//                for (int i = 300001; i < 600001; i++) {
//                    int finalI = i;
//                    executor.submit(() -> {
//                        AtomicInteger threadIndex = new AtomicInteger(finalI);
//                        for (int j = 0; j < 25; j++) {
//                            threadIndex.set(threadIndex.get() + threadIndex.get() * j);
//                        }
//                        System.out.println("Result index " + finalI + " value " + threadIndex.get());
//                    });
//                }
//                long end = System.currentTimeMillis();
//                System.out.println("execution time is : " + (end - start));
//            }
//        }).start();
//
//        new Thread(() -> {
//            try (var executor = java.util.concurrent.Executors.newVirtualThreadPerTaskExecutor()) {
//                long start = System.currentTimeMillis();
//                for (int i = 600001; i < 1000000; i++) {
//                    int finalI = i;
//                    executor.submit(() -> {
//                        AtomicInteger threadIndex = new AtomicInteger(finalI);
//                        for (int j = 0; j < 25; j++) {
//                            threadIndex.set(threadIndex.get() + threadIndex.get() * j);
//                        }
//                        System.out.println("Result index " + finalI + " value " + threadIndex.get());
//                    });
//                }
//                long end = System.currentTimeMillis();
//                System.out.println("execution time is : " + (end - start));
//            }
//        }).start();

//        try {
//            t1.start();
//            t1.join();
//        } catch (InterruptedException e){
//            e.printStackTrace();
//        }

//        List<Thread> threadList = new ArrayList<>();
//
//        for(int i = 0 ; i < 100000; i++) {
//            AtomicInteger threadIndex = new AtomicInteger(i);
//            int finalI = i;
//            Thread t1 = Thread.ofVirtual().unstarted(
//                    () -> {
//                        for(int j = 0 ; j < 25; j++){
//                            threadIndex.set(threadIndex.get() + threadIndex.get() * j);
//                        }
//                        System.out.println("result index "+ finalI + " value "+threadIndex.get());
//                    }
//            );
//            threadList.add(t1);
//        }
////        for(int i = 0 ; i < threadList.size() ; i++){
////            try{
////                threadList.get(i).join();
////            }catch (Exception e){
////                e.printStackTrace();
////            }
////        }
//        Thread t1 = new Thread(() -> {
//            long start1 = System.currentTimeMillis();
//            for(int i = 0 ; i < 30001 ; i++){
//                try{
//                    threadList.get(i).start();
//                    threadList.get(i).join();
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
//            long end1 = System.currentTimeMillis();
//            System.out.println("First batch time "+(end1-start1));
//        });
//
//        Thread t2 = new Thread(() -> {
//            long start2 = System.currentTimeMillis();
//            for(int i = 30001 ; i < 60001 ; i++){
//                try{
//                    threadList.get(i).start();
//                    threadList.get(i).join();
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
//
//            long end2 = System.currentTimeMillis();
//            System.out.println("Second batch time "+(end2-start2));
//        });
//
//        Thread t3 = new Thread(() -> {
//            long start3 = System.currentTimeMillis();
//            for(int i = 60001 ; i < 100000 ; i++){
//                try{
//                    threadList.get(i).start();
//                    threadList.get(i).join();
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//            }
//            long end3 = System.currentTimeMillis();
//            System.out.println("Third batch time "+(end3-start3));
//        });
//
//        t1.start();
//        t2.start();
//        t3.start();
//
//        try {
//            t1.join(); // Calling thread will wait here until "thread" t1 is done
//            t2.join(); // Calling thread will wait here until "thread" t2 is done
//            t3.join(); // Calling thread will wait here until "thread" t3 is done
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
