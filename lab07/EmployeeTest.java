package lab07;

public class EmployeeTest {
	public static void main(String[] args) {
		System.out.println("----------Employee----------");
		
		Employee employee1 = new Employee("Kim", 21, "Management");
		System.out.println(employee1);
		
		Employee employee2 = new Employee("Kim", 21, "Engineering");
		System.out.println(employee1.equals(employee2));
		
		Employee employee3 = new Employee("Kim", 21, "Management");
		System.out.println(employee1.equals(employee3));
		
		System.out.println("----------Manager----------");
		
		Manager manager1 = new Manager("Kim", 21, 1, "Design");
		System.out.println(manager1);
		
		Manager manager2 = new Manager("Kim", 21, 2, "Design");
		System.out.println(manager1.equals(manager2));
		
		Manager manager3 = new Manager("Kim", 21, 1, "Design");
		System.out.println(manager1.equals(manager3));
		System.out.println(manager1.equals(employee1));
		System.out.println(employee1.equals(manager3));
		
		System.out.println("----------Engineer----------");
		
		Engineer engineer1 = new Engineer("Kim", 21, "A1", "OOP");
		System.out.println(engineer1);
		
		Engineer engineer2 = new Engineer("Kim", 21, "A2", "OOP");
		System.out.println(engineer1.equals(engineer2));
		
		Engineer engineer3 = new Engineer("Kim", 21, "A1", "OOP");
		System.out.println(engineer1.equals(engineer3));
		System.out.println(engineer3.equals(employee2));
		System.out.println(employee2.equals(engineer3));
	}
}
