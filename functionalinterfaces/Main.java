package functionalinterfaces;

import java.util.function.*;

class Main {

    @FunctionalInterface
    public interface Consumer<T>{

        public static String VALUE = "STATIC KEY";

        public abstract T get(T a, T b);


        static int set(int a, int b){
            return a + b;
        }
        default int def(T a, T b){
            System.out.println("Default implementation of defaultMethod.");
            return ((int)a + (int)b);
        }

        static String staticMethod(){
            System.out.println("static implementation");
            return VALUE;
        }

    }




    public static void main(String[] args) {

        Consumer<Integer> consumer = (t1, t2) -> {
            return t1 * t2;
            // System.out.println("consumer data "+data);
        };

        System.out.println("consumer data "+consumer.get(10, 20));

        int result = consumer.def(4,3);
        System.out.println("sum "+result+" static "+Consumer.staticMethod());
    }
}
