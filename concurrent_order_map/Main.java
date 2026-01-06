package concurrent_order_map;


import java.util.concurrent.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        ConcurrentNavigableMap<Integer, Integer> concurrentTreeMap = new ConcurrentSkipListMap<>();

        Thread t1 = new Thread( () -> {
            for(int i = 10 ; i < 20; i++){
                concurrentTreeMap.put(i, i);
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i = 0 ; i < 10; i++){
                concurrentTreeMap.put(i, i);
            }
        });

        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        } catch(InterruptedException e){
            e.printStackTrace();
        }
        for(Map.Entry<Integer, Integer> entry : concurrentTreeMap.entrySet()){
            System.out.println("key "+entry.getKey()+" value "+entry.getValue());
        }
    }
}