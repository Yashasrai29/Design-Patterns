package behavior_dessign_pattern.observer;

public class RepublicTV implements Channel{

    private String news;
    @Override
    public void update(String data) {
        this.news = data;
        System.out.println("updating Republic tv with data "+data);
    }
}
