package behavior_dessign_pattern.command;

public class SaveTextOperation implements Operation{
    private TextFile textFile;

    private String data;
    public SaveTextOperation(TextFile textFile, String data){
        this.textFile = textFile;
        this.data = data;
    }
    @Override
    public String execute() {

        System.out.println("executing and opening data "+data);
        return textFile.save(data);
    }
}
