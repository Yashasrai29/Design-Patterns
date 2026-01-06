package test.test2;

public class MultiSync3 {

    public static class Lock {


        public  volatile static int data = 0;

        public Lock(){
        }
        public synchronized void proceed(String name) throws Exception{
            data += 1;
            System.out.println((data % 2 == 0 ? "EVEN" : "ODD") + "-" + data+" thread-"+name);
//            Thread.sleep(500);
        }
    }
    public static void main(String [] args){
        Lock lock = new Lock();
        new Thread(() -> {
            for(int i = 1; i < 6 ; i++) {
                try {
                    lock.proceed("t1");
//                    Thread.sleep(500);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
        new Thread(() -> {
            for(int i = 1; i < 6 ; i++) {
                try {
                    lock.proceed("t2");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
}
