package abstract_factory;

public class AbstractFactory {

    private Button button;
    private CheckBox checkBox;

    public AbstractFactory(UIFactory factory){
        this.button = factory.createButton();
        this.checkBox = factory.createCheckBox();
    }

    public void click(){
        button.hit();
        checkBox.fill();
    }
}
