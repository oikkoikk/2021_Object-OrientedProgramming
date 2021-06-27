package lab09;

import java.util.Scanner;

public class ExceptionDemo {
    public static void main(String[] args) {
        Employee emp = new Employee("lee");
        Scanner keyboard = new Scanner(System.in);

        while (true) {
            try {
                System.out.println(emp.getWorkDay() + "일차 근무 시간을 입력하세요.");
                int workHours = keyboard.nextInt();

                if (workHours < 0) {
                    throw new NegativeException();
                } else if (workHours == 0) {
                    throw new Exception("Program Exit");
                } else if (workHours > 24) {
                    throw new TooMuchStuffException(workHours);
                } else {
                    emp.addWorkHours(workHours);
                    emp.addWorkDay();
                    System.out.println("이름 : " + emp.getName());
                    System.out.println("누적 근무 시간 : " + emp.getWorkHours());
                    System.out.println("No Exception has been occurred");
                }
            } catch (NegativeException e) {
                // NOTE: handle exception
                System.out.println(e.getMessage());
            } catch (TooMuchStuffException e) {
                System.out.println(e.getInputNum() + ", " + e.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.exit(0);
            } finally {
                System.out.println("End of try-catch statement");
            }
        }
    }
}
