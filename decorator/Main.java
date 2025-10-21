package decorator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String [] args){
//        Burger burger = new ZingerBurger();
//        burger = new ExtraChessBurger(burger);
//        burger = new ExtraMayoBurger(burger);
        Burger burger = new Cola(new Pepsi( new ExtraMayoBurger(new ExtraChessBurger(new ZingerBurger()))));
        Burger tandoriBurger = new Cola( new ExtraMayoBurger(new TandoriBurger()));
        System.out.println("burger price "+burger.getCost());
//        Burger zing = new ZingerBurger();
//        List<BurgerDecorator> decor = Arrays.asList(new Cola(zing), new ExtraMayoBurger(zing) );

    }
}
