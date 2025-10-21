package builder;

public class Vehicle {

    private Integer wheel;
    private Integer engine;
    private Integer airBags;

    public Integer getWheel(){
        return this.wheel;
    }
    public Integer getEngine(){
        return this.engine;
    }

    public Integer getAirBags(){
        return this.airBags;
    }
    private Vehicle(VehicleBuilder vehicleBuilder){
        this.wheel = vehicleBuilder.getWheel();
        this.engine = vehicleBuilder.getEngine();
        this.airBags = vehicleBuilder.getAirBags();
    }


    public static class VehicleBuilder {

        private Integer wheel;
        private Integer engine;

        //  optional field
        private Integer airBags;

        public VehicleBuilder(Integer wheel, Integer engine){
            this.wheel = wheel;
            this.engine = engine;
        }

        public VehicleBuilder setAirBags(Integer airBags){
            this.airBags = airBags;
            return this;
        }

        public Integer getWheel(){
            return this.wheel;
        }
        public Integer getAirBags(){
            return this.airBags;
        }
        public Integer getEngine(){
            return this.engine;
        }

        public Vehicle build(){
            return new Vehicle(this);
        }
    }

}
