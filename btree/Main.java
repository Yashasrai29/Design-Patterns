package btree;

// BTree Node Class
class BTreeNode {
    int[] keys; // Array to store keys
    int t; // Minimum degree (defines range for number of keys)
    BTreeNode[] children; // Array of child pointers
    int n; // Current number of keys
    boolean leaf; // True if the node is a leaf

    public BTreeNode(int t, boolean leaf) {
        this.t = t;
        this.leaf = leaf;
        this.keys = new int[2 * t - 1]; // Max keys in a node
        this.children = new BTreeNode[2 * t]; // Max children in a node
        this.n = 0; // Initial number of keys
    }

    // Function to traverse the tree
    public void traverse() {
        int i;
        for (i = 0; i < n; i++) {
            if (!leaf) {
                children[i].traverse();
            }
            System.out.print(keys[i] + " ");
        }
        if (!leaf) {
            children[i].traverse();
        }
    }

    // Function to search for a key in the subtree
    public BTreeNode search(int key) {
        int i = 0;
        while (i < n && key > keys[i]) {
            i++;
        }
        if (i < n && keys[i] == key) {
            return this; // Found the key
        }
        if (leaf) {
            return null; // Not found
        }
        return children[i].search(key);
    }

    // Insert a new key when the node is not full
    public void insertNonFull(int key) {
        int i = n - 1;
        if (leaf) {
            while (i >= 0 && keys[i] > key) {
                keys[i + 1] = keys[i];
                i--;
            }
            keys[i + 1] = key;
            n++;
        } else {
            while (i >= 0 && keys[i] > key) {
                i--;
            }
            if (children[i + 1].n == 2 * t - 1) {
                splitChild(i + 1, children[i + 1]);
                if (keys[i + 1] < key) {
                    i++;
                }
            }
            children[i + 1].insertNonFull(key);
        }
    }

    // Split child y of this node. y is the i-th child of this node
    public void splitChild(int i, BTreeNode y) {
        BTreeNode z = new BTreeNode(y.t, y.leaf);
        z.n = t - 1;
        for (int j = 0; j < t - 1; j++) {
            z.keys[j] = y.keys[j + t];
        }
        if (!y.leaf) {
            for (int j = 0; j < t; j++) {
                z.children[j] = y.children[j + t];
            }
        }
        y.n = t - 1;
        for (int j = n; j >= i + 1; j--) {
            children[j + 1] = children[j];
        }
        children[i + 1] = z;
        for (int j = n - 1; j >= i; j--) {
            keys[j + 1] = keys[j];
        }
        keys[i] = y.keys[t - 1];
        n++;
    }
}

// BTree Class
class BTree {
    BTreeNode root;
    int t; // Minimum degree

    public BTree(int t) {
        this.t = t;
        this.root = null;
    }

    // Traverse the tree
    public void traverse() {
        if (root != null) {
            root.traverse();
        }
        System.out.println();
    }

    // Search a key
    public BTreeNode search(int key) {
        return (root == null) ? null : root.search(key);
    }

    // Insert a key
    public void insert(int key) {
        if (root == null) {
            root = new BTreeNode(t, true);
            root.keys[0] = key;
            root.n = 1;
        } else {
            if (root.n == 2 * t - 1) {
                BTreeNode s = new BTreeNode(t, false);
                s.children[0] = root;
                s.splitChild(0, root);
                int i = (s.keys[0] < key) ? 1 : 0;
                s.children[i].insertNonFull(key);
                root = s;
            } else {
                root.insertNonFull(key);
            }
        }
    }
}

// Main Class to Test B-Tree
public class Main {
    public static void main(String[] args) {

        BTree tree = new BTree(3); // BTree with minimum degree 3

        tree.insert(10);
        tree.insert(20);
        tree.insert(5);
        tree.insert(6);
        tree.insert(12);
        tree.insert(30);
        tree.insert(7);
        tree.insert(17);
        tree.insert(15);
        tree.insert(8);
        tree.insert(9);
        tree.insert(3);
        tree.insert(16);


        System.out.println("B-Tree traversal:");
        tree.traverse();

        int key = 6;
        if (tree.search(key) != null) {
            System.out.println("Key " + key + " is found in the B-Tree.");
        } else {
            System.out.println("Key " + key + " is NOT found in the B-Tree.");
        }
    }
}
