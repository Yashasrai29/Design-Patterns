package forkjoinpool;

import java.util.concurrent.RecursiveTask;

public class MyrecursiveTask extends RecursiveTask<Long> {

    private Integer count;
    public  MyrecursiveTask(Integer it){
        this.count = it;
    }
    @Override
    protected Long compute() {
        if(count > 5){
            int first = count / 2;
            int second = count - first;
            MyrecursiveTask subTask1 = new MyrecursiveTask(first);
            MyrecursiveTask subTask2 = new MyrecursiveTask(second);
            subTask1.fork();
            subTask2.fork();
            long result = 0;
            result += subTask1.join();
            result += subTask2.join();
            return result;
        }
        else{
            return (long) count * 3;
        }
    }
}
