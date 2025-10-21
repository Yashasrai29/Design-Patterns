package facade;

public class Tv {

    private String name;
    public Tv(String name){
        this.name = name;
    }
    public void turnOn(){
        System.out.println("Turning ON the television");
    }
    public void turnOff(){
        System.out.println("Turning OFF the television");
    }
}
