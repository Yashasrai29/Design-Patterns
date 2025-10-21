package stringbuffer;

// StringBuffer is Thread Safe by Default only One Thread can Perform a Operation at a Time

class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Try programiz.pro");
        StringBuffer buffer = new StringBuffer();

        Runnable task = () -> {
            for (int i = 0; i < 5; i++) {
                String curr = Thread.currentThread().getName();
                buffer.append(curr).append(" ");
                System.out.println(curr);
                try{
                    Thread.sleep(1500);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }

        };

        Thread t1 = new Thread(task, "T1");
        Thread t2 = new Thread(task, "T2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(buffer);

    }
}
