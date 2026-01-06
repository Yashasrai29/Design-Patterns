package bigint;

import java.math.BigInteger;

public class Main {


    public static void main(String [] args){
        BigInteger a = new BigInteger("233");
        BigInteger b = new BigInteger("102");
        BigInteger pow = a.pow(2);
        BigInteger  c = a.max(b);
        System.out.println("type "+(c instanceof BigInteger ) + " pow "+pow.intValue());
        System.out.println("C "+a.equals(b));

    }
}
