package behavior_dessign_pattern.observer;

public class AajTakChannel implements Channel{

    private String news;
    @Override
    public void update(String data) {
        this.news = data;
        System.out.println("updating aaj tak with data "+data);
    }
}
