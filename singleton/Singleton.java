package singleton;
/**
 The Singleton Design Pattern is Used for Accessing the same static Object like cache or constant
 and for Logging Object where creating a object once and initializing the object and reusing it
 multiple times.
 */

public class Singleton {

    private int amount;

    private String item;

    public String getItem(){
        return this.item;
    }
    public void setItem(String item){
        this.item = item;
    }

    public int getAmount(){
        return this.amount;
    }

    public void setAmount(int amount){
        this.amount = amount;
    }

    public String toString(){
        return "Item : "+this.item+ " Amount : "+this.amount;
    }

    private static Singleton singleton;
    private Singleton(){}

    //    public static synchronized Singleton getInstance(){
//        if(singleton == null){
//            singleton = new Singleton();
//        }
//        return singleton;
//    }
    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }


    public static void main(String [] args){
        Singleton s1 = Singleton.getInstance();
        s1.setAmount(100);
        s1.setItem("Britania");
        System.out.println("S1 "+s1.toString());
        Singleton s2 = Singleton.getInstance();
        System.out.println("S2 "+s2.toString());
    }
}

