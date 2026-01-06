package behavior_dessign_pattern.command;

public class Main {

    public static void main(String [] args){
        Executor executor = new Executor();
        OpenTextOperation op = new OpenTextOperation(new TextFile("hello how are you"));
        SaveTextOperation save = new SaveTextOperation(new TextFile("Save this file "), "with additional information");
        executor.execute(save);
        executor.execute(op);
    }
}
