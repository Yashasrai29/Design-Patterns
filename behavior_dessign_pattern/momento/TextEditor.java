package behavior_dessign_pattern.momento;

public class TextEditor {

    private StringBuilder context;

    public TextEditor(){
        this.context = new StringBuilder();
    }


    public void type(String data){
        context.append(data);
    }
    public String getContent(){
        return context.toString();
    }

    public Momento save(){
        return new Momento(context.toString());
    }

    public void restore(Momento momento){
        context = new StringBuilder(momento.getData());
    }
}
