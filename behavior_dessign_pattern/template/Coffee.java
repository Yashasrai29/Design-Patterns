package behavior_dessign_pattern.template;

public class Coffee extends Brewing{
    @Override
    public void brew() {

        System.out.println("adding coffee powder");
    }

    @Override
    public void addCondiments() {

        System.out.println("adding coco");
    }
}
