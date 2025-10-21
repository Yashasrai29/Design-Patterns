package composite;

public interface Component {

    String operation();

    void addChild(Component component);

    void removeChild(Component component);

    boolean hasChild();
}
