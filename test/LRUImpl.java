package test;


import java.util.*;
public class LRUImpl {


        //  1, 2, 3

        public static class LRU<K, V> {
            private static Node start;
            private static Node end;
            private Map<K, Node> map;

            private int size;

            public LRU(int finalCapacity){
                this.map = new HashMap<>();
                this.start = new Node(null, null);
                this.end = new Node(null, null);
                this.start.next = this.end;
                this.end.prev = this.start;
                this.size = finalCapacity;
            }

            public void put(K key, V value){
                if(map.containsKey(key)){
                    Node node = map.get(key);
                    remove((K) node.key);
                    Node newNode = new Node(key, value);
                    map.put(key, newNode);
                    Node first = this.start.next;
                    newNode.next = first;
                    first.prev = newNode;
                    this.start.next = newNode;
                }
                else{
                    Node newNode = new Node(key, value);
                    map.put(key, newNode);
                    Node first = this.start.next;
                    newNode.next = first;
                    first.prev = newNode;
                    this.start.next = newNode;
                }

                if(map.size() > size){
                    Node currEnd = this.end;
                    Node prv = currEnd.prev;
                    prv.prev.next = currEnd;
                    currEnd.prev = prv.prev ;
                    map.remove(prv.key);
                }
            }

            public V get(K key){
                if(map.containsKey(key)){
                    Node node = map.get(key);
                    remove(key);
                    Node newNode = new Node(key, node.value);
                    map.put(key, newNode);
                    Node first = this.start.next;
                    newNode.next = first;
                    first.prev = newNode;
                    this.start.next = newNode;
                    return (V) newNode.value;
                }
                return null;
            }

            public void remove(K key){
                if(map.containsKey(key)){
                    Node node = map.get(key);
                    Node previous = node.prev;
                    Node next = node.next;
                    previous.next = next;
                    next.prev = previous;
                    map.remove(key);
                }
            }
            public static class Node<K,V>{
                Node next;
                Node prev;
                K key;
                V value;
                public Node(K key, V value){
                    this.key = key;
                    this.value = value;
                }
            }
        }



        public static void main(String[] args) {

            LRU<Integer, String> lru = new LRU(2);
            lru.put(1, "1");
            lru.put(2, "2");
            System.out.println("get "+lru.get(1));
            lru.put(3, "3");
            lru.put(4, "4");
            System.out.println("get "+lru.get(1));
        }

}
