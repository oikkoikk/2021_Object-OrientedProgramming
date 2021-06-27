package lab05.kr.co.lab05.manager;

import java.time.LocalDate;

import lab05.kr.co.lab05.employee.Employee;
import java.util.Random;

public class EmployeeManager {
    public static void main(String[] args) {
        Employee JongJun = new Employee("Lee", 4500);
        Random rnd = new Random();
        LocalDate contractDate = LocalDate.of(2021, 04, 01);
        LocalDate nowDate = LocalDate.of(2021, 04, 01);

        // 1~12사이의 랜덤한 int
        int bonusMonth = rnd.nextInt(12) + 1;

        System.out.println("계약일 : " + contractDate);
        System.out.println(JongJun);

        while (JongJun.getBalance() < 20000) {
            if (nowDate.getMonthValue() == bonusMonth) {
                JongJun.receiveSalary();
                System.out.println("" + (nowDate.getYear() - contractDate.getYear() + 1) + "년차 "
                        + nowDate.getMonthValue() + "월에 인센티브를 받았습니다.");
            }
            // 근무한지 12개월이 지날때마다
            if (nowDate.getYear() != contractDate.getYear()
                    && nowDate.getMonthValue() == contractDate.getMonthValue()) {
                int increasingRate = rnd.nextInt(11);

                JongJun.increaseYearlySalary(increasingRate);
                System.out.println(
                        (nowDate.getYear() - contractDate.getYear() + 1) + "년차 연봉이 " + increasingRate + "% 인상되었습니다.");
                bonusMonth = rnd.nextInt(12) + 1;
            }

            // 매달 월급을 받음
            JongJun.receiveSalary();
            // 월 ++
            nowDate = nowDate.plusMonths(1);
        }
        System.out.println("날짜 : " + nowDate);
        System.out.println(JongJun);
    }
}
