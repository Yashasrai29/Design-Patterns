package behavior_dessign_pattern.momento;

public class Momento {

    private String data;

    public Momento(String text){
        this.data = text;
    }
    public String getData(){
        return this.data;
    }
}
