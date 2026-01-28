package abstract_factory.windows;

import abstract_factory.CheckBox;

public class WindowsCheckBox implements CheckBox {
    @Override
    public void fill() {
        System.out.println("hitting windows checkbox");
    }
}
