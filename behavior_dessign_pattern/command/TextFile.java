package behavior_dessign_pattern.command;

public class TextFile {

    private String file;

    public TextFile(String data){
        this.file = data;
    }

    public String save(String text){
        this.file = file + text;
        return file;
    }
    public String open(){
        return file;
    }

}
