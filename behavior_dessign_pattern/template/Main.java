package behavior_dessign_pattern.template;

public class Main {

    public static void main(String [] args){
        Coffee coffee = new Coffee();
        Tea tea = new Tea();
//        Helper helper = new Helper(coffee);
        Helper helper = new Helper(tea);
        helper.prepare();
    }
}
