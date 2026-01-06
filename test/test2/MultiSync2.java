package test.test2;

import concurrency.SemaPhores;

import java.util.concurrent.Semaphore;

public class MultiSync2 {

    public static volatile int data = 0;
    public static void main(String[] args){
//
//        new Thread(() -> {
//          for(int i = 1 ; i < 6 ; i++ ){
//              data += 1;
//              System.out.println((data % 2 == 0 ? "EVEN" : "ODD") + "-" + data+" thread-1");
//          }
//        }).start();
//        new Thread(() -> {
//            for(int i = 1 ; i < 6 ; i++ ){
//                data += 1;
//                System.out.println((data % 2 == 0 ? "EVEN" : "ODD") + "-" + data+" thread-2");
//            }
//        }).start();

        Semaphore semaphores = new Semaphore(1);

        new Thread(() -> {
            for(int i = 1 ; i < 6 ; i++ ) {
                try {
                    semaphores.acquire();
                    data += 1;
                    Thread.sleep(500);
                    System.out.println((data % 2 == 0 ? "EVEN" : "ODD") + "-" + data + " thread-1");
                }catch(Exception e){

                }finally {
                    semaphores.release();
                }
            }
        }).start();
        new Thread(() -> {
            for(int i = 1 ; i < 6 ; i++ ){
                try {
                    semaphores.acquire();
                    data += 1;
                    Thread.sleep(500);
                    System.out.println((data % 2 == 0 ? "EVEN" : "ODD") + "-" + data + " thread-2");
                }catch(Exception e){

                }finally {
                    semaphores.release();
                }
            }
        }).start();

    }
}
