package decorator;

public class ExtraChessBurger extends BurgerDecorator{

    protected Burger burger;

    public ExtraChessBurger(Burger burger){
        this.burger = burger;
    }

    @Override
    public String getDescription() {
        return burger.getDescription()+" with Extra Chess";
    }

    @Override
    public Double getCost() {
        return burger.getCost() + 30.0;
    }
}
