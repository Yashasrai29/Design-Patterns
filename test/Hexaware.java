package test;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Hexaware {

    public static char second(String word) {
//        String str = word.toLowerCase();
//        int[] freq = new int[26];
//        for (int i = 0; i < word.length(); i++) {
//            freq[str.charAt(i) - 'a']++;
//        }
        char c = IntStream.range(0, word.length()).boxed().collect(Collectors.groupingBy((e) -> word.charAt(e), Collectors.counting())).entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).map(e -> e.getKey()).skip(1).findFirst().get();
        return c;
    }
    public static void main(String [] args){
     System.out.println("second char "+String.valueOf(second("aaaaaabbbccccwe")));
     LinkedList<Integer> list = new LinkedList<>();
     list.addFirst(1);
     list.addLast(10);
     list.offerFirst(2);
     list.offerLast(12);
//     list.re
//        System.out.println("a "+((char) 65));
    }
}
