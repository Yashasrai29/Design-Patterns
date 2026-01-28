package abstract_factory;

import abstract_factory.ios.IosFactory;
import abstract_factory.windows.WindowsFactory;

public class Main {

    public static void main(String [] args){
//        AbstractFactory abstractFactory = new AbstractFactory(new IosFactory());
        AbstractFactory abstractFactory = new AbstractFactory(new WindowsFactory());
        abstractFactory.click();
    }
}
