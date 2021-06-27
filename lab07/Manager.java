package lab07;

public class Manager extends Employee {
    private int officeNum;
    private String team;

    public Manager(String name, int employeeNum, int officeNum, String team) {
        super(name, employeeNum, "Management");
        this.officeNum = officeNum;
        this.team = team;
    }

    public String toString() {
        return super.toString() + "\nOffice# : " + officeNum + "\nTeam : " + team;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        } else {
            Manager man = (Manager) obj;
            return super.equals(man)
                    && man.officeNum == this.officeNum && man.team.equals(this.team);
        }
    }

}
