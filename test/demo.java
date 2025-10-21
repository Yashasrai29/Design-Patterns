package test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class demo {



    public static void main(String [] args){

        List<Integer> list = List.of(1, 2,1,2,3);

        Optional<Integer> unq = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() == 1).map( e -> e.getKey()).findFirst();

        if(unq.isPresent()){
            System.out.println("unq "+unq.get());
        }

        int total = list.stream().reduce(0, ((e1, e2) -> e1 + e2));
        System.out.println("total "+total);


        String str = "ababc";

        Map<Character, List<Integer>> map = IntStream.range(0, str.length())
                .boxed()
                .collect(Collectors.groupingBy(i -> str.charAt(i), Collectors.toList() ));

        for(Map.Entry<Character, List<Integer>> entry : map.entrySet()){
            System.out.println("each key "+entry.getKey() + " val "+entry.getValue());
        }

//        for(int i = 0 ; i < 15 ; i++) {
//            int r = ThreadLocalRandom.current().nextInt(65, 76);
//            System.out.println("random "+r);
//        }

        for(int i = 0 ; i < 15 ; i++){
            int r = 65 + new Random().nextInt(21);
            System.out.println("random "+r);
        }
    }

}