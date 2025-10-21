package test;
// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;

public class AntiClockWise {
    public static ArrayList<Integer> spiralAntiClockWiseOrder(Node root)
    {


        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
// 		int height = levelOrderTraversal(1, root, map);
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int height = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> res = new ArrayList<>();
            for(int i = 0 ; i < size; i++){
                Node node = queue.poll();
                res.add((Integer)node.data);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            ++height;
            map.put(height, res);
        }
        int low = 1;
        while(low <= height){
            if(low == height){
                ArrayList<Integer> reverse = map.get(low);
                Collections.reverse(reverse);
                ans.addAll(reverse);
            }
            else{
                ArrayList<Integer> reverse = map.get(low);
                if( reverse != null){
                    Collections.reverse(reverse);
                    ans.addAll(reverse);
                }
                if(!map.get(height).isEmpty()){
                    ans.addAll(map.get(height));
                }
                low++;
                height--;
            }
        }
        return ans;
    }

    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int value){
            this.data = value;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n10 = new Node(10);
        Node n11 = new Node(11);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n4.left = n7;
        n4.right = n8;
        n5.left = n9;
        n3.right = n6;
        n6.left = n10;
        n6.right = n11;
        ArrayList<Integer> result = spiralAntiClockWiseOrder(n1);
        for(Integer each : result) {
            System.out.println("ans " + each);
        }
    }
}