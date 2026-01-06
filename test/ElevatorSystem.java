package test;

import java.util.*;

//
//Design an Elevator Control System for a building with multiple floors and multiple elevators.
//
//        Requirements:
//
//        Users can request an elevator from any floor (Up/Down button).
//
//        Elevators can move up, down, or be idle. -> state
//
//        System should assign the best elevator for a request.
//
//        Handle overload condition (when elevator is full). -> capacity
//
//        Each elevator should keep track of current floor, direction, and requests.
public class ElevatorSystem {

    public static class Elevator {
        private static Context context;

        private static PriorityQueue<Integer> up;

        private static PriorityQueue<Integer> down;

        private static Integer currentFloor;

        private static Integer capacity;

        private static Integer maxCapacity;

        public Elevator() {
            context.setState(new Idle(context));
            up = new PriorityQueue<>();
            down = new PriorityQueue<>(Comparator.reverseOrder());
        }
    }

    public static class LiftSystem{

        private static LiftSystem instance;

        private static Map<String, Elevator> elevators;

        private LiftSystem(){
            initialize();
        }

        public void initialize(){
            elevators = new HashMap<>();
        }

//        user a -> 5f  -> 9f -> up ,  G, G, G  b -> 6f -> 8f

        public String ride(int myfloor, int to, State state){
            for(Map.Entry<String, Elevator> each : elevators.entrySet()){
//                logic
                return assign(myfloor, state, to, each);
            }
            return "wait for some time";
        }

        public String assign(int myfloor, State state, int to, Map.Entry<String, Elevator> elevator){
            return "";
        }

        public static synchronized LiftSystem getInstance(){
            if(instance == null){
                synchronized(LiftSystem.class){
                    if(instance == null){
                        instance = new LiftSystem();
                    }
                }
            }
            return instance;
        }
    }

    public interface State{

    }

    public static class Down implements State{

        public Down(Context context){
            context.setState(this);
        }
    }
    public static class Up implements State{

        public Up(Context context){
            context.setState(this);
        }
    }
    public static class Idle implements State{

        public Idle(Context context){
            context.setState(this);
        }
    }


    public static class Context{
        State state;

        public Context(){
            this.state = new Idle(this);
        }
        public void setState(State state){
            this.state = state;
        }
    }

    public static void main(String [] args){
        Context context = new Context();
        Up top = new Up(context);
        Down bottom = new Down(context);
        if(context.state instanceof Up){

        }
        else if(context.state instanceof Down){

        }
        else{

        }
    }

}
