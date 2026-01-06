package test;

import java.util.*;
import java.util.stream.Collectors;

public class TreeView {

    public static class Tree{
        Tree left;
        Tree right;

        int data;

        public Tree(int val){
            this.data = val;
            this.left = null;
            this.right = null;
        }
    }

    public static List<Integer> leftView(Tree root){
        Map<Integer, Integer> map = new TreeMap<>();
        recurLeft(root, map, 1);
        return map.values().stream().collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
            Collections.reverse(list);
            return list;
        }));
//        List<Integer> result = map.values().stream().collect(Collectors.toList());
//        Collections.reverse(result);
//        return result;
    }


    public static List<Integer> rightView(Tree root) {
        Map<Integer, Integer> map = new TreeMap<>();
        recurRight(root, map, 1);
        return map.values().stream().collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
            Collections.reverse(list);
            return list;
        }));
    }

    public static List<Integer> topView(Tree root) {
        Map<Integer, Integer> map = new TreeMap<>();
        recurTop(root, map, 0);
        return map.values().stream().collect(Collectors.toList());
//        return map.values().stream().collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
//            Collections.reverse(list);
//            return list;
//        }));
    }

    public static List<Integer> bottomView(Tree root) {
        Map<Integer, Integer> map = new TreeMap<>();
        recurBottom(root, map, 0);
//        int maxHeight = height(root);
        return map.values().stream().collect(Collectors.toList());

    }

    public static int height(Tree root){
        if(root == null){
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }
    public static void recurLeft(Tree root, Map<Integer, Integer> map, int level){
        if(root == null){
            return;
        }
        recurLeft(root.left, map, level+1);
        if(!map.containsKey(level)){
            map.put(level, root.data);
        }
        recurLeft(root.right, map, level+1);
    }

    public static void recurRight(Tree root, Map<Integer, Integer> map, int level){
        if(root == null){
            return;
        }
        recurRight(root.left, map, level+1);
        map.put(level, root.data);
        recurRight(root.right, map, level+1);
    }

    public static void recurTop(Tree root, Map<Integer, Integer> map, int hd){
        if(root == null){
            return;
        }
        if(!map.containsKey(hd)){
            map.put(hd, root.data);
        }
        recurTop(root.left, map, hd-1);
        recurTop(root.right, map, hd+1);
    }

    public static void recurBottom(Tree root, Map<Integer, Integer> map, int hd){
        if(root == null){
            return;
        }
        map.put(hd, root.data);
        recurBottom(root.left, map, hd-1);
        recurBottom(root.right, map,  hd+1);
    }
//    public static void recurBottom(Tree root, Map<Integer, Map<Integer, List<Integer>>> map, int level, int hd){
//        if(root == null){
//            return;
//        }
//        if(!map.containsKey(level)){
//            map.put(level, new TreeMap<>());
//        }
//        if(!map.get(level).containsKey(hd)){
//            map.get(level).put(hd, new ArrayList<>());
//        }
//        map.get(level).get(hd).add(root.data);
//        recurBottom(root.left, map, level+1 ,hd-1);
//        recurBottom(root.right, map, level+1, hd+1);
//    }

    public static void main(String [] args){
        Tree root = new Tree(5);
        Tree l1 = new Tree(3);
        Tree r1 = new Tree(7);
        Tree l11 = new Tree(1);
        Tree l12 = new Tree(4);
        Tree r11 = new Tree(6);
        Tree r12 = new Tree(8);
        root.left = l1;
        root.right = r1;
        l1.left = l11;
        l1.right = l12;
        r1.left = r11;
        r1.right = r12;
        System.out.println("left view "+leftView(root).toString());
        System.out.println("right view "+rightView(root).toString());
        System.out.println("top view "+topView(root).toString());
        System.out.println("bottom view "+bottomView(root).toString());
    }
}
