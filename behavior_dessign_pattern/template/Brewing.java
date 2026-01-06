package behavior_dessign_pattern.template;

public abstract class Brewing {

    public Brewing(){}

    public abstract void brew();
    public abstract void addCondiments();

    public void addMilk(){
        System.out.println("adding milk");
    }

    public void addSugar(){
        System.out.println("adding sugar");
    }


}
