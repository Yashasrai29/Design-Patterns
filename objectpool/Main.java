package objectpool;

public class Main {
//    private static ObjectPool<Employee>  employeeObjectPool = EmployeePool.getInstance(5, 10);


//    public static void m(String t){
//        long start = System.currentTimeMillis();
//        for (int i = 0; i < 100; i++) {
////            Employee e1 = employeeObjectPool.acquire();
//            Employee e1 = new Employee();
//            e1.setName("emp "+i);
//            e1.setId(i);
//            System.out.println("e1 acquired "+e1.getName()+ " with hashcode "+e1.hash()+ " t "+t);
////            employeeObjectPool.release(e1);
//        }
//        System.out.println("time taken to execute " +(System.currentTimeMillis() - start));
//    }
    public static void main(String [] args) {
        EmployeePool employeeObjectPool = EmployeePool.getInstance();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            Employee e1 = employeeObjectPool.acquire();
//            Employee e1 = new Employee();
            e1.setName("emp "+i);
            e1.setId(i);
            System.out.println("e1 acquired "+e1.getName()+ " with hashcode "+e1.hash());
            employeeObjectPool.release(e1);
        }
        System.out.println("time taken to execute " +(System.currentTimeMillis() - start));
//        Thread t1 = new Thread() {
//            @Override
//            public void run() {
//                System.out.println("Anonymous Thread 1 is executing.");
//                m("t1");
//                // Your code here
//            }
//        };
//
//        Thread t2 = new Thread() {
//            @Override
//            public void run() {
//                System.out.println("Anonymous Thread 2 is executing.");
//                m("t2");
//                // Your code here
//            }
//        };
//
//        t1.start();
//        t2.start();
    }
}
