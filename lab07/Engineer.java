package lab07;

public class Engineer extends Employee {
    private String workZone;
    private String project;

    public Engineer(String name, int employeeNum, String workZone, String project) {
        super(name, employeeNum, "Engineering");
        this.workZone = workZone;
        this.project = project;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        } else {
            Engineer eng = (Engineer) obj;
            return super.equals(eng)
                    && eng.workZone.equals(this.workZone) && eng.project.equals(this.project);
        }
    }

    public String toString() {
        return super.toString() + "\nZone : " + this.workZone;
    }
}
