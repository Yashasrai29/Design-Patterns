package lift;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Lift {
    private static final List<Integer> queue = new ArrayList<>();
    private static Integer current = 0;

    private static final ReentrantLock lock = new ReentrantLock();

    public static void process(Integer floor){
        lock.lock();
        try{
            boolean found = false;
            if(queue.isEmpty()){
                queue.add(floor);
                found = true;
            }
            if(!found){
                for ( int i = 0 ; i < queue.size() ; i++ ) {
                    if(floor > 0 ){
                        if(floor == queue.get(i)){
                            found = true;
                            break;
                        }
                        else if(floor < queue.get(i)){
                            queue.add(i, floor);
                            found = true;
                            break;
                        }
                        else{
                            queue.add(floor);
                            found = true;
                            break;
                        }
                    }
                    else if(floor <= 0){
                        if(floor == queue.get(i)){
                            found = true;
                            break;
                        }
                        else if(floor > queue.get(i)){
                            queue.add(i, floor);
                            found = true;
                            break;
                        }
                    }
                }
            }
            if(!found){
                queue.add(floor);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            lock.unlock();
        }
    }

    public static void driver(){
        while(!queue.isEmpty()){
            try{
                Integer element = queue.remove(0);
                current = element;
                System.out.println("Going to "+element);
                Thread.sleep(3000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }




}
