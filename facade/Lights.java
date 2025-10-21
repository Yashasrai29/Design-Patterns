package facade;

public class Lights {

    private String name;

    public Lights(String name){
        this.name = name;
    }

    public void turnOn(){
        System.out.println("Turning ON the Lights");
    }

    public void turnOff(){
        System.out.println("Turning OFF the lights");
    }
}
