package lab02;

import java.util.Scanner;

public class Lab02_2 {
    public static String makeOrdinalNumber(int n) {
        String ordinal;
        if (n % 10 == 1 && n % 100 != 11)
            ordinal = "st";
        else if (n % 10 == 2 && n % 100 != 12)
            ordinal = "nd";
        else if (n % 10 == 3 && n % 100 != 13)
            ordinal = "rd";
        else
            ordinal = "th";
        return (n + ordinal);
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        String[] input = keyboard.nextLine().split(" ");
        double sum = 0;
        int index = 0;
        for (String student : input) {
            index++;
            if (student.toUpperCase().compareTo("A") == 0) {
                sum += 100;
                System.out.println(makeOrdinalNumber(index) + " student's score is " + 100);
            } else if (student.toUpperCase().compareTo("B") == 0) {
                sum += 90;
                System.out.println(makeOrdinalNumber(index) + " student's score is " + 90);
            } else if (student.toUpperCase().compareTo("C") == 0) {
                sum += 80;
                System.out.println(makeOrdinalNumber(index) + " student's score is " + 80);
            } else if (student.toUpperCase().compareTo("D") == 0) {
                sum += 70;
                System.out.println(makeOrdinalNumber(index) + " student's score is " + 70);
            } else {
                sum += 0;
                System.out.println(makeOrdinalNumber(index) + " student's score is " + 0);
            }
        }
        String fixedNum = String.format("%.2f", (sum / input.length));
        System.out.println("This class's average = " + fixedNum);

    }

}
