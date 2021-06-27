package lab08;

public abstract class Employee {
    private String name;
    private int employeeNum;
    private String department;
    private int workHrs;
    private double salary;

    public Employee(String name, int employeeNum) {
        this.name = name;
        this.employeeNum = employeeNum;
        this.workHrs = 0;
        this.salary = 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (getClass() != obj.getClass()) {
            return false;
        } else {
            Employee emp = (Employee) obj;
            return this.name.equals(emp.name) && this.employeeNum == emp.employeeNum;
        }
    }

    public String toString() {
        return this.name + ", " + this.employeeNum;
    }

    public void doWork(int hrs) {
        this.workHrs += hrs;
        this.salary = getPaid();
    }

    public abstract double getPaid();

    public String getDepartment() {
        return department;
    }

    public int getWorkHrs() {
        return workHrs;
    }

    public double getSalary() {
        return salary;
    }

    public void setDepartment(String department) {
        this.department = new String(department);
    }
}
