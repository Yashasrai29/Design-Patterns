package forkjoinpool;

import java.util.concurrent.RecursiveAction;

public class MyRecursiveAction extends RecursiveAction  {

    private Integer count;
    public MyRecursiveAction(int it){
        this.count = it;
    }

    @Override
    protected void compute() {
        if(count > 10){
            System.out.println("count "+count);
            int first = count /2 ;
            int second = count - first;
            MyRecursiveAction subTask1 = new MyRecursiveAction(first);
            MyRecursiveAction subTask2 = new MyRecursiveAction(second);
            subTask1.fork();
            subTask2.fork();
        }
        else{
            System.out.println("stopped at "+ count);
        }
    }
}
