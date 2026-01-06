package behavior_dessign_pattern.template;

public class Helper {

    private Brewing brewing;

    public Helper(Brewing b){
        this.brewing = b;
    }

    public void prepare(){
        brewing.brew();
        brewing.addCondiments();
        brewing.addMilk();
        brewing.addSugar();
    }
}
