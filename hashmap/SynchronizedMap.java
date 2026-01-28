package hashmap;

import java.util.concurrent.locks.ReentrantLock;
public class SynchronizedMap {

    public static class HashMap<K, V> {
        private static final int SIZE = 16;
        private HashMap.Entry<K,V>[] pairs;

        private ReentrantLock lock;
        private static class Entry<K, V>{
            K key;
            V value;
            HashMap.Entry<K,V> next;
            Entry(K key, V value){
                this.key = key;
                this.value = value;
            }
        }
        @SuppressWarnings("unchecked")
        public HashMap(){
            this.pairs = new HashMap.Entry[SIZE];
            this.lock = new ReentrantLock(true);
        }

        public V get(K key){
            try {
                lock.lock();
                int index = getIndex(key);
                HashMap.Entry<K, V> head = pairs[index];
                while (head != null) {
                    if (head.key == key) {
                        return head.value;
                    }
                    head = head.next;
                }
            } catch (Exception e){

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
                HashMap.Entry<K, V> head = pairs[index];
                while(head != null){
                    if(head.key == key){
                        head.value = value;
                        return;
                    }
                    head = head.next;
                }
                HashMap.Entry<K, V> newEntry = new HashMap.Entry<K,V>(key, value);
                newEntry.next = pairs[index];
                pairs[index] = newEntry;
            } catch (Exception e){

            }
            finally {
                lock.unlock();
            }
        }

        public void remove(K key){
            try{
                lock.lock();
                int index = getIndex(key);
                HashMap.Entry<K, V> head = pairs[index];
                HashMap.Entry<K, V> previous = null;
                while(head != null){
                    if(head.key == key){
                        if(previous == null){
                            pairs[index] = head.next;
                        }
                        else{
                            previous.next = head.next;
                        }
                    }
                    previous = head;
                    head = head.next;
                }
            } catch (Exception e){

            }
            finally {
                lock.unlock();
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
        HashMap<Integer, String> map = new HashMap();
        map.put(1, "yashas");
        map.put(2, "shanul");
        map.put(3, "sita");

        System.out.println("3 "+map.get(3));

        Thread t1 = new Thread( () -> {
           try {
               map.put(2, "shanul huda");
//               Thread.sleep(2000);

               map.put(1, "Yashas Rai");
//               Thread.sleep(2000);
           }catch (Exception e){

           }
        });
        Thread t2 = new Thread( () -> {
            try {
                map.put(2, "shanul Ansari");
//                Thread.sleep(2000);

                map.put(1, "Yashas H M");
//                Thread.sleep(2000);
            }catch (Exception e){

            }
        });
        t2.start();
        t1.start();

        try{

            t2.join();
            t1.join();
        } catch (Exception e){

        }

        map.put(3, "sitarami");
        System.out.println("3 "+map.get(3));

        System.out.println("2 "+map.get(2));
        System.out.println("1 "+map.get(1));
        map.remove(2);
        System.out.println("2 "+map.contains(2));
    }
}
