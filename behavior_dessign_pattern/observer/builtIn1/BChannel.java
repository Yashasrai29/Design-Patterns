package behavior_dessign_pattern.observer.builtIn1;

import java.util.Observable;
import java.util.Observer;

public class BChannel implements Observer {

    private String news;
    @Override
    public void update(Observable o, Object arg) {
        this.news = ((String) arg);
        System.out.println("listening to news "+news);
    }
}
