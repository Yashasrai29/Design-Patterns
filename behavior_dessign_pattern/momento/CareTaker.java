package behavior_dessign_pattern.momento;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {

    private List<Momento> list;

    public CareTaker(){
        this.list = new ArrayList<>();
    }

    public void addMomento(Momento momento){
        list.add(momento);
    }
    public Momento getMomento(int index){
        return list.get(index);
    }
}
