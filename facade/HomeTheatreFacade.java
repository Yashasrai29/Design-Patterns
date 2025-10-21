package facade;

public class HomeTheatreFacade {

    private Tv tv;
    private Lights lights;
    private SoundSystem soundSystem;

    public HomeTheatreFacade(Tv tv, Lights lights, SoundSystem soundSystem){
        this.tv = tv;
        this.lights = lights;
        this.soundSystem = soundSystem;
    }

    public void start(){
        tv.turnOn();
        lights.turnOn();
        soundSystem.turnOn();
    }

    public void end(){
        tv.turnOff();
        lights.turnOff();
        soundSystem.turnOff();
    }
}
