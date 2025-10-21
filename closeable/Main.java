package closeable;

public class Main {


    public static void main(String [] args){
        try(Demo1 d1 = new Demo1(); Demo2 d2 = new Demo2()){
            d2.execute();
//            d1.execute();
        }catch(Exception e){

        }

    }
}
