package behavior_dessign_pattern.momento;

public class Main {

    public static void main(String [] args){
        TextEditor textEditor = new TextEditor();
        CareTaker careTaker = new CareTaker();
        textEditor.type("Hello");
        careTaker.addMomento(textEditor.save());
        textEditor.type(" World");
        careTaker.addMomento(textEditor.save());
        textEditor.restore(careTaker.getMomento(0));
        System.out.println("current context "+textEditor.getContent());
        textEditor.restore(careTaker.getMomento(1));
        System.out.println("current context "+textEditor.getContent());
    }

}
