package test;

public class Copy {

    public static class Address{
        String name;
        public Address(String name){
            this.name = name;
        }
    }

    public static class User implements Cloneable{

        int age;
        String name;

        Address address;
        public User(String name){
            this.name = name;
        }

        @Override
        public Object clone() throws CloneNotSupportedException{
            return super.clone();
        }
    }

    public static void main(String [] args) throws CloneNotSupportedException{
        User u1 = new User("Yashas");
        u1.address = new Address("bangalore");
        User u2 = (User) u1.clone();


        System.out.println("u1 "+u1);

//        u2.age = 25;
//        u2.name = "Ramesh";
        u2.address = new Address("hassan");
        System.out.println("u2 "+u1);
    }
}
