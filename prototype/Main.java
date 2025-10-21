/**
    ProtoType Design Pattern is used for creating a replica or duplicate Object and reusing it by setting
        some values to null and keeping the other values intact will it.
 */
package prototype;

public class Main {

    public static void main(String [] args){
        Prototype prototype = new Prototype("Yashas", 1, 25);
        System.out.println("p "+prototype);
        Prototype p2 = null;
        try {
            p2 = (Prototype) prototype.clone();
            p2.setName("Yashas Rai");
        }
        catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        System.out.println("p2 "+p2);
        try {
            Prototype copy = prototype.getEmpty(prototype);
            System.out.println("the copy "+copy);
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
    }
}
