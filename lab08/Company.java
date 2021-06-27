package lab08;

public class Company {
    public static void main(String[] args) {
        Employee emp1 = new Manager("John Smith", 1234);
        Employee emp2 = new Engineer("Peter Anderson", 1432);
        Manager emp3 = new Manager("Jenny Allen", 1734);
        Engineer emp4 = new Engineer("Peter Coolidge", 1217);
        System.out.println(emp1);
        System.out.println(emp2);
        System.out.println(emp3);
        System.out.println(emp4);
        
        emp1.doWork(30);
        emp2.doWork(30);
        emp3.doWork(30);
        emp4.doWork(30);
        System.out.println("emp1 Salary: " + emp1.getSalary());
        System.out.println("emp2 Salary: " + emp2.getSalary());
        System.out.println("emp3 Salary: " + emp3.getSalary());
        System.out.println("emp4 Salary: " + emp4.getSalary());

        System.out.println("-".repeat(20));

        emp1.doWork(30);
        emp2.doWork(30);
        emp3.doWork(30);
        emp4.doWork(30);
        System.out.println("emp1 Salary: " + emp1.getSalary());
        System.out.println("emp2 Salary: " + emp2.getSalary());
        System.out.println("emp3 Salary: " + emp3.getSalary());
        System.out.println("emp4 Salary: " + emp4.getSalary());

    }
}
