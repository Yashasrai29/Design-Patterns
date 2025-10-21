package forkjoinpool;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String [] args){

//        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        try(ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {
            ForkJoinPool forkJoinPool = new ForkJoinPool();
            List<String> strs = Arrays.asList(new String [] {"one", "two", "three", "four"});
            strs.forEach( each -> {
                executorService.submit(() -> {
                    System.out.println("each "+each);
                });
            });
            Collection<Callable<String>> runners = Arrays.asList( new String [] {"s", "d"})
                    .stream()
                    .map(e -> (Callable<String>) () -> e)
                    .collect(Collectors.toList());
            try {
                List<Future<String>> futures = executorService.invokeAll(runners);
                futures.forEach(e -> {
                    String result = null;
                    try {
                        result = e.get();
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    } catch (ExecutionException ex) {
                        throw new RuntimeException(ex);
                    }
                    System.out.println(" printing the results "+result);
                });
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            MyRecursiveAction myRecursiveAction = new MyRecursiveAction(50);
            forkJoinPool.invoke(myRecursiveAction);

            MyrecursiveTask myrecursiveTask = new MyrecursiveTask(30);
            long result = forkJoinPool.invoke(myrecursiveTask);
            System.out.println("result " + result);
        }
    }

//    public class Run extends Callable implements Runnable{
//
//        private final String value;
//
//
//        public Run(String val){
//            this.value = val;
//        }
//        @Override
//        public void run() {
//            System.out.println("Running the run method and value "+value);
//        }
//    }
}
