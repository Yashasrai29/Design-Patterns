package balanced_bst;

public class AVL {
        public static class Tree{
            int val;
            Tree left;
            Tree right;
            int height;

            public Tree(int data){
                this.val = data;
                this.left = null;
                this.right = null;
                this.height = 1;
            }
        }

        public static int getBalance(Tree root){
            if(root == null){
                return 0;
            }
            return height(root.left) - height(root.right);
        }

        public static int height(Tree root){
            if(root == null){
                return 0;
            }
            return root.height;
        }

        public static Tree leftRotate(Tree root){
            Tree x = root.right;
            Tree left = x.left;
            root.right = left;
            x.left = root;
            root.height =  Math.max(height(root.left), height(root.right))+1;
            x.height =  Math.max(height(x.left), height(x.right))+1;
            return x;
        }
        public static Tree rightRotate(Tree root){
            Tree x = root.left;
            Tree right = x.right;
            root.left = right;
            x.right = root;
            root.height =  Math.max(height(root.left), height(root.right)) + 1;
            x.height =  Math.max(height(x.left), height(x.right)) + 1;
            return x;
        }

        public static Tree insert(Tree root, int data){

            if(root == null){
                return new Tree(data);
            }
            else if(data < root.val){
                root.left = insert(root.left, data);
            }
            else if(data > root.val){
                root.right = insert(root.right, data);
            }
            else{
                return root;
            }

            root.height = Math.max(height(root.left), height(root.right))+1;
            int balance = getBalance(root);

            if(balance > 1 && data < root.left.val){
                return rightRotate(root);
            }
            if(balance > 1 && data > root.left.val){
                root.left = leftRotate(root.left);
                return rightRotate(root);
            }
            if(balance < -1 && data > root.right.val){
                return leftRotate(root);
            }
            if(balance < -1 && data < root.right.val){
                root.right = rightRotate(root.right);
                return leftRotate(root);
            }
            return root;

        }

        public static Tree minTree(Tree root){
            Tree node = root;
            while(node.left != null){
                node = node.left;
            }
            return node;
        }

        public static Tree deleteNode(Tree root, int data){
            if(root == null){
                return null;
            }
            else if(data < root.val){
                root.left = deleteNode(root.left, data);
            }
            else if(data > root.val){
                root.right = deleteNode(root.right, data);
            }
            else{
                if (root.left == null && root.right == null) {
                    return null;
                }
                else {
                    if (root.left != null && root.right != null) {
                        Tree node = minTree(root.right);
                        root.val = node.val;
                        root.right = deleteNode(root.right, node.val);
                    }
                    else{
                        root = root.left == null ? root.right : root.left;
                    }
                }
            }
            root.height = Math.max(height(root.left), height(root.right)) + 1;
            int balance = getBalance(root);
            if(balance > 1 && getBalance(root.left) >= 1){
                return rightRotate(root);
            }
            if(balance > 1 && getBalance(root.left) <= -1) {
                root.left = leftRotate(root.left);
                return rightRotate(root);
            }
            if(balance < -1 && getBalance(root.right) <= -1){
                return leftRotate(root);
            }
            if(balance < -1 && getBalance(root.right) >= 1) {
                root.right = rightRotate(root.right);
                return leftRotate(root);
            }

            return root;
        }

        public static void main(String[] args) {
            System.out.println("Try programiz.pro");

            Tree root = new Tree(1);

            root = insert(root, 2);
            root = insert(root, 3);
            root = insert(root, 4);
            root = insert(root, 5);
            root = insert(root, 6);
            root = insert(root, 7);
            root = insert(root, 8);
            root = insert(root, 9);
            root = insert(root, 10);
            root = insert(root, 11);
            root = insert(root, 12);
            root = deleteNode(root, 8);
            System.out.println("height "+height(root));
        }
}
