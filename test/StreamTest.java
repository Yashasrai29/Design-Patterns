package test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamTest {

    public static List<Integer> numbers = List.of(5,6,6,7,8,9, 1, 2,2,3,4);
    public static List<String> words = List.of("yashas", "Sitarami", "shravani", "chandana");

    public static List<String> subjects = List.of("Maths", "PT", "Science", "English", "Hindi");


    public static void max(){
//        List<Integer> nums = numbers;
        Optional<Integer> max = numbers.stream().max((e1, e2) -> Integer.compare(e1, e2));
        if(max.isPresent()){
            System.out.println("max value of numbers : "+max.get());
        }
    }

    public static void even(){
        List<Integer> vals = numbers.stream().filter(e -> e % 2 == 0).collect(Collectors.toList());
        if(!vals.isEmpty()){
            System.out.println("even values : " +vals.toString());
        }
    }

    public static void upperCase(){
        List<String> casedWords = words.stream().map(String::toUpperCase).collect(Collectors.toList());
        if(!casedWords.isEmpty()){
            System.out.println("uppercase : "+casedWords.toString());
        }
    }

    public static void duplicates(){
        List<Integer> uniques = numbers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().map(e -> e.getKey()).collect(Collectors.toList());
        if(!uniques.isEmpty()){
            System.out.println("uniques : "+uniques.toString());
        }

    }

    public static void sort(){
        List<Integer> sortedOrder = numbers.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        if(!sortedOrder.isEmpty()){
            System.out.println("sorted order : "+sortedOrder.toString());
        }
        List<Integer> descendingOrder = numbers.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        if(!sortedOrder.isEmpty()){
            System.out.println("sorted descending order : "+descendingOrder.toString());
        }
    }

    public static void condition(){
        List<String> allowed = subjects.stream().filter(e -> e.length() > 5).collect(Collectors.toList());
        if(!allowed.isEmpty()){
            System.out.println("condition "+allowed.toString());
        }
    }

    public static void distinct(){
        List<Integer> elements = numbers.stream().distinct().collect(Collectors.toList());
        if(!elements.isEmpty()){
            System.out.println("distinct elements "+elements.toString());
        }
    }

    public static void count(){
        Long count = numbers.stream().filter(e -> e > 5).count();
        System.out.println("count "+count);
    }

    public static void first(){
        Optional<Integer> first = numbers.stream().findFirst();
        if(first.isPresent()){
            System.out.println("find first "+first.get());
        }
    }

    public static void skip(){
        List<Integer> skip = numbers.stream().skip(2).collect(Collectors.toList());
        System.out.println("skip 2 : "+skip.toString());
    }

    public static void join(){
//        String join = String.join(",", subjects);
        String join = subjects.stream().collect(Collectors.joining(", "));
        System.out.println("join "+join);
    }

    public static void sum(){
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println("sum "+sum);
    }

    public static void nthHighest(int n){
        int highest = numbers.stream().sorted(Comparator.reverseOrder()).distinct().skip(n-1).findFirst().get();
        System.out.println("nth highest val "+highest);
    }

    public static void groupBy(){
        Map<Integer, List<String>> map = subjects.stream().collect(Collectors.groupingBy((e) -> e.length(), Collectors.toList()));
        for(Map.Entry<Integer, List<String>> entry : map.entrySet()){
            System.out.println("key "+entry.getKey()+" value "+entry.getValue().toString());
        }
    }

    public static void capitalCase(){
        List<String> capitalCase = words.stream().map(e -> {
            if(e.length() > 0) {
                char[] chars = e.toCharArray();
                chars[0] = Character.toUpperCase(chars[0]);
                return new String(chars);
            }
            else{
                return null;
            }
        }).filter(Objects::nonNull).collect(Collectors.toList());
        System.out.println("capitalcase : "+capitalCase.toString());
    }

    public static void evenOrOdd(){
        Map<String, List<Integer>> map = numbers.stream().collect(Collectors.groupingBy((e)-> e % 2== 0 ? "EVEN": "ODD", Collectors.toList()));
        for(Map.Entry<String, List<Integer>> entry : map.entrySet()){
            System.out.println("key "+entry.getKey()+" value "+entry.getValue());
        }
    }
    public static void main(String [] args){
        max();
        even();
        upperCase();
        duplicates();
        sort();
        condition();
        distinct();
        count();
        first();
        skip();
        join();
        sum();
        nthHighest(4);
        groupBy();
        capitalCase();
        evenOrOdd();
    }


}
