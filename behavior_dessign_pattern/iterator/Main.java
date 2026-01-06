package behavior_dessign_pattern.iterator;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {

    public static void main(String [] args){
        List<Integer> integerList = new CopyOnWriteArrayList<>(Arrays.asList(1,2,3,5,6,7,8,9));
        ListIterator<Integer> listIterator = new ListIterator<>(integerList);

        while(listIterator.hasNext()){
            System.out.println("next "+listIterator.next().toString());
        }

        BlockingDeque<Integer> deque = new LinkedBlockingDeque<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        StackIterator<Integer> stackIterator = new StackIterator<>(deque);
        while (stackIterator.hasNext()){
            System.out.println("deque next "+stackIterator.next().toString());
        }
    }
}
