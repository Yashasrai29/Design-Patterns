package proxy;

public class Proxy {

    public static String getConfidential(User user){
        if ( !user.getRole().name().equals(RoleTypeEnum.ADMIN.name()) ){
            throw new RuntimeException("Unauthorized to access this resource");
        }
        else{
            return "password :- A4min-24";
        }
    }
}
