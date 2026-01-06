package behavior_dessign_pattern.observer.builtIn1;

import java.util.Observable;

public class TopNewsAgency extends Observable {

    private String news;

    public void setNews(String data){
        this.news = data;
        setChanged();
        notifyObservers(data);
    }
}
