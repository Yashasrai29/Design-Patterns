import com.sun.jdi.StringReference;

import java.lang.ref.WeakReference;

/**
    Reference Initialization Of Object, Object Referencing To Another Variable Will Not Create a New
        Copy Or Replica Of That Object Instead It Points To The Same Memory Location, Changes Made To
        The New Reference Variable Will Still Reflect To Referenced Object.
 */

public class ReferenceInit {

    private Integer id;
    private String name;
    public ReferenceInit(Integer id, String name){
        this.id = id;
        this.name = name;
    }
    public void setName(String name){
        this.name = name;
    }
    public static void main(String [] args){
        ReferenceInit referenceInit = new ReferenceInit(1, "One");
        ReferenceInit referenceInit2 = referenceInit;
        referenceInit2.setName("Oooonnnneeeee");
        System.out.println("tp "+ referenceInit.name+ " memory-lc "+ referenceInit);
        System.out.println("tp2 "+ referenceInit2.name+ " memory-lc "+ referenceInit2);

    }
}
