package test;

public class Builder {


    public static class User{
        int age;
        String name;

        private User(UserBuilder userBuilder){
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

    public static void helper(UserBuilder ub2, String name, int age){
        if(!name.isEmpty()){
            ub2.name(name);
        }
        if(age != 0){
            ub2.age(age);
        }
    }
    public static void main(String [] args){
        UserBuilder ub = new UserBuilder();
        User user = ub.age(25).build();
        System.out.println("name : "+user.name+ " age : "+user.age);
        String name = "";
        int age =25;
        UserBuilder ub2 = new UserBuilder();
        helper(ub2, name, age);
        User user2 = ub2.age(25).build();
        System.out.println("user2 "+user2.name+" age "+user2.age);
    }
}
