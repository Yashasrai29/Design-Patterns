package behavior_dessign_pattern.iterator;

import java.util.List;

public class ListIterator<T> implements Iterator<T>{

    private List<T> list;

    private int index;


    public ListIterator(List<T> li){
        this.index = 0;
        this.list = li;
    }
    @Override
    public boolean hasNext() {
        return list.size() >= 1;
    }

    @Override
    public T next() {
        return list.remove(index);
    }
}
