package lab11;

public class Employee {
    private String name;
    private int employeeNum;
    private String department;
    private double salary;

    public Employee(String name, int employeeNum, String department, int salary) {
        this.name = new String(name);
        this.employeeNum = employeeNum;
        this.department = new String(department);
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + '\n' + "Employee Number: " + this.employeeNum + '\n' + "Department: "
                + this.department + '\n' + "Salary: " + this.salary + '\n';
    }

    public String getDepartment() {
        return new String(department);
    }

    public int getEmployeeNum() {
        return employeeNum;
    }

    public String getName() {
        return new String(name);
    }

    public double getSalary() {
        return salary;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setEmployeeNum(int employeeNum) {
        this.employeeNum = employeeNum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
