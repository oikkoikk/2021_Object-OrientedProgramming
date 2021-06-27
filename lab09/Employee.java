package lab09;

public class Employee {
    private String name;
    private int workDay;
    private int workHours;

    public Employee(String name) {
        this.name = new String(name);
        this.workDay = 1;
        this.workHours = 0;
    }

    public void addWorkDay() {
        this.workDay += 1;
    }

    public void addWorkHours(int hours) {
        this.workHours += hours;
    }

    public String getName() {
        return new String(name);
    }

    public int getWorkDay() {
        return workDay;
    }

    public int getWorkHours() {
        return workHours;
    }
}
