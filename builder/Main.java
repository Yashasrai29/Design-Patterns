/***
    Builder Design pattern is used for initializing the object with required and optional parameters

 */
package builder;

public class Main {

    public static void main(String [] args){
        Vehicle vehicle = new Vehicle.VehicleBuilder(4, 2).setAirBags(2).build();
        System.out.println("vehicle "+vehicle);
        Vehicle vehicle1 = new Vehicle.VehicleBuilder(2,1).build();
        System.out.println("vehicle1 "+vehicle1);

    }
}
