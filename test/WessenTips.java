package test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WessenTips {

    public static List<String> sortByLength(List<String> list){
        Collections.sort(list, (a, b) -> a.length()- b.length());
        return list;
    }

    public static Map<Integer, String> mergeTreeMap( Map<Integer, String> m1,  Map<Integer, String> m2){
        List<Map.Entry<Integer, String>> l1 = m1.entrySet().stream().toList();
        List<Map.Entry<Integer, String>> l2 = m2.entrySet().stream().toList();
        int s1 = 0, s2 = 0;
        Map<Integer, String> res= new LinkedHashMap<>();
        while(s1 < l1.size() && s2 < l2.size()){
            if(l1.get(s1).getKey() < l2.get(s2).getKey()){
                res.put(l1.get(s1).getKey(), l1.get(s1).getValue());
                s1++;
            }
            else{
                res.put(l2.get(s2).getKey(), l2.get(s2).getValue());
                s2++;
            }
        }
        while(s1 < l1.size()){
            res.put(l1.get(s1).getKey(), l1.get(s1).getValue());
            s1++;
        }
        while(s2 < l2.size()){
            res.put(l2.get(s2).getKey(), l2.get(s2).getValue());
            s2++;
        }
        return res;
    }


    public static long longestSubString(String str){
//        Given a string s and an integer k,
//        find the length of the longest substring that contains at most k distinct characters
//        Input: String s = "eceba"; int k = 2; Explanation: The substrings with at most 2
//        distinct characters are: "ec" (distinct characters: e, c) "ece" (distinct characters: e, c)
//        "ec" (distinct characters: e, c)
//        "eba" (distinct characters: e, b, a) → Invalid (has 3 distinct characters)
//        The longest valid substring is "ece", which has a length of 3


        List<String> substrings = new ArrayList<>();
        for(int i = 0; i < str.length(); i++){
            for(int j = i+1; j < str.length(); j++){
                substrings.add(str.substring(i, j));
            }
        }
        long max = 0;
        String maxString = null;
        for(String each : substrings){
            Map<Character, Integer> map = new HashMap<>();
            for(int i = 0; i < each.length(); i++){
                map.put(each.charAt(i), map.getOrDefault(each.charAt(i), 0)+1);
            }
            long longest = map.entrySet().stream().filter(e -> e.getValue() == 1).count();
//            max = Math.max(max, longest);
            if(longest > max){
                maxString = each;
                max = longest;
            }
        }
        System.out.println("longest substring "+maxString);
        return max;

    }
    public static void main(String [] args){
        String input = "Java is amazing";
        List<String> list = Arrays.asList(input.split("\\s"));
        sortByLength(list);
        System.out.println("sort by length "+list.toString());


        Map<Integer, String> m1 = new TreeMap<>();
        Map<Integer, String> m2 = new TreeMap<>();
        for(int i = 1 ; i < 10; i++){
            m1.put(i, String.valueOf(i));
        }
        for(int i = 10 ; i < 20; i++){
            m2.put(i, String.valueOf(i));
        }

        Map<Integer, String> res = mergeTreeMap(m1, m2);
        for(Map.Entry<Integer, String> entry : res.entrySet()){
            System.out.println("entry "+entry.getKey()+ " value "+entry.getValue());
        }

        System.out.println("longest substring "+longestSubString("eceba"));
    }
}
