package scheduler;

import com.sun.jdi.StringReference;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TimeRetentionCache<K, V> {


     private final ConcurrentHashMap<K, V> cache;

     private final ConcurrentHashMap<Pair<K,V>, K> ref;

    private TimeUnit unit;

    private long time;

    public TimeRetentionCache(long time, TimeUnit unit) {
        this.cache = new ConcurrentHashMap<>();
//        Comparator<V> reverseKeyComparator = Comparator.reverseOrder();
        this.ref = new ConcurrentHashMap<>();
        this.unit = unit;
        this.time = time;
        startScheduler();
    }

    public void startScheduler() {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);

        service.scheduleAtFixedRate(this::schedule, 1, 10, TimeUnit.SECONDS);

    }

    public static class Pair<K, V> {
        long time;
        K key;
        V value;
        public Pair(long time, K key, V value){
            this.time = time;
            this.key = key;
            this.value = value;
        }
    }

    public void add(K key, V value){
        cache.put(key, value);
        ref.put(new Pair(System.currentTimeMillis(), key, value), key);
    }

    public void remove(K key){
        cache.remove(key);
        ref.values().remove(key);
    }


    public void schedule() {
        System.out.println("scheduling at time : " + System.currentTimeMillis()+ " keys "+cache.keySet().toString()+" ref "+ref.values().toString() );
        long validTill = System.currentTimeMillis();
        switch(unit){
            case DAYS:
                validTill += time * (24 * 60 * 60 * 1000);
            case HOURS:
                validTill += time * (60 * 60 * 1000);
            case MINUTES:
                validTill += time * (60 * 1000);
            case SECONDS:
                validTill += time * (1000);
        }
        long finalValidTill = validTill;
        List<K> keys = ref.entrySet().stream().filter(e -> e.getKey().time <= finalValidTill).map(e -> e.getValue()).collect(Collectors.toList());
        ref.values().removeAll(keys);
        cache.keySet().removeAll(keys);

 }


    public static void main(String[] args) {

        TimeRetentionCache<String, String> cache1 = new TimeRetentionCache<>(15, TimeUnit.SECONDS);
        try {
            cache1.add("1", "Yashas");
//            Thread.sleep(10000);
            cache1.add("2", "Sita");
//            Thread.sleep(10000);
            cache1.add("3", "Saleem");
            Thread.sleep(10);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}


//    public static class MyTask extends TimerTask {
//
//        @Override
//        public void run() {
//            schedule();
//        }
//    }
// Timer timer = new Timer();
// MyTask myTask = new MyTask();
// timer.scheduleAtFixedRate(myTask, 0, 5000);

