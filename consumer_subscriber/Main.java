package consumer_subscriber;


public class Main {
    public static void main(String[] args) {
//        SharedResource resource = new SharedResource();
        AsyncProcessor resource = new AsyncProcessor();
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    resource.produce(i);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    int val = resource.consume();

                    System.out.println("1 : Consumed: " + val);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer2 = new Thread(() -> {
            try {
                while (true) {
                    int val = resource.consume();

                    System.out.println("2 : Consumed: " + val);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer3 = new Thread(() -> {
            try {
                while (true) {
                    int val = resource.consume();

                    System.out.println("3 : Consumed: " + val);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

//        Thread consumer2 = new Thread(() -> {
//            try {
//                for (int i = 1; i <= 5; i++) {
//                    resource.consume();
//                    Thread.sleep(1000);
//                }
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
//        });
//
//        Thread consumer3 = new Thread(() -> {
//            try {
//                for (int i = 1; i <= 5; i++) {
//                    resource.consume();
//                    Thread.sleep(1000);
//                }
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
//        });

        producer.start();
        consumer.start();
        consumer2.start();
        consumer3.start();
    }
}

