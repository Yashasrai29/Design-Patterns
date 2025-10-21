package composite;

public class Leaf implements Component{

    @Override
    public String operation() {
        return "Leaf";
    }

    @Override
    public void addChild(Component component) {
//        No Implementation
    }

    @Override
    public void removeChild(Component component) {
//        No Implementation
    }

    @Override
    public boolean hasChild() {
        return false;
    }
}
