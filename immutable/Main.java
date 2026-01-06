package immutable;

public class Main {

    public final static class User{
        private final int age;
        private final String name;
        public User(String name, int age){
            this.age = age;
            this.name = name;
        }
    }

    public static void main(String [] args){
        User user = new User("Yashas", 25);
        System.out.println("name "+user.name+ " age "+user.age);
//      Cannot assign a value to final variable age
//        user.age = 26;
    }
}
