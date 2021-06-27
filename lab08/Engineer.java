package lab08;

public class Engineer extends Employee {
    private double rate;

    public Engineer(String name, int employeeNum) {
        super(name, employeeNum);
        this.rate = 4.0;
        this.setDepartment("Engineering");
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (getClass() != obj.getClass()) {
            return false;
        } else {
            Engineer eng = (Engineer) obj;
            return super.equals(eng);
        }
    }

    public String toString() {
        return super.toString() + ", " + this.getDepartment();
    }

    public double getPaid() {
        return this.getWorkHrs() * this.rate;
    }
}
