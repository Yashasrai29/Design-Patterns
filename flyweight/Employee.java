package flyweight;

public interface Employee {

    String getSkills();

    void task();
}

class Developer implements Employee{


    private String skill;

    public Developer(String skill){
        this.skill = skill;
    }

    @Override
    public String getSkills() {
        return this.skill;
    }

    @Override
    public void task() {

    }
}

class Tester implements Employee{

    private String skill;

    public Tester(String skill){
        this.skill = skill;
    }


    @Override
    public String getSkills() {
        return this.skill;
    }

    @Override
    public void task() {
        System.out.println("");
    }
}
