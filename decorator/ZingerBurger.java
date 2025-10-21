package decorator;

public class ZingerBurger extends Burger{
    @Override
    public String getDescription() {
        return "Zinger Burger";
    }

    @Override
    public Double getCost() {
        return 150.0;
    }
}
