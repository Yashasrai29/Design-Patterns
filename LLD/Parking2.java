package LLD;

import java.time.Duration;
import java.time.LocalDateTime;

public class Parking2 {

    public static abstract class Vehicle{
        private String registrationNumber;
        private String name;
        private String phone;
        private String email;

        private LocalDateTime checkIn;
        private LocalDateTime checkOut;

        private ParkingFeeStrategy feeStrategy;
        public Vehicle(String registrationNumber, String name, String phone, String email){
            this.registrationNumber = registrationNumber;
            this.phone = phone;
            this.name = name;
            this.checkIn = LocalDateTime.now();
            this.email = email;
        }
    }

    public enum VehicleType{
        CAR, BIKE, OTHERS
    }

    public static class Car extends Vehicle{

        private int airbags;

        public Car(String registrationNumber, String name, String phone, String email){
            super(registrationNumber, name, phone, email);
        }
    }

    public static class Bike extends Vehicle{

        private Boolean abs = false;

        public Bike(String registrationNumber, String name, String phone, String email){
            super(registrationNumber, name, phone, email);
        }
    }


    public static class VehicleFactory{

        public static Vehicle create(VehicleType type, String registrationNumber, String name, String phone, String email){
            switch(type){
                case CAR -> {
                    return new Car(registrationNumber, name, phone, email);
                }
                case BIKE -> {
                    return new Bike(registrationNumber, name, phone, email);
                }
                default -> {
                    return null;
                }
            }
        }
    }


    public interface ParkingFeeStrategy{

        double getCost(Vehicle vehicle);
    }


    public static class HourlyParkingFee implements ParkingFeeStrategy{

        private Double bike = 20.0;
        private Double car = 40.0;
        private Double others = 50.0;

        @Override
        public double getCost(Vehicle vehicle) {
            long totalHours = Duration.between(vehicle.checkIn , LocalDateTime.now()).toHours();
            switch (vehicle){
                case Bike b -> {
                    return totalHours * bike;
                }
                case Car c -> {
                    return totalHours * car;
                }
                default -> {
                    return totalHours * others;
                }
            }
        }
    }

    public static class PremiumMembershipFee implements ParkingFeeStrategy{

        private Double bike = 150.0;
        private Double car = 300.0;
        private Double others = 400.0;
        @Override
        public double getCost(Vehicle vehicle) {
            long totalDays = Duration.between(vehicle.checkIn , LocalDateTime.now()).toDays();
            switch (vehicle){
                case Bike b -> {
                    return totalDays * bike;
                }
                case Car c -> {
                    return totalDays * car;
                }
                default -> {
                    return totalDays * others;
                }
            }
        }
    }

}
