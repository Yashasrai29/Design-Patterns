package facade;

public class Main {

    public static void main(String [] args){
        Tv tv = new Tv("Sony");
        SoundSystem soundSystem = new SoundSystem("JBL");
        Lights lights = new Lights("Panasonic");
        HomeTheatreFacade homeTheatre = new HomeTheatreFacade(tv, lights, soundSystem);
        homeTheatre.start();
        try {
            Thread.sleep(1000 * 120);
            homeTheatre.end();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
