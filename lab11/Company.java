package lab11;

import java.util.ArrayList;
import java.util.Scanner;

public class Company {
    public static <T> void printArrayList(ArrayList<T> tList) {
        for (T temp : tList) {
            System.out.println(temp);
        }
    }

    public static void main(String[] args) {
        String[] managerNameList = { "Sally", "Tammy" };
        String[] engineerNameList = { "Jenny", "Mason" };

        ArrayList<Employee> employeeList = new ArrayList<Employee>();

        for (String s : managerNameList) {
            employeeList.add(new Manager(s));
        }
        for (String s : engineerNameList) {
            employeeList.add(new Engineer(s));
        }

        printArrayList(employeeList);

        System.out.println("-----------------------------------------");
        System.out.println("All employees' salaries were raised by 4%");
        Management.raiseAllSalary(employeeList, 1.04);

        printArrayList(employeeList);

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of employee to raise salary by 20% additionally: ");
        int empNum = scan.nextInt();

        int index = Management.findIndexByEmpNum(employeeList, empNum);
        if (index != -1) {
            Management.raiseSalary(employeeList.get(index), 1.20);
            System.out.println(employeeList.get(index).getName() + "'s salary is raised.\n");
        } else {
            System.out.println("No one gets chance of raising salary.\n");
        }
        System.out.print("Enter the number of employee to move department to Personnel: ");
        empNum = scan.nextInt();

        index = Management.findIndexByEmpNum(employeeList, empNum);
        if (index != -1) {
            Management.moveDepartment(employeeList.get(index), "Personnel");
            System.out.println(employeeList.get(index).getName() + " moves department\n");
        } else {
            System.out.println("No one moves to Personnel");
        }
        printArrayList(employeeList);
    }
}
