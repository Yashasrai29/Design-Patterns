package decorator;

public class Cola extends BurgerDecorator{

    protected Burger burger;

    public Cola(Burger burger){
        this.burger = burger;
    }

    @Override
    public String getDescription() {
        return burger.getDescription() +" Plus coca-cola";
    }

    @Override
    public Double getCost() {
        return burger.getCost() +50.0;
    }
}
