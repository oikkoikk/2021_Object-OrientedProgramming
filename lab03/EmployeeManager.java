package lab03;

public class EmployeeManager {

    public static void main(String[] args) {
        Employee James = new Employee("James Wright", 42, "Manager", 20000);
        Employee Amy = new Employee("Amy Smith", 27, "Design Coordinator", 8000, 15);
        Employee Peter = new Employee("Peter Coolidge", 32, "Assistant Manager", 12000, 7);
        Employee John = new Employee("John Doe", 22, "Engineer", 10000, 10);

        System.out.println(James);
        System.out.println(Amy);
        System.out.println(Peter);
        System.out.println(John);

        Employee Jun = new Employee("Lee Jong Jun", 22, "Student", 987654, 35);
        if (Jun.equals(Amy)) {
            System.out.println("같은 직원입니다.");
        } else {
            System.out.println("다른 직원입니다.");
        }

        James.vacation();
        Peter.vacation();

        System.out.println(James);
        System.out.println(Amy);
        System.out.println(Peter);
        System.out.println(John);
        System.out.println(Jun);
    }

}
