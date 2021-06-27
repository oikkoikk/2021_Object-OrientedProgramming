package lab08;

public class Manager extends Employee {
    private double overtimeRate;
    private double rate;
    private int regularHrs;

    public Manager(String name, int employeeNum) {
        super(name, employeeNum);
        this.rate = 4.0;
        this.overtimeRate = 8.0;
        this.regularHrs = 40;
        this.setDepartment("Management");
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (getClass() != obj.getClass()) {
            return false;
        } else {
            Manager man = (Manager) obj;
            return super.equals(man);
        }
    }

    public String toString() {
        return super.toString() + ", " + this.getDepartment();
    }

    public double getPaid() {
        int overtimeHrs = this.getWorkHrs() - this.regularHrs;
        return this.getWorkHrs() < 40 ? this.getWorkHrs() * this.rate
                : this.regularHrs * this.rate + this.overtimeRate * overtimeHrs;
    }
}
