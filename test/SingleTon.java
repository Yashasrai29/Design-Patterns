package test;



class User{

        int age;
        String name;
        // private User(int age, String name){
        //     this.age = age;
        //     this.name = name;
        // }
        private static User user;

        private User(){

        }
        public static User getInstance(){
            if(user == null){
                synchronized(User.class){
                    if(user == null){
                        user = new User();
                    }
                }
            }
            return user;
        }
        public void setName(String name){
            this.name = name;
        }
        public void setAge(int age){
            this.age = age;
        }


    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        User user = User.getInstance();
        user.setName("Yashas");
        user.setAge(25);
        System.out.println("User : "+user);
    }
}
