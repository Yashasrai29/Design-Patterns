package concurrency;



import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class SemaPhores {

    private static Semaphore semaphore;
    private static int MAX_PERMITS;

    private static Queue<Integer> resources;
    public SemaPhores(int limits){
        this.MAX_PERMITS = limits;
        this.resources = new LinkedList<>();
        this.semaphore = new Semaphore(limits);
        initialize();
    }

    public void initialize(){
        for(int i = 1 ; i <= MAX_PERMITS ; i++){
            resources.offer(i);
        }
    }

    public static int accessResource(){
        int result = -1;
       try{
           System.out.println("trying to acquire access");
           semaphore.acquire();
           System.out.println("Acquired access successfully");
           Thread.sleep(3000);
           result = resources.poll();
           resources.offer(result);
       }catch(Exception e){
           e.printStackTrace();
       }
       finally{
           semaphore.release();
       }
       return result;
    }

    public static void main(String [] args){
        SemaPhores semaphores = new SemaPhores(3);

        for(int i = 1 ; i < 10 ; i++) {
            int finalI = i;
            new Thread(() -> {
                int val = semaphores.accessResource();
                System.out.println("accessed resource is " +val+ " thread "+ finalI);
            }).start();
        }

    }



}
