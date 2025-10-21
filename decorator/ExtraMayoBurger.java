package decorator;

public class ExtraMayoBurger extends BurgerDecorator{

    protected Burger burger;

    public ExtraMayoBurger(Burger burger){
        this.burger = burger;
    }

    @Override
    public String getDescription() {
        return burger.getDescription()+" with Extra Mayo";
    }

    @Override
    public Double getCost() {
        return burger.getCost() + 40.0;
    }
}
