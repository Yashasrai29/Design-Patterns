package balanced_bst;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AVLDemo {

    public static class AVL<T extends Comparable<T>> {

        private Tree<T> root;

        public AVL(){
            this.root = null;
        }

        public void put(T data){
            root = insert(data, root);
        }

        public void lvlHelper(){
            int maxHeight = height(root);
            for(int i = 1; i <= maxHeight ; i++) {
                List<T> list = new ArrayList<>();
                lvl(i, root, list);
                System.out.println("level order traversal "+list.toString());
            }
        }

        public void lvl(Integer level, Tree<T> node, List<T> list){
            if(node == null){
                return;
            }
            lvl(level-1, node.left, list);
            if(level == 1) {
//                System.out.println("each " + node.data + " level " + level);
                list.add(node.data);
            }
            lvl(level-1, node.right, list);
        }

        Tree<T> insert(T data, Tree<T> root){

            if(root == null){
                return new Tree(data);
            }

            else if(data.compareTo(root.data) < 0 ){
                root.left = insert(data, root.left);
            }

            else if(data.compareTo(root.data) > 0 ){
                root.right = insert(data, root.right);
            }
            else{
                return root;
            }
            root.height = height(root);
            int balance = getBalance(root);
            if(balance > 1 && data.compareTo(root.left.data) < 0){
                root = rightRotate(root);
            }
            else if(balance > 1 && data.compareTo(root.left.data) > 0){
                root.left = leftRotate(root.left);
                root = rightRotate(root);
            }

            else if (balance < -1 && data.compareTo(root.right.data) > 0){
                root = leftRotate(root);
            }
            else if(balance < -1 && data.compareTo(root.right.data) < 0){
                root.right = rightRotate(root.right);
                root = leftRotate(root);
            }

            return root;
        }

        Tree<T> rightRotate(Tree<T> node){
            Tree<T> x = node.left;
            Tree<T> y = x.right;
            x.right = node;
            node.left = y;
            x.height = height(x);
            node.height = height(node);
            return x;
        }

        Tree<T> leftRotate(Tree<T> node){
            Tree<T> x = node.right;
            Tree<T> y = x.left;
            x.left = node;
            node.right = y;
            x.height = height(x);
            node.height = height(node);
            return x;
        }

        int getBalance(Tree<T> node){
            int l = node.left == null? 0 : node.left.height;
            int r = node.right == null? 0 : node.right.height;
            return l - r;
        }

        int height(Tree<T> node){
            if(node == null){
                return 0;
            }
            return Math.max(height(node.left), height(node.right)) + 1;
        }
        public static class Tree<T> {
            Tree<T> left;
            Tree<T> right;

            Integer height;

            T data;

            public Tree(T t) {
                this.data = t;
                this.left = null;
                this.right = null;
                this.height = 0;
            }
        }
    }

    public static void main(String [] args){
     AVL<Integer> avl = new AVL<>();
     avl.put(1);
     avl.put(2);
     avl.put(3);
     avl.put(4);
     avl.put(5);
     avl.put(6);
     avl.put(7);
     avl.put(8);
     avl.put(9);
     avl.put(10);
     avl.lvlHelper();
    }
}
