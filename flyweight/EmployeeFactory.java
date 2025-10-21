package flyweight;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class EmployeeFactory {
    public EmployeeFactory(){
    }

    private static final ConcurrentHashMap<EmployeeTypeEnum, Employee> cache = new ConcurrentHashMap<>();

    public  Employee get(EmployeeTypeEnum type){
        Employee employee  = null;
        if(cache.get(type) != null){
            employee = cache.get(type);
        }
        else{
            switch (type){
                case TESTER -> {
                    synchronized (Tester.class) {
                        employee = new Tester("Automation tester");
                    }
                }
                case DEVELOPER -> {
                    synchronized(Developer.class){
                        employee = new Developer("Java Developer");
                    }
                }
                default -> {
                    return null;
                }
            }
            cache.put(type, employee);
        }
        return employee;
    }
}
