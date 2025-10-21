package flyweight;

public class Main {

    public static void main(String [] args) {
        for (int i = 0; i < 10; i++) {
            EmployeeFactory factory = new EmployeeFactory();
            Employee e = factory.get( i % 2 == 0 ? EmployeeTypeEnum.DEVELOPER : EmployeeTypeEnum.TESTER);
            System.out.println("employee "+e.getSkills()+ " stack "+e);
        }
    }
}
