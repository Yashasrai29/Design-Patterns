package test;

import java.util.*;

public class Anagrams {


    public static List<List<String>> find(String [] words){
        Map<String, List<String>> map = new HashMap<>();
        for(String each : words){
            int [] chars = new int[26];
            for(char c : each.toCharArray()){
                chars[c -'a']++;
            }
            String key = Arrays.toString(chars);
            if(map.containsKey(key)){
                map.get(key).add(each);
            }
            else{
                List<String> list = new ArrayList<>();
                list.add(each);
                map.put(key, list);
            }
        }

        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }
    public static void main(String [] args){
        String [] words = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("anagrams "+find(words));
    }
}
