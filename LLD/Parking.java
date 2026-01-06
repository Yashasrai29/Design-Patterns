package LLD;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// Designing parking lot for particular building
public class Parking {


    public static class ParkingLot{

        private static Map<Integer, Lot> parking;

        private static Map<String, Vehicle> register;

        private static Map<String, Vehicle> audit;


        private static Integer BIKE_HOURLY_RATE = 20;
        private static Integer CAR_HOURLY_RATE = 40;
        private static Integer TRUCK_HOURLY_RATE = 60;
        private static ParkingLot instance;

        private ParkingLot(){
            this.parking = new ConcurrentHashMap<>();
            this.register = new ConcurrentHashMap<>();
            this.audit = new ConcurrentHashMap<>();
        }

//        We can have RBAC for this control before starting
        public void setParkingFloorWise(Integer floor, Lot lot){
            parking.put(floor, lot);
        }

//        SingleTon Design pattern
        public static ParkingLot getInstance(){
            if(instance == null){
                synchronized (ParkingLot.class){
                    if (instance == null){
                        instance = new ParkingLot();
                    }
                }
            }
            return instance;
        }

        public List<Integer> getAvailableSlots(Integer floor, VehicleTypeEnum type){
            if(parking.containsKey(floor)){
                Lot floorParkingLot = parking.get(floor);
                switch(type){
                    case CAR -> {
                        String [] cars = floorParkingLot.cars;
                        return IntStream.range(0, cars.length).boxed().filter(index -> cars[index] == null).collect(Collectors.toList());
                    }
                    case BIKE -> {
                        String [] bikes = floorParkingLot.bikes;
                        return IntStream.range(0, bikes.length).boxed().filter(index -> bikes[index] == null).collect(Collectors.toList());
                    }
                    case TRUCK -> {
                        String [] trucks = floorParkingLot.trucks;
                        return IntStream.range(0, trucks.length).boxed().filter(index -> trucks[index] == null).collect(Collectors.toList());
                    }
                    default -> {
                        throw new IllegalArgumentException("Invalid selection");
                    }
                }
            }
            else{
                throw new IllegalArgumentException("Invalid floor selection");
            }
        }

        public synchronized Boolean checkIn(Integer floor, Integer slot, Vehicle vehicle){
            Lot currentLot = parking.get(floor);
            synchronized (currentLot) {
                switch (vehicle.vehicleTypeEnum) {
                    case CAR -> {
                        if (currentLot.cars[slot] != null) {
                            throw new IllegalArgumentException("For floor " + floor + " slot " + slot + " is already booked, try with other slot");
                        }
                        currentLot.cars[slot] = vehicle.registrationNumber;
                        currentLot.currentCars++;
                    }
                    case BIKE -> {
                        if (currentLot.bikes[slot] != null) {
                            throw new IllegalArgumentException("For floor " + floor + " slot " + slot + " is already booked, try with other slot");
                        }
                        currentLot.bikes[slot] = vehicle.registrationNumber;
                        currentLot.currentBikes++;
                    }
                    case TRUCK -> {
                        if (currentLot.trucks[slot] != null) {
                            throw new IllegalArgumentException("For floor " + floor + " slot " + slot + " is already booked, try with other slot");
                        }
                        currentLot.trucks[slot] = vehicle.registrationNumber;
                        currentLot.currentTrucks++;
                    }

                    default -> {
                        return false;
                    }
                }
                register.put(vehicle.registrationNumber, vehicle);
                return true;
            }
        }

        public Boolean checkOut(String regNo) throws Exception {
            if(!register.containsKey(regNo)){
                throw new RuntimeException("registration number not found");
            }
            Vehicle vehicle = register.get(regNo);
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter 1 you get fair");
            String input = scanner.nextLine();
            if(input == "1") {
                LocalDateTime now = LocalDateTime.now();
                Duration duration = Duration.between(vehicle.checkInTime, now);
                Long hours = duration.toHours();
                int amount = 0;
                switch (vehicle.vehicleTypeEnum){
                    case CAR -> {
                        amount = CAR_HOURLY_RATE;
                    }
                    case BIKE -> {
                        amount = BIKE_HOURLY_RATE;
                    }
                    case TRUCK -> {
                        amount = TRUCK_HOURLY_RATE;
                    }
                }
                Long totalFair = amount * hours;
                System.out.println("total fair : "+totalFair);
                System.out.println("select payment option "+PaymentEnum.values());
                String input2 = scanner.nextLine();
                Payment payment = null;
                switch (input2){
                    case "UPI" ->{
                        payment = new UPIPayments();
                    }
                    case "CREDITCARD" -> {
                        payment = new CreditCardPayment();
                    }
                    default -> {
                        throw new RuntimeException("Enter valid payment method");
                    }
                }
                if(payment.pay()){
                    Lot lot = parking.get(vehicle.floor);
                    synchronized (lot) {
                        switch (vehicle.vehicleTypeEnum) {
                            case CAR -> {
                                lot.cars[vehicle.slNo] = null;
                            }
                            case BIKE -> {
                                lot.bikes[vehicle.slNo] = null;
                            }
                            case TRUCK -> {
                                lot.trucks[vehicle.slNo] = null;
                            }
                        }
                        vehicle.checkOutTime = now;
                        vehicle.payment = true;
                        audit.put(vehicle.registrationNumber, vehicle);
                        register.remove(vehicle.registrationNumber);
                    }
                }
                else{
                    throw new RuntimeException("Retry");
                }
            }
            return false;
        }

    }

    public enum PaymentEnum{
        UPI, CREDITCARD
    }

    public interface Payment{
        boolean pay();
    }

    public static class UPIPayments implements Payment{

        @Override
        public boolean pay() {
            System.out.println("opted upi payment and payment successful");
            return true;
        }
    }

    public static class CreditCardPayment implements Payment{

        @Override
        public boolean pay() {
            System.out.println("opted creditcard payment and payment successful");
            return true;
        }
    }


    public static class Vehicle{

        UUID id;
        String registrationNumber;

        LocalDateTime checkInTime;

        String name;

        LocalDateTime checkOutTime;

//        Optional
        String emailOrPhone;

        VehicleTypeEnum vehicleTypeEnum;

        Integer floor;

        Integer slNo;

        Boolean payment;

        public Vehicle(String vehicleNumber, String name, String emailOrPhone, VehicleTypeEnum type, Integer floor, Integer slNo){
            this.id = UUID.randomUUID();
            this.name = name;
            this.vehicleTypeEnum = type;
            this.registrationNumber = vehicleNumber;
            this.emailOrPhone = emailOrPhone;
            this.checkInTime = LocalDateTime.now();
            this.floor = floor;
            this.slNo = slNo;
            this.payment = false;
        }

    }

    public static class Lot{
        String [] bikes;
        String [] cars;
        String [] trucks;

        Integer currentBikes;
        Integer currentCars;
        Integer currentTrucks;

        public Lot(Integer maxBikes, Integer maxCars, Integer maxTrucks){
            this.bikes = new String[maxBikes];
            this.cars = new String[maxCars];
            this.trucks = new String[maxTrucks];
            this.currentBikes = 0;
            this.currentCars = 0;
            this.currentTrucks = 0;
        }
    }
    public enum VehicleTypeEnum{
        CAR, BIKE, TRUCK
    }


    public static void main(String [] args) throws Exception {
        ParkingLot parkingLot = ParkingLot.getInstance();
        Lot l1 = new Lot(30, 15, 5);
        Lot l2 = new Lot(30, 15, 5);
        Lot l3 = new Lot(30, 15, 5);
        parkingLot.setParkingFloorWise(1, l1);
        parkingLot.setParkingFloorWise(-1, l2);
        parkingLot.setParkingFloorWise(-2, l3);

       Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Enter you choice 1 for checkIn 2 for checkOut");
            Integer input = scanner.nextInt();
            scanner.nextLine();
            if(input == 1){
                System.out.println("Enter the floor ");
                Integer floor = scanner.nextInt();
                scanner.nextLine();
                System.out.println(" slots "+parkingLot.getAvailableSlots(floor, VehicleTypeEnum.BIKE));
                System.out.println("Enter slot number");
                Integer slot = scanner.nextInt();
                scanner.nextLine();
                System.out.println("enter the vehicle in the following format as vehicle");
                String requestBody = scanner.nextLine();
                String [] requestBodyArray = requestBody.split("\\s");
                System.out.println("give vehicle type "+VehicleTypeEnum.values());
                VehicleTypeEnum type = null;
                switch (scanner.nextLine()){
                    case "CAR" -> {
                        type = VehicleTypeEnum.CAR;
                    }
                    case "BIKE" -> {
                        type = VehicleTypeEnum.BIKE;
                    }
                    case "TRUCK" -> {
                        type = VehicleTypeEnum.TRUCK;
                    }
                }
                Vehicle vehicle = new Vehicle(requestBodyArray[0], requestBodyArray[1], requestBodyArray[2], type, floor, slot);
                Boolean res = parkingLot.checkIn(floor, slot, vehicle);
                if(res) {
                    System.out.println("successfully checked in with vehicle number " + vehicle.registrationNumber);
                }
            }
            else if(input == 2){
                String regNo = scanner.nextLine();
                scanner.nextLine();
                parkingLot.checkOut(regNo);
            }
        }
    }



}
