package builder;

public class Builder {


    public static class User{
        int age;
        String name;

        public User(UserBuilder userBuilder){
            this.age = userBuilder.age;
            this.name = userBuilder.name;
        }
    }

    public static class UserBuilder{
        int age;
        String name;

        UserBuilder name(String name){
            this.name = name;
            return this;
        }


        UserBuilder age(int age){
            this.age = age;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }
    public static void main(String [] args){
        UserBuilder ub = new UserBuilder();
        User user = ub.age(25).build();
        System.out.println("name : "+user.name+ " age : "+user.age);
    }
}
