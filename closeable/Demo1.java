package closeable;

import java.io.Closeable;

public class Demo1 implements AutoCloseable {

    @Override
    public void close(){
        System.out.println("closing demo1 successfully");
    }
}
