package behavior_dessign_pattern.observer.buitIn2;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AListener implements PropertyChangeListener {

    private String news;
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("AListener "+((String) evt.getNewValue()));
        this.news = (String) evt.getNewValue();
    }
}
