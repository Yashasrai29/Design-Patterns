package decorator;

public class Pepsi extends BurgerDecorator{

    protected Burger burger;

    public Pepsi(Burger burger){
        this.burger = burger;
    }

    @Override
    public String getDescription() {
        return burger.getDescription()+" Plus Pepsi";
    }

    @Override
    public Double getCost() {
        return burger.getCost() + 40.0;
    }
}