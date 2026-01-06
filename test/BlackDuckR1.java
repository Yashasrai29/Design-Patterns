package test;


import java.util.*;
import java.util.Map.Entry;
import java.util.stream.*;
public class BlackDuckR1 {

    // Online Java Compiler
// Use this editor to write, compile and run your Java code online

// SWISS --> print first non repeating character




    // public final class Car{


    // }

    public static void swap(int [] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void twoPointers(int [] nums){
        // 4,0,1,2,0
        int start = 0, end = nums.length-1;
        while(start <= end){
            if(nums[start] == 0){
                swap(nums, start, end);
                end--;
            }
            else{
                start++;
            }
        }
    }

    public static List<Entry<Character, Long>>  nonRepeating(String str){
        Map<Character, Integer> map = new HashMap<>();
        for(char c : str.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // O(n)

        for(int i = 0 ; i < str.length() ; i++){
            if(map.get(str.charAt(i)) == 1){
                // System.out.println("first non repeating char "+i);
                break;
            }
        }
        // best case - log(n) worst - O(n)

        // total 2(n)

        // Arrays.asList(str.toCharArray()).stream().forEach( e -> {
        //     System.out.println("each "+e);
        //     // return e
        // });


        List<Map.Entry<Character, Long>> collect = IntStream.range(0, str.length())
                .boxed()
                .collect(Collectors.groupingBy(e -> str.charAt(e), Collectors.counting()))
                .entrySet()
                .stream()
                .map(e -> {
                    if (e.getValue() == 1) {
                        return e;
                    }
                    return null;
                })
                .filter(Objects::nonNull)
//                .filter(e -> e.getValue() == 1)
                .collect(Collectors.toList());
        return collect;


    }

    public static void main(String[] args) {
        // nonRepeating("SWISS");
        int [] nums = {4,0,1,2,0};
        twoPointers(nums);
        System.out.println("ans "+Arrays.toString(nums));

        // select e.*, max(e.salary) as ms from employee as e order by ms DESC offset 1 limit 1;

        List<Entry<Character, Long>> list = nonRepeating("SWISS");
        System.out.println("size "+list.size());

        for(Map.Entry<Character, Long> entry : list){
            System.out.println("key "+entry.getKey() + " value "+entry.getValue());
        }
    }

}
