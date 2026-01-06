package behavior_dessign_pattern.command;

import java.util.ArrayList;
import java.util.List;

public class Executor {

    private static List<Operation> operationList = new ArrayList<>();

    public Executor(){}

    public String execute(Operation operation){
        operationList.add(operation);
        return operation.execute();
    }
}
