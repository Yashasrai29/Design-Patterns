package behavior_dessign_pattern.template;

public class Tea extends Brewing{
    @Override
    public void brew() {
        System.out.println("brewing tea");
    }

    @Override
    public void addCondiments() {
        System.out.println("adding tea leaves and cardimum");
    }
}
