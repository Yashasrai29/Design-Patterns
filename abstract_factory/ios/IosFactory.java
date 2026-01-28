package abstract_factory.ios;

import abstract_factory.Button;
import abstract_factory.CheckBox;
import abstract_factory.UIFactory;

public class IosFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new IosButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new IosCheckBox();
    }
}
