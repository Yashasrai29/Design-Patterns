package facade;

public class SoundSystem {
    private String name;

    public SoundSystem(String name){
        this.name = name;
    }

    public void turnOn(){
        System.out.println("Turning ON the speakers");
    }
    public void turnOff(){
        System.out.println("Turning OFF the Speakers");
    }
}
