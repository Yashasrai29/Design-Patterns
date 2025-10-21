package Trie;// Online Java Compiler
// Use this editor to write, compile and run your Java code online

public class Trie {
    Trie[] children;
    boolean isword;

    public Trie() {
        this.children = new Trie[26];
        this.isword = false;
    }


    
    public static Trie search(String word, Trie root){
        Trie node = root;
        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(node.children[index] == null){
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        Trie root = new Trie();
        String [] words = {"app", "apple", "application"};
        for(String word : words){
            Trie node = root;
            for(char c : word.toCharArray()){
                int index = c - 'a';
                if(node.children[index] == null){
                    node.children[index] = new Trie();
                }
                node = node.children[index];
            }
            node.isword = true;
        }
        Trie t = search("app", root);
        System.out.println(" present "+(t != null)+" last "+t.isword);
    }
}