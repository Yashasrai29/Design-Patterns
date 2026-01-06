package behavior_dessign_pattern.observer.buitIn2;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class BListener implements PropertyChangeListener {

    private String news;
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("BListener "+((String) evt.getNewValue()));
        this.news = (String) evt.getNewValue();
    }
}

