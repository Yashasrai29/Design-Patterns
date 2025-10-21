package prototype;

public class Prototype implements Cloneable{

    public Prototype(String name, Integer id, Integer age){
        this.age = age;
        this.name = name;
        this.id = id;
    }

    private String name;
    private Integer id;
    private Integer age;

    public Integer getId(){
        return this.id;
    }
    public void setId(Integer id){
        this.id = id;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public Integer getAge(){
        return this.age;
    }
    public void setAge(Integer age){
        this.age = age;
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public Prototype getEmpty(Prototype old) throws CloneNotSupportedException {
        Prototype prototype = (Prototype) old.clone();
        prototype.setName(null);
        prototype.setAge(null);
        return prototype;
    }
}
