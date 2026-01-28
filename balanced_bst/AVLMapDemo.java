package balanced_bst;


public class AVLMapDemo {

    public static class Map<K extends Comparable<K>, V> {

        protected Entry<K, V> [] hashTable;

        protected Integer defaultSize = 2;

        protected Integer size;
        public Map(){
            this.hashTable = new Entry[defaultSize];
            this.size = 0;
        }

        public void put(K key, V value){
            int index = findIndex(key);
            Entry<K, V> root = hashTable[index];
            root = insert(key, value, root);
            hashTable[index] = root;
        }

        private void remove(K key){
            int index = findIndex(key);
            Entry<K, V> root = hashTable[index];
            root = delete(key, root);
            hashTable[index] = root;
        }

        public Integer size(){
            return size;
        }

        private Integer findIndex(K key){
            return ((key.hashCode() & Integer.MAX_VALUE) % defaultSize);
        }

        private Entry<K, V> insert(K key, V value, Entry<K, V> root){

            if(root == null){
                size++;
                return new Entry(key, value);
            }

            else if(key.compareTo(root.key) < 0 ){
                root.left = insert(key, value, root.left);
            }

            else if(key.compareTo(root.key) > 0 ){
                root.right = insert(key, value, root.right);
            }
            else{
                return root;
            }
            root.height = height(root);
            int balance = getBalance(root);
            if(balance > 1 && key.compareTo(root.left.key) < 0){
                root = rightRotate(root);
            }
            else if(balance > 1 && key.compareTo(root.left.key) > 0){
                root.left = leftRotate(root.left);
                root = rightRotate(root);
            }

            else if (balance < -1 && key.compareTo(root.right.key) > 0){
                root = leftRotate(root);
            }
            else if(balance < -1 && key.compareTo(root.right.key) < 0){
                root.right = rightRotate(root.right);
                root = leftRotate(root);
            }

            return root;
        }

        private Entry<K,V> delete(K key, Entry<K,V> root){
            if(root == null){
                return null;
            }
            else if(key.compareTo(root.key) < 0 ){
                root.left = delete(key, root.left);
            }

            else if(key.compareTo(root.key) > 0 ){
                root.right = delete(key, root.right);
            }
            else {
                if(root.left == null && root.right == null){
                    return null;
                }
                else{
                    size--;
                    if(root.left != null && root.right != null){
                        Entry<K, V> successor = successor(root.right);
                        root.key = successor.key;
                        root.value = successor.value;
                        root.right = delete(successor.key, root.right);
                        return root;
                    }
                    else{
                        return root.left == null ? root.right : root.left;
                    }
                }
            }
            root.height = height(root);
            int balance = getBalance(root);

            if(balance > 1 &&  getBalance(root.left) >= 1){
                root = rightRotate(root);
            }

            else if(balance > 1 && getBalance(root.left) <= -1){
                root.left = leftRotate(root.left);
                root = rightRotate(root);
            }

            else if (balance < -1 && getBalance(root.right) <=  -1){
                root = leftRotate(root);
            }

            else if(balance < -1 && getBalance(root.right) >= 1){
                root.right = rightRotate(root.right);
                root = leftRotate(root);
            }
            return root;
        }

        private Entry<K, V> successor(Entry<K, V> node){
            while (node.left != null){
                node = node.left;
            }
            return node;
        }

        private Entry<K, V> rightRotate(Entry<K, V> node){
            Entry<K, V> x = node.left;
            Entry<K, V> y = x.right;
            x.right = node;
            node.left = y;
            x.height = height(x);
            node.height = height(node);
            return x;
        }

        private Entry<K, V> leftRotate(Entry<K, V> node){
            Entry<K, V> x = node.right;
            Entry<K, V> y = x.left;
            x.left = node;
            node.right = y;
            x.height = height(x);
            node.height = height(node);
            return x;
        }

        public int getBalance(Entry<K, V> node){
            if(node == null){
                return 0;
            }
            return height(node.left) - height(node.right);
        }
        private int height(Entry<K, V> node){
            if(node == null){
                return 0;
            }
            return Math.max(height(node.left), height(node.right)) + 1;
        }
        private static class Entry<K, V> {
            Entry<K, V> left;
            Entry<K, V> right;

            Integer height;

            K key;

            V value;

            public Entry(K key, V value) {
                this.key = key;
                this.value = value;
                this.left = null;
                this.right = null;
                this.height = 0;
            }
        }
    }

    public static void main(String [] args){
        Map<Integer, Integer> map = new Map<>();
        for(int i = 1 ; i < 50; i++){
            map.put(i, i);
        }

        map.remove(32);
        System.out.println("final size "+map.size());
    }
}
