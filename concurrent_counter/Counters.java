package concurrent_counter;

import jdk.internal.vm.annotation.Contended;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.ReentrantLock;

public class Counters {

    public static class ConcurrentCounter{
        private volatile Segment [] counterHashTable;

        private final Integer MAX_LENGTH;

        public ConcurrentCounter(Integer length){
            MAX_LENGTH = length;
            counterHashTable = new Segment[MAX_LENGTH];
        }

        public void initialize(){
//            for(int i = 0 ; i < MAX_LENGTH; i++){
//                counterHashTable[i] = new Segment();
//            }
        }

        private int getIndex(long timeMillis){
            return (int) (timeMillis % MAX_LENGTH);
        }
        public void increment(long timeMillis){
            int index = getIndex(timeMillis);
            if(counterHashTable[index] == null){
                synchronized (counterHashTable){
                    if(counterHashTable[index] == null) {
                        counterHashTable[index] = new Segment();
                    }
                    counterHashTable[index].lock();
                    counterHashTable[index].increment(index);
                    counterHashTable[index].unlock();
                }
            }
            else{
                Segment segment = counterHashTable[index];
                try{
                    segment.lock();
                    segment.increment(index);
                }
                catch (Exception e){

                }
                finally{
                    segment.unlock();
                }
            }
        }

        public Integer getCounter(){
            Integer count = 0;
            for(Segment each : counterHashTable){
                if(each != null) {
                    try {
                        each.lock();
                        count += each.getCounter();
                    } catch (Exception e) {

                    } finally {
                        each.unlock();
                    }
                }
            }
            return count;
        }
    }

    public static class Segment extends ReentrantLock {
        @Contended
//        private volatile int counter;
//        private LongAdder longAdder;
        private AtomicInteger counter;
        public Segment(){
//            this.counter = 0;
//            this.longAdder = new LongAdder();
            this.counter = new AtomicInteger(0);
        }

        public void increment(int index){
            System.out.println("index "+index+" thread "+Thread.currentThread().getName());
//            counter++;
//            longAdder.increment();
            counter.incrementAndGet();
        }

        public Integer getCounter(){
//            return this.counter;
//            return this.longAdder.intValue();
            return counter.get();
        }
    }

    public static void main(String [] args){
        ConcurrentCounter counter = new ConcurrentCounter(3);
        Thread t1 = new Thread( () ->{
            try{
             for(int i = 1 ; i < 50; i++){
                 counter.increment(System.currentTimeMillis());
             }
            }catch (Exception e){

            }
        });
        Thread t2 = new Thread( () ->{
            try{
                for(int i = 1 ; i < 50; i++){
                    counter.increment(System.currentTimeMillis());
                }
            }catch (Exception e){

            }
        });
        Thread t3 = new Thread( () ->{
            try{
                for(int i = 1 ; i < 50; i++){
                    counter.increment(System.currentTimeMillis());
                }
            }catch (Exception e){

            }
        });

        t1.start();
        t2.start();
        t3.start();
        try{
            t1.join();
            t2.join();
            t3.join();
        }
        catch(Exception e){

        }
        try {
            Thread.sleep(8000);
            System.out.println("counter value "+counter.getCounter());
        }catch (Exception e){

        }
    }
}
