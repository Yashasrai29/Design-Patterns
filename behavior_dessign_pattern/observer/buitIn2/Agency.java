package behavior_dessign_pattern.observer.buitIn2;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Agency {

    private PropertyChangeSupport support;

    private String news;

    public Agency(){
        this.support = new PropertyChangeSupport(this);
    }

    public void addChannel(PropertyChangeListener listener){
        support.addPropertyChangeListener(listener);
    }
    public void removeChannel(PropertyChangeListener listener){
        support.removePropertyChangeListener(listener);
    }

    public void setNews(String data){
        support.firePropertyChange("news", this.news, data);
        this.news = data;
    }
}
