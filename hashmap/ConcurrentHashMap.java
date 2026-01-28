package hashmap;

import java.util.Objects;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentHashMap{


    public static class HashMap<K, V> {

            private static int SIZE = 16;
            private volatile Segment<K, V> [] pairs;
            private static class Entry<K, V>  {
                K key;
                V value;
                Entry<K,V> next;
                Entry(K key, V value){
                    this.key = key;
                    this.value = value;
                }
            }

            public static class Segment<K, V> extends ReentrantLock{
                Entry<K, V> entry;

                public Segment(){

                }

            }


            @SuppressWarnings("unchecked")
            public HashMap(){
                this.pairs = new Segment[SIZE];
            }


            public V get(K key){
                int index = getIndex(key);
                Segment<K, V> segment = pairs[index];
                if(segment == null) {
                    return null;
                }
                else {
                    try {
                        segment.lock();
                        Entry<K, V> head = segment.entry;
                        while (head != null) {
                            if (head.key == key) {
                                return head.value;
                            }
                            head = head.next;
                        }
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    finally {
                        segment.unlock();
                    }

                }
                return null;
            }
            public void put(K key, V value){
                int index = getIndex(key);
                Segment<K, V> segment = pairs[index];
                if(segment == null){
                    synchronized (pairs) {
                        segment = pairs[index];
                        if(segment != null){
                            try {
                                segment.lock();
                                Entry<K, V> head = segment.entry;
                                while (head != null) {
                                    if (head.key == key) {
                                        head.value = value;
                                        return;
                                    }
                                    head = head.next;
                                }
                                Entry<K, V> newEntry = new Entry<>(key, value);
                                newEntry.next = segment.entry;
                                segment.entry = newEntry;
                            }
                            catch (Exception e){
                                e.printStackTrace();
                            }
                            finally{
                                segment.unlock();
                            }
                        }
                        else {
                            Entry<K, V> newEntry = new Entry<K, V>(key, value);
                            Segment<K, V> newSegment = new Segment<>();
                            newSegment.entry = newEntry;
                            pairs[index] = newSegment;
                        }
                    }
                }
                else {
                    try {
                        segment.lock();
                        Entry<K, V> head = segment.entry;
                        while (head != null) {
                            if (head.key == key) {
                                head.value = value;
                                return;
                            }
                            head = head.next;
                        }
                        Entry<K, V> newEntry = new Entry<K,V>(key, value);
                        newEntry.next = segment.entry;
                        segment.entry = newEntry;
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    finally {
                        segment.unlock();
                    }
                }
            }

            public void remove(K key){
                int index = getIndex(key);
                Segment<K, V> segment = pairs[index];
                if(segment != null) {
                    try {
                        segment.lock();
                        Entry<K, V> head = segment.entry;
                        Entry<K, V> previous = null;
                        while (head != null) {
                            if (head.key == key) {
                                if (previous == null) {
                                    segment.entry = head.next;
                                } else {
                                    previous.next = head.next;
                                }
                            }
                            previous = head;
                            head = head.next;
                        }
                        if(segment.entry == null){
                            pairs[index] = null;
                        }
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                    finally{
                        segment.unlock();
                    }
                }
            }

            private int getIndex(K key){
                return (key.hashCode() & Integer.MAX_VALUE )  % SIZE;
            }
            public boolean contains(K key){
                return get(key) != null;
            }
        }

    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        ConcurrentHashMap.HashMap<Integer, Integer> map = new ConcurrentHashMap.HashMap<>();
//        map.put(1, "yashas");
//        map.put(2, "shanul");
//        map.put(3, "sita");

        System.out.println("3 "+map.get(3));

        Thread t1 = new Thread( () -> {
            try {
                for(int i = 1 ; i < 100_000; i++){
                    int r = new Random().nextInt(1, 10000);
                    map.put(r, r);
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread( () -> {
            try {
                for(int i = 1 ; i < 100_000; i++){
                    int r = new Random().nextInt(1, 10000);
                    map.put(r, r);
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

//        map.put(3, "sitarami");
        System.out.println("3 "+map.get(3));
//
//        System.out.println("2 "+map.get(2));
//        System.out.println("1 "+map.get(1));
//        map.remove(2);
//        System.out.println("2 "+map.contains(2));
//        for()
    }
}