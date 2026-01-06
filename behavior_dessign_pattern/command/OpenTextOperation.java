package behavior_dessign_pattern.command;

public class OpenTextOperation implements Operation{

    private TextFile textFile;

    public OpenTextOperation(TextFile textFile){
        this.textFile = textFile;
    }
    @Override
    public String execute() {
        System.out.println("executing and opening ");
        return textFile.open();
    }
}
