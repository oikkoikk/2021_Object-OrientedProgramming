package lab07;

public class Employee {
    private String name;
    private int employeeNum;
    private String department;

    public Employee(String name, int employeeNum, String department) {
        this.name = name;
        this.employeeNum = employeeNum;
        this.department = department;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (getClass() != obj.getClass()) {
            return false;
        } else {
            Employee emp = (Employee) obj;
            return this.name.equals(emp.name) && this.employeeNum == emp.employeeNum
                    && this.department.equals(emp.department);
        }
    }

    public String toString() {
        return "Name : " + this.name + "\nEmp# : " + employeeNum + "\nDepartment : " + department;
    }

    public String getDepartment() {
        return department;
    }

    public int getEmployeeNum() {
        return employeeNum;
    }

    public String getName() {
        return name;
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
}
