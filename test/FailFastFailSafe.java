package test;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFastFailSafe {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
//        Fail fast
//        Iterator<Integer> it = list.iterator();
//        while(it.hasNext()){
//            System.out.println("next "+it.next());
//            list.remove(2);
//        }

//        Fail Safe
        List<Integer> list2 = new CopyOnWriteArrayList<>(list);
//        Iterator<Integer> it2 = list2.iterator();

        Thread t1 = new Thread( () -> {
            try {
                for(int i = 1 ; i < 100_000; i++){
                    int r = new Random().nextInt(1, 10000);
                    list2.add(r);
                    Thread.sleep(200);
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread( () -> {
            try {
//              infinite processing
                while(true) {
                    Iterator<Integer> iter = list2.iterator();
                    while (iter.hasNext()) {
                        System.out.println("copy " + iter.next());
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();

        try{

            t2.join();
            t1.join();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
