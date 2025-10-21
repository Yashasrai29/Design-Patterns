package closeable;

import java.io.Closeable;

public class CLZ implements Closeable {

    @Override
    public void close(){
        System.out.println("closing clz successfully");
    }

    public void execute(){
        System.out.println("executing tasks");
    }
}
