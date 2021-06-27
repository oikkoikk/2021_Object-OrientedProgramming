package lab11;

import java.util.ArrayList;

public class Management {
    public static <T extends Employee> void moveDepartment(T t, String department) {
        t.setDepartment(department);
    }

    public static <T extends Employee> void raiseSalary(T t, double rate) {
        t.setSalary(t.getSalary() * rate);
    }

    public static <T extends Employee> int findIndexByEmpNum(ArrayList<T> tList, int employeeNum) {
        int index = -1;

        for (int i = 0; i < tList.size(); i++) {
            if (tList.get(i).getEmployeeNum() == employeeNum) {
                index = i;
            }
        }

        return index;
    }

    public static <T extends Employee> void raiseAllSalary(ArrayList<T> tList, double rate) {
        for (int i = 0; i < tList.size(); i++) {
            tList.get(i).setSalary(tList.get(i).getSalary() * rate);
        }
    }
}
