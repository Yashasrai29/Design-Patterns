package factory;

public class VehicleFactoryImpl implements VehicleFactory{

    @Override
    public  Vehicle getInstance(VehicleTypeEnum type, int wheel){
        switch(type){
            case CAR -> {
                return new Car(wheel);
            }
            case BIKE -> {
                return new Bike(wheel);
            }
            default -> {
                return null;
            }
        }
    }

}
