package proxy;

public class Main {

    public static void main(String [] args){
        User user = new User(2, "Binod", RoleTypeEnum.USER);
        User admin = new User(1, "Admin", RoleTypeEnum.ADMIN);
        System.out.println("admin "+Proxy.getConfidential(admin));
        System.out.println("user "+Proxy.getConfidential(user));
    }
}
