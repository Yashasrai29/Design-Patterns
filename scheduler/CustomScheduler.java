package scheduler;

import java.util.concurrent.*;
import java.util.Timer;
import java.util.TimerTask;

public class CustomScheduler {




        public static void schedule(){
            System.out.println("scheduling at time : "+System.currentTimeMillis());
        }

        public static class MyTask extends TimerTask{

            @Override
            public void run(){
                schedule();
            }
        }
        public static void main(String[] args) {
//             ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
//
//             service.scheduleAtFixedRate(CustomScheduler :: schedule, 0, 10, TimeUnit.SECONDS);

            Timer timer = new Timer();

            MyTask myTask = new MyTask();
            timer.scheduleAtFixedRate(myTask, 0, 5000);
        }

}
