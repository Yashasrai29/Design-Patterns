package composite;

public class Main {

    public static void main(String [] args){
        Container tree = new Container();
        Container branch1 = new Container();
        branch1.addChild(new Leaf());
        branch1.addChild(new Leaf());
        Container branch2 = new Container();
        branch2.addChild(new Leaf());
        tree.addChild(branch1);
        tree.addChild(branch2);
        String op = tree.operation();
        System.out.println("tree "+op);
    }
}
