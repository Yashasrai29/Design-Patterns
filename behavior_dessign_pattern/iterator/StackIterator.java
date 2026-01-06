package behavior_dessign_pattern.iterator;

import java.util.Stack;
import java.util.concurrent.BlockingDeque;

public class StackIterator<T> implements Iterator<T>{

    private BlockingDeque<T> stack;

    public StackIterator(BlockingDeque<T> stack){
        this.stack = stack;
    }
    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public T next() {
        return stack.pollLast();
    }
}
