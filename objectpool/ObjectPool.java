package objectpool;

import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class ObjectPool<T> {

    private ConcurrentLinkedQueue<T> pool;

    private final Integer MIN_SIZE;
    private final Integer MAX_SIZE;


    public ObjectPool(Integer min, Integer max){
        pool = new ConcurrentLinkedQueue<>();
        this.MIN_SIZE = min;
        this.MAX_SIZE = max;
        initialize(min);
    }

    private void initialize(int size) {
        for(int i = 0 ; i < size ; i++){
            pool.add(create());
        }
    }
    public abstract T create();

    public synchronized T acquire(){
        T object = pool.poll();
        if(object == null){
            if(pool.size() <= MAX_SIZE ){
                object = create();
                pool.add(object);
            }
        }
        return object;
    }

    public synchronized void release(T object){
        if(pool.size() <= MIN_SIZE){
            pool.offer(object);
        } else{
            object = null;
        }
    }

}
