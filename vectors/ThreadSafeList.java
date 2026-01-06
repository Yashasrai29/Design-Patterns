package vectors;

import java.util.*;
public class ThreadSafeList {

        public static class MyThread extends Thread{
            public void run(){
                System.out.println("performing custom thread");
            }
        }
        private static Vector<Integer> list = new Vector<>();

        public static void main(String[] args) throws InterruptedException {
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run(){
                    for(int i = 0 ; i < 10 ; i++){
                        if(i%2 == 0){
                            try{
                                list.add(i);
                                Thread.sleep(200);
                            }catch(InterruptedException e){
                                e.printStackTrace();
                            }
                        }
                    }
                }
            });

            Thread t2 = new Thread(new Runnable(){
                @Override
                public void run(){
                    for(int i = 0 ; i < 10 ; i++){
                        if(i%2 != 0){
                            try{
                                list.add(i);
                                Thread.sleep(200);
                            }catch(InterruptedException e){
                                e.printStackTrace();
                            }
                        }
                    }
                }
            });

            Thread t3 = new Thread(() -> {
                for(int i = 0 ; i < 10 ; i++){
                    if(i%2 != 0){
                        try{
                            list.add(i);
                            Thread.sleep(200);
                        }catch(InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                }

            });
            t1.start();
            t2.start();
            t3.run();
            Thread.sleep(2000);
            // Collections.sort(list, Collections.reverseOrder());
            System.out.println("Try programiz.pro "+list);

            new MyThread().start();
        }

}
