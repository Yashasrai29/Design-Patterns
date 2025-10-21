package test;

// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.lang.Exception;

@SuppressWarnings({"unchecked"})
class Main {

    public static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;
        public Node(K key, V value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public static class Map<K, V>{
        int capacity;
        Node<K, V> [] nodes;

        public Map(int capacity){
            this.capacity = capacity;
            this.nodes = new Node [capacity];
        }

        public int getIndex(K key){
            return (int) (key.hashCode() % capacity);
        }

        public void put(K key, V value){
            int index = getIndex(key);
            remove(key);
            if(nodes[index] == null){
                Node newNode = new Node(key, value);
                nodes[index] = newNode;
            }
            else{
                Node current = nodes[index];
                Node newNode = new Node(key, value);
                newNode.next = current;
                nodes[index] = newNode;
            }
        }

        public Node remove(K key){
            Node result = null;
            int index = getIndex(key);
            if(nodes[index] != null){
                Node current = nodes[index];
                if(current.key == key){
                    result = current;
                    Node next = current.next;
                    current.next = null;
                    nodes[index] = next;
                }
                else{
                    Node prev = current;
                    current = current.next;
                    while(current != null){
                        if(current.key == key){
                            result = current;
                            prev.next = current.next;
                            prev = current;
                        }
                        current = current.next;
                    }
                }
            }
            return result;
        }

        public V get(K key){
            int index = getIndex(key);
            if(nodes[index] != null){
                Node current = nodes[index];
                while(current != null){
                    if(current.key == key){
                        return (V) current.value;
                    }
                    current = current.next;
                }
            }
            try{
                throw new Exception("not found");
                // return null;
            } catch( Exception e){

            }
            return null;
        }


    }
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        Map<String, Integer> map = new Map(2);
        map.put("a", 1);
        map.put("b", 2);


        map.put("x", 4);
        map.put("c", 973);
        map.put("i", 6747);
        map.put("ij", 364);

        map.put("b", 20);
        System.out.println("b "+map.get("b"));

        map.remove("a");
        System.out.println("ij "+map.get("ij"));

    }
}