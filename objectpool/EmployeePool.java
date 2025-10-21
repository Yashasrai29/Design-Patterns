package objectpool;

public class EmployeePool extends ObjectPool<Employee>{

    public static EmployeePool employeePool;

    private static final Integer min = 5;
    private static final Integer max = 10;

    public static EmployeePool getInstance(){
        synchronized (EmployeePool.class){
            if(employeePool == null){
                employeePool = new EmployeePool(min, max);
            }
            return employeePool;
        }
    }
    private EmployeePool(Integer min, Integer max){
        super(min, max);
    }
    @Override
    public Employee create() {
        Employee employee = new Employee();
        System.out.println("employee created with id "+employee.hash());
        return employee;
    }
}
