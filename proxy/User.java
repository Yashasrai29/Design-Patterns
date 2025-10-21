package proxy;

import javax.management.relation.Role;

public class User {
    private Integer id;
    private String name;
    private RoleTypeEnum role;

    public User(Integer id, String name, RoleTypeEnum role){
        this.id = id;
        this.name = name;
        this.role = role;
    }

    public RoleTypeEnum getRole(){
        return this.role;
    }
}
