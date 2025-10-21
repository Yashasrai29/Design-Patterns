/**
    The factory Design Pattern helps in creating sub-class object with the help of super-class
        instead of you creating a new instance of the class factory will provide you.
 */
package factory;

public class Main {


    public static void main(String [] args){
        VehicleFactory factory = new VehicleFactoryImpl();
        Vehicle bike = factory.getInstance(VehicleTypeEnum.BIKE, 2);
        System.out.println("bike vehicle "+bike);
        Vehicle car = factory.getInstance(VehicleTypeEnum.CAR, 4);
        System.out.println("car vehicle "+car);
    }
}
