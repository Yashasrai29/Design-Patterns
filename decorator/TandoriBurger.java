package decorator;

public class TandoriBurger extends Burger{
    @Override
    public String getDescription() {
        return "Tandori Burger";
    }

    @Override
    public Double getCost() {
        return 200.0;
    }
}
