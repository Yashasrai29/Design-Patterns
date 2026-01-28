package test;

// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;

import java.util.stream.*;

class MorganStanley {

    public static List<Integer> missing(int [] nums){
        List<Integer> list = Arrays.stream(nums).boxed().toList();
        Set<Integer> all = new HashSet<>(list);
//        int max = all.stream().sorted((a,b) -> Integer.compare(b,a)).findFirst().get();
        int max = all.stream().max(Comparator.naturalOrder()).get();
        return IntStream.rangeClosed(1, max)
                .boxed()
                .filter(e -> !all.contains(e))
                .collect(Collectors.toList());
    }

    public static List<Character> letterList(char [] arr){
        // return Arrays.stream(arr)
        return  IntStream.range(0, arr.length)
                .boxed()
                .map(e -> arr[e])
                .distinct()
                .sorted((a,b) -> a.hashCode() - b.hashCode())
                .collect(Collectors.toList());
    }
    public static void main(String[] args) {
        int [] nums = {8,4,5,3,7,1};
        System.out.println("ans "+missing(nums).toString());
        char [] letters = {'A', 'B', 'C', 'D', 'B', 'A'};
        System.out.println("ans "+letterList(letters).toString());

    }
}