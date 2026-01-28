package abstract_factory.windows;

import abstract_factory.Button;
import abstract_factory.CheckBox;
import abstract_factory.UIFactory;

public class WindowsFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new WindowsCheckBox();
    }
}
