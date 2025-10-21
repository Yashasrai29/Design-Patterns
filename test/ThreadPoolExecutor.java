package test;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;

public class ThreadPoolExecutor {

    public static void execute(List<String> input){
        var executorService = Executors.newFixedThreadPool(3);
//        executorService.


        for(String str : input) {
            try {
                Thread t1 = new Thread(() -> {
                    System.out.println("executing task " + str);
                });
                executorService.submit(t1);
                Thread.sleep(2000);
            } catch(Exception e){
                e.printStackTrace();
            }
        }


    }

    public class Task implements Runnable{

        int value;
        public Task(int data){
            this.value = data;
        }
        @Override
        public void run() {
            try {
                System.out.println("printing task " + value);
                Thread.sleep(2000);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void service(){
        try {
            ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(5);
            java.util.concurrent.ThreadPoolExecutor executor = new java.util.concurrent.ThreadPoolExecutor(2, 3, 1, TimeUnit.HOURS, queue);
            for (int i = 1; i <= 10; i++) {
                executor.submit(new Task(i));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String [] args){
//        List<String> list = new ArrayList<>();
//        list.add("task 1");
//        list.add("task 2");
//        list.add("task 3");
//        list.add("task 4");
//        list.add("task 5");
//        list.add("task 6");
//        execute(list);
        ThreadPoolExecutor exe = new ThreadPoolExecutor();
        exe.service();


    }
}
