package abstract_factory.ios;

import abstract_factory.CheckBox;

public class IosCheckBox implements CheckBox {
    @Override
    public void fill() {
        System.out.println("hitting ios checkbox");
    }
}
