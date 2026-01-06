// Online Java Compiler
// Use this editor to write, compile and run your Java code online
package hashmap;

public class Main {
    
    public static class HashMap<K, V> {
        private static final int SIZE = 16;
        private Entry<K,V> [] pairs;
        private static class Entry<K, V>{
            K key;
            V value;
            Entry<K,V> next;
            Entry(K key, V value){
                this.key = key;
                this.value = value;
            }
        }
        @SuppressWarnings("unchecked")
        public HashMap(){
            pairs = new Entry[SIZE];
        }
        
        public V get(K key){
            int index = getIndex(key);
            Entry<K,V> head = pairs[index];
            while(head != null){
                if(head.key == key){
                    return head.value;
                }
                head = head.next;
            }
            return null;
        }
        public void put(K key, V value){
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
        }
        
        public void remove(K key){
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
                }
                previous = head;
                head = head.next;
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
        map.put(3, "sitarami");
        System.out.println("3 "+map.get(3));
        
        System.out.println("2 "+map.get(2));
        map.remove(2);
        System.out.println("2 "+map.contains(2));
    }
}