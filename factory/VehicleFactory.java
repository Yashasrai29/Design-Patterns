package factory;

public interface VehicleFactory {

    Vehicle getInstance(VehicleTypeEnum type, int wheel);
}
