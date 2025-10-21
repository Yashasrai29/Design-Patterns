package test;

public class DeadLock {

    public static final String s1 = new String("First reference");

    public static final String s2 = new String("Second reference");

    public static void main(String [] args){
        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run(){
                synchronized(s1){
                    try{
//                        Thread.sleep(2000);
                        System.out.println("t1 synchronized s1");
                        synchronized(s2){
//                            Thread.sleep(2000);
                            System.out.println("t1 synchronized s1");
                        }
                    }catch(Exception e){
                        e.printStackTrace();
                    }

                }
            }
        });

        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run(){
                synchronized(s1){
                    try{
//                        Thread.sleep(2000);
                        System.out.println("t2 synchronized s1");
                        synchronized(s2){
//                            Thread.sleep(2000);
                            System.out.println("t2 synchronized s2");
                        }
                    }catch(Exception e){
                        e.printStackTrace();
                    }

                }
            }
        });

        t1.start();
        t2.start();
    }
}
