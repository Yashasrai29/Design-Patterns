package lift;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.locks.ReentrantLock;

public class Lift2 {

    private static Integer currentFloor = 0;
    private static ReentrantLock lock = new ReentrantLock();

    private static LiftEnum priority = null;

    private static PriorityQueue<Integer> up = new PriorityQueue<>((a, b) -> a - b);
    private static PriorityQueue<Integer> down = new PriorityQueue<>(
            new Comparator<Integer> (){
                @Override
                public int compare(Integer a, Integer b){
                    return b - a;
                }
            }
    );

    public static void process(int floor){
        lock.lock();
        LiftEnum direction = currentFloor < floor ? LiftEnum.UP : LiftEnum.DOWN;
        try{
            Thread.sleep(1000);
            if(priority == null){
                priority = direction;
            }
            switch(direction){
                case UP -> {
                    up.add(floor);
                }
                case DOWN -> {
                    down.add(floor);
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            currentFloor = floor;
            lock.unlock();
        }
    }

    public static void driver(){
        try {
            while (priority != null) {
                switch (priority) {
                    case UP -> {
                        while (!up.isEmpty()) {
                            Integer upFloor = up.poll();
                            if(currentFloor == upFloor){
                                continue;
                            }
                            System.out.println("Reached Up Floor " + upFloor + " And Came from " + Math.abs(currentFloor - upFloor) + " Floor Down");
                            currentFloor = upFloor;
                            Thread.sleep(2000);
                        }
                        if(!down.isEmpty()){
                            priority = LiftEnum.DOWN;
                        }
                        else{
                            priority = null;
                        }
                    }
                    case DOWN -> {
                        while (!down.isEmpty()) {
                            Integer downFloor = down.poll();
                            if(currentFloor == downFloor){
                                continue;
                            }
                            System.out.println("Reached Down Floor " + downFloor+ " And Came from " + Math.abs(currentFloor - downFloor) + " Floor Up");
                            currentFloor = downFloor;
                            Thread.sleep(2000);
                        }
                        if(!up.isEmpty()){
                            priority = LiftEnum.UP;
                        }
                        else{
                            priority = null;
                        }
                    }
                }
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
