package hashmap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class LinkedMap{
    public static class LinkedHashMap<K, V> {
            private static final int SIZE = 16;
            private Entry<K,V> [] pairs;

            private Entry<K, V> header;
            private Entry<K, V> tail;
            private ReentrantLock lock;
            private static class Entry<K, V>{
                K key;
                V value;
                Entry<K,V> next;

                Entry<K, V> before;
                Entry<K, V> after;
                Entry(K key, V value){
                    this.key = key;
                    this.value = value;
                    this.before = null;
                    this.after = null;
                    this.next = null;
                }

                public K getKey(){
                    return this.key;
                }

                public V getValue(){
                    return this.value;
                }
            }
            @SuppressWarnings("unchecked")
            public LinkedHashMap(){
                this.pairs = new Entry[SIZE];
                this.header = null;
                this.tail = null;
                this.lock = new ReentrantLock(true);
            }

            public V get(K key){
                try {
                    lock.lock();
                    int index = getIndex(key);
                    Entry<K, V> head = pairs[index];
                    while (head != null) {
                        if (head.key == key) {
                            return head.value;
                        }
                        head = head.next;
                    }
                }catch (Exception e){

                }
                finally {
                    lock.unlock();
                }
                return null;
            }
            public void put(K key, V value){
                try{
                    lock.lock();
                    int index = getIndex(key);
                    Entry<K, V> head = pairs[index];
                    while(head != null){
                        if(head.key == key){
                            head.value = value;
                            return;
                        }
                        head = head.next;
                    }
                    Entry<K, V> newEntry = new Entry<K,V>(key, value);
                    newEntry.next = pairs[index];
                    pairs[index] = newEntry;
                    if(header == null){
                        header = tail = newEntry;
                    }
                    else {
                        tail.after = newEntry;
                        newEntry.before = tail;
                        tail = newEntry;
                    }
                }catch (Exception e){

                }
                finally {
                    lock.unlock();
                }
            }

            public void remove(K key){
                try{
                    lock.lock();
                    int index = getIndex(key);
                    Entry<K, V> head = pairs[index];
                    Entry<K, V> previous = null;
                    while(head != null){
                        if(head.key == key){
                            if(previous == null){
                                pairs[index] = head.next;
                            }
                            else{
                                previous.next = head.next;
                            }
                            if(head == header){
                                header = header.after;
                            }
                            if(head.before != null ) {
                                head.before.after = head.after;
                            }
                            if(head.after != null){
                                head.after.before = head.before;
                            }
                            return;
                        }
                        previous = head;
                        head = head.next;
                    }
                }catch (Exception e){

                }
                finally {
                    lock.unlock();
                }
            }

            private int getIndex(K key){
                return (key.hashCode() & Integer.MAX_VALUE )  % SIZE;
            }
            public boolean contains(K key){
//                try{
//                    lock.lock();
                    return get(key) != null;
//                }catch (Exception e){
//
//                }
//                finally {
//                    lock.unlock();
//                }
//                return false;
            }

            public List<Entry<K, V>> entrySet(){
                try{
                    lock.lock();
                    List<Entry<K, V>> result = new ArrayList<>();
                    Entry<K,V> node = header;
                    while(node != null){
                        result.add(node);
                        node = node.after;
                    }
                    return result;
                }catch (Exception e){

                }
                finally {
                    lock.unlock();
                }
                return Collections.emptyList();
            }
        }

        public static void main(String[] args) {
            System.out.println("Try programiz.pro");

            LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
//            map.put(1, "yashas");
//            map.put(2, "shanul");
//            map.put(3, "sita");
//            System.out.println("3 "+map.get(3));
//            map.put(3, "sitarami");
//            System.out.println("3 "+map.get(3));
//            map.put(6, "Aruna");
//            map.put(5, "Nishanth");
//            map.put(4, "Isiri");
//
//            System.out.println("2 "+map.get(2));
//            map.remove(2);
//            System.out.println("2 "+map.contains(2));
            for(int i = 1; i < 500; i++){
                map.put(i, String.valueOf(i));
//                int r = new Random().nextInt(1, 500);
//                map.put(r, String.valueOf(r));
            }
            for(int i = 1; i <= 200; i++){
//                map.put(i, String.valueOf(i));
                int r = new Random().nextInt(1, 500);
                if(map.contains(r)) {
                    map.remove(r);
                }
            }
            System.out.println("size "+map.entrySet().size());
            for(LinkedHashMap.Entry<Integer,String > entry : map.entrySet()){
                System.out.println("key "+entry.getKey()+" value "+entry.getValue());
            }
        }

}