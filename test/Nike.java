package test;
import java.util.*;
import java.util.stream.Collectors;

public class Nike {


        public static int sum(int [] nums){
            int total = 0;
            for(int num : nums){
                if(num % 3 != 0 && num % 7 != 0){
                    total += num;
                }
            }
            return total;
        }
        public static List<Map.Entry<Character, Integer>> count(String str){
            Map<Character, Integer> map = new HashMap<>();
            for(char c : str.toCharArray()){
                map.put(c, map.getOrDefault(c, 0) +1);
            }
//            List<Map.Entry<Character, Integer>> entries = map.entrySet().stream().collect(Collectors.toList());
//
//            Collections.sort(entries, (a, b) -> a.getValue() - b.getValue());
//            return entries;
            return map.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());
        }
        public static void main(String[] args) {
            int [] nums = {1,2,3,4,5,6,7,8,9};
            System.out.println("Try programiz.pro sum : "+sum(nums));
            String str = "Use this editor to write, compile and run your Java code online";
            System.out.println("character count "+count(str));

        }

}
