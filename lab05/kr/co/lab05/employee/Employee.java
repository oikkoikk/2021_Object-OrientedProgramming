package lab05.kr.co.lab05.employee;

public class Employee {
    private String name;
    private double yearlySalary;
    private double monthlySalary;
    private double balance;

    public Employee(String name, double yearlySalary) {
        this.name = name;
        this.yearlySalary = yearlySalary;
        this.monthlySalary = yearlySalary / 12.0;
        this.balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    public void increaseYearlySalary(int byPercent) {
        this.yearlySalary += this.yearlySalary * (byPercent / 100.0);
        this.monthlySalary = this.yearlySalary / 12.0;
    }

    public void receiveSalary() {
        this.balance += this.monthlySalary;
    }

    public String toString() {
        return "이름 : " + this.name + " 연봉 : " + this.yearlySalary + " 월급 : " + this.monthlySalary + " 재산 : "
                + this.balance;
    }
}
