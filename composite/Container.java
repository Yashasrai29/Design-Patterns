package composite;

import java.util.ArrayList;

public class Container implements Component{

    private ArrayList<Component> children = new ArrayList<>();
    @Override
    public String operation() {
        int i = 0;
        String result = "Branch(";
        for(Component child : children){
            result += child.operation();
            if( i != children.size() -1){
                result += "+";
            }
            i++;
        }
        return result + ")";
    }

    @Override
    public void addChild(Component component) {
        children.add(component);
    }

    @Override
    public void removeChild(Component component) {
        children.remove(component);
    }

    @Override
    public boolean hasChild() {
        return false;
    }
}
