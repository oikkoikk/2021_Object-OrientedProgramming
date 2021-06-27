package lab02;

import java.util.Scanner;

public class Lab02_1 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String[] name;
        String fullName;
        String homework;
        String[] input;

        input = keyboard.nextLine().split(",");
        name = input[0].split(" ");
        name[0] = name[0].toUpperCase().charAt(0) + name[0].substring(1);
        homework = input[1].trim();
        homework = homework.toUpperCase().charAt(0) + homework.substring(1);

        System.out.println("Name Length(Korean) : " + name.length);
        System.out.println(name[2].toUpperCase().charAt(0) + "." + name[1].toUpperCase().charAt(0) + "." + name[0]
                + " submitted " + homework);
    }
}
