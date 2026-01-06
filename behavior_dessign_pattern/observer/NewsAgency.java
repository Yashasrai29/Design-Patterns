package behavior_dessign_pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class NewsAgency {

    String news;
    List<Channel> channels;

    public NewsAgency(){
        this.channels = new ArrayList<>();
    }

    public void addChannel(Channel channel){
        channels.add(channel);
    }


    public void removeChannel(Channel channel){
        channels.remove(channel);
    }

    public void addNews(String data){
        news = data;
        for(Channel channel : channels){
            channel.update(news);
        }
    }

}
