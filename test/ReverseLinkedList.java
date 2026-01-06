package test;

public class ReverseLinkedList<T> {

    public static class Node<T>{
        T data;

        Node<T> next;

        public Node(T val){
            this.data = val;
            this.next = null;
        }
    }

    public Node<T> reverseIterative(Node<T> root){
        Node<T> prev = null;
        Node<T> current = root;
        while(current.next != null){
            Node<T> next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        current.next = prev;
        return current;
    }

    public Node<T> recur(Node<T> root){
        if(root == null || root.next == null){
            return root;
        }
        else{
            Node<T> next = recur(root.next);
            root.next.next = root;
            root.next = null;
            return next;
//            Node<T> next = recur(root.next);
//            Node<T> parent = next;
//            while(next.next != null){
//                next = next.next;
//            }
//            next.next = root;
//            root.next = null;
//            return parent;
        }
    }

    public static void main(String [] args){
        ReverseLinkedList<Integer> c = new ReverseLinkedList<>();
        Node<Integer> node = new Node<>(1);
        Node<Integer> node1 = new Node<>(2);
        Node<Integer> node2 = new Node<>(3);
        Node<Integer> node3 = new Node<>(4);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        Node<Integer> result = c.recur(node);
        System.out.println("root "+result.data);
    }

}
