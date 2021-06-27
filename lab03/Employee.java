package lab03;

import java.util.Scanner;

public class Employee {

    private String name;
    private int age;
    private String position;
    private int salary;
    private int vacationDays;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
        this.position = "Employee";
        this.salary = 5000;
        this.vacationDays = 20;
    }

    public Employee(String name, int age, String position, int salary) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.salary = salary;
        this.vacationDays = 20;
    }

    public Employee(String name, int age, String position, int salary, int vacationDays) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.salary = salary;
        this.vacationDays = vacationDays;
    }

    public boolean equals(Employee another) {
        if (this.name.equals(another.name) && this.position.equals(another.position) && this.age == another.age) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "Name: " + this.name + ", Age: " + this.age + ", Position: " + this.position + ", Salary: " + this.salary
                + ", VacationDays: " + this.vacationDays;
    }

    public void vacation() {
        Scanner keyboard = new Scanner(System.in);
        int days = Integer.valueOf(keyboard.next());

        if (this.vacationDays < days) {
            System.out.println("남은 휴가 일수가 부족합니다.");
            return;
        }
        this.vacationDays -= days;
        System.out.println("휴가를 사용하였습니다. 남은 휴가 일수: " + vacationDays);

        return;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getVacationDays() {
        return vacationDays;
    }

    public void setVacationDays(int vacationDays) {
        this.vacationDays = vacationDays;
    }
}
