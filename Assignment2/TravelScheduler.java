package Assignment2;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.FileInputStream;

public class TravelScheduler {

    public static void selectSchedule(Activity[] activityList, Schedule[] scheduleList) {
        Scanner keyboard = new Scanner(System.in);

        printScheduleList(scheduleList);
        int selectedSchedule;
        while (true) {
            try {
                System.out.print("Select a schedule: ");
                selectedSchedule = keyboard.nextInt();
                if (0 > selectedSchedule || selectedSchedule > 5) {
                    throw new InvalidAccessException();
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("input mismatch");
                keyboard.nextLine(); // 버퍼 비우기
            } catch (InvalidAccessException e) {
                System.out.println(e.getMessage());
            }
        }

        if (selectedSchedule == 0 || scheduleList[selectedSchedule - 1] == null) {
            // NOTE: 0을 누르거나, empty 누르면 이전 메뉴로 이동
            return;
        }
        while (true) {
            int secondMenu;

            while (true) {
                try {
                    System.out.println("1) Add activity");
                    System.out.println("2) Remove activity");
                    System.out.println("3) Print schedule");
                    System.out.print("Select menu: ");
                    secondMenu = keyboard.nextInt();
                    if (0 > secondMenu || secondMenu > 3) {
                        throw new InvalidAccessException();
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("input mismatch");
                    keyboard.nextLine(); // 버퍼 비우기
                } catch (InvalidAccessException e) {
                    System.out.println(e.getMessage());
                }
            }
            if (secondMenu == 0) {
                // NOTE: 0을 누르면 처음으로 이동
                return;
            } else if (secondMenu == 1) {
                printActivity(activityList);
                addActivity(scheduleList[selectedSchedule - 1], activityList);
            } else if (secondMenu == 2) {
                printSchedule(scheduleList[selectedSchedule - 1]);
                removeActivity(scheduleList[selectedSchedule - 1], activityList);
            } else if (secondMenu == 3) {
                printSchedule(scheduleList[selectedSchedule - 1]);
            }
        }
    }

    public static void printSchedule(Schedule selecteSchedule) {
        System.out.println("-".repeat((selecteSchedule.getDays() + 1) * 16));
        for (int time = -1; time < 12; time++) {
            if (time == -1) {
                System.out.printf("%-16s", " ");
                for (int day = 0; day < selecteSchedule.getDays(); day++) {
                    System.out.printf("%-16s", "Day " + (day + 1));
                }
                System.out.println();
            } else {
                System.out.printf("%-16s", (time + 9) + ":00");
                for (int day = 0; day < selecteSchedule.getDays(); day++) {
                    if (selecteSchedule.getPlan()[time][day] == null) {
                        System.out.printf("%-16s", "----");
                    } else {
                        System.out.printf("%-16s", selecteSchedule.getPlan()[time][day].getName());
                    }
                }
                System.out.println();
            }
        }
        System.out.println("-".repeat((selecteSchedule.getDays() + 1) * 16));
        System.out.println("Total expenses: " + selecteSchedule.getExpense() + " won");
        System.out.println("-".repeat((selecteSchedule.getDays() + 1) * 16));
        for (int i = 0; i < selecteSchedule.getMember().length; i++) {
            System.out.println(selecteSchedule.getMember()[i]);
        }
        System.out.println("-".repeat((selecteSchedule.getDays() + 1) * 16));

    }

    public static void editSchedule(Activity[] activityList, Person[] memberList, Schedule[] scheduleList) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("1) Make a new schedule");
        System.out.println("2) Copy an existing schedule");
        System.out.print("Select menu: ");
        int secondMenu;
        while (true) {
            try {
                if (Schedule.scheduleNum == 5) {
                    // 스케줄 리스트가 꽉차면 더 이상 추가 불가!
                    throw new ArrayFullException();
                }
                secondMenu = keyboard.nextInt();
                if (0 > secondMenu || secondMenu > 2) {
                    throw new InvalidAccessException();
                }
                break;

            } catch (ArrayFullException e) {
                System.out.println(e.getMessage());
                return;
            } catch (InputMismatchException e) {
                System.out.println("input mismatch");
                System.out.print("Select menu: ");
                keyboard.nextLine(); // 버퍼 비우기
            } catch (InvalidAccessException e) {
                System.out.println(e.getMessage());
                System.out.print("Select menu: ");
            }
        }
        if (secondMenu == 0) {
            return; // 0을 입력하면 뒤로가기
        }
        if (secondMenu == 1) {
            String name;
            int days;
            while (true) {
                try {
                    keyboard.nextLine(); // 버퍼 비우기
                    System.out.print("Enter a name for the schedule: ");
                    name = keyboard.nextLine();
                    System.out.print("Enter travel days: ");
                    days = keyboard.nextInt();
                    if (days < 1) {
                        throw new InvalidAccessException();
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("input mismatch");
                } catch (InvalidAccessException e) {
                    System.out.println(e.getMessage());
                }
            }
            printMember(memberList);
            String[] memberInput;
            keyboard.nextLine(); // 버퍼 비우기
            while (true) {
                try {
                    System.out.println("Select member: ");
                    // NOTE: 멤버는 여러명이 들어올 수 있다. ex) 1, 3, 4
                    memberInput = keyboard.nextLine().split(", ");
                    for (int i = 0; i < memberInput.length; i++) {
                        if (1 > Integer.parseInt(memberInput[i])
                                || Integer.parseInt(memberInput[i]) > memberList.length) {
                            throw new InvalidAccessException();
                        }
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("input mismatch");
                } catch (InvalidAccessException e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    System.out.println("input mismatch");
                }
            }
            Person[] member = new Person[memberInput.length];
            for (int i = 0; i < memberInput.length; i++) {
                member[i] = new Person(memberList[Integer.parseInt(memberInput[i]) - 1]);
            }
            scheduleList[Schedule.scheduleNum] = new Schedule(name, days, member);
        } else if (secondMenu == 2) {
            // 스케쥴 보여주기
            printScheduleList(scheduleList);
            int selectedSchedule;
            String name;

            while (true) {
                try {
                    System.out.print("Select the schedule to copy: ");
                    selectedSchedule = keyboard.nextInt();
                    if (selectedSchedule == 0) { // 비어있는 상태에서 copy 메뉴 들어오면 빠져나갈 수 없으므로 추가...!
                        return;
                    } else if (1 > selectedSchedule || selectedSchedule > Schedule.scheduleNum) {
                        throw new InvalidAccessException();
                    }

                    System.out.print("Enter a new schedule name: ");
                    keyboard.nextLine(); // 버퍼 비우기
                    name = keyboard.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("input mismatch");
                    keyboard.nextLine(); // 버퍼 비우기
                } catch (InvalidAccessException e) {
                    System.out.println(e.getMessage());
                }
            }
            scheduleList[Schedule.scheduleNum] = new Schedule(scheduleList[selectedSchedule - 1], name);

        }
    }

    public static int printMainMenu() throws InputMismatchException, InvalidAccessException {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("1) Select schedule");
        System.out.println("2) Edit schedule");
        System.out.println("3) End Program");
        System.out.print("Select menu: ");
        int firstMenu = keyboard.nextInt();
        if (1 > firstMenu || firstMenu > 3) {
            throw new InvalidAccessException();
        }

        return firstMenu;
    }

    public static void printActivity(Activity[] activityList) {
        for (int i = 0; i < activityList.length; i++) {
            System.out.println((i + 1) + ") " + activityList[i]);
        }
    }

    public static void printMember(Person[] memberList) {
        for (int i = 0; i < memberList.length; i++) {
            System.out.println((i + 1) + ") " + memberList[i]);
        }
    }

    public static void printScheduleList(Schedule[] scheduleList) {
        // 스케쥴 보여주기
        for (int i = 0; i < scheduleList.length; i++) {
            if (scheduleList[i] != null) {
                System.out.println((i + 1) + ") " + scheduleList[i].getName());
            } else {
                System.out.println((i + 1) + ") " + "EMPTY SCHEDULE");
            }
        }
    }

    public static void addActivity(Schedule selectedSchedule, Activity[] activityList) {
        Scanner keyboard = new Scanner(System.in);
        while (true) {
            try {

                System.out.print("Select activity to do: ");
                int selectedActivity = keyboard.nextInt();
                if (1 > selectedActivity || selectedActivity > activityList.length) {
                    throw new InvalidAccessException();
                }
                System.out.print("Enter the day to do activity: ");
                int day = keyboard.nextInt();
                System.out.print("Enter the time to do activity(9~20): ");
                int time = keyboard.nextInt();

                selectedSchedule.addActivity(activityList[selectedActivity - 1], day, time);
                break;
            } catch (InvalidAccessException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("input mismatch");
                keyboard.nextLine(); // 버퍼 비우기
            } catch (InsufficientConditionException e) {
                System.out.println(e.getMessage());
                System.out.println("Fail to add activity");
            }
        }
    }

    public static void removeActivity(Schedule selectedSchedule, Activity[] activityList) {
        Scanner keyboard = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Enter the day to remove activity: ");
                int day = keyboard.nextInt();
                System.out.print("Enter the time to remove activity: ");
                int time = keyboard.nextInt();
                selectedSchedule.removeActivity(day, time);
                break;
            } catch (InvalidAccessException e) {
                System.out.println(e.getMessage());
                System.out.println("Fail to remove activity");
            } catch (InputMismatchException e) {
                System.out.println("input mismatch");
                keyboard.nextLine(); // 버퍼 비우기
            }
        }

    }

    public static void main(String[] args) {
        Scanner ActivityInput = null;
        Scanner MemberInput = null;
        int lenActList, lenMemList;
        Schedule[] scheduleList = new Schedule[5];
        Activity[] activityList = new Activity[1];
        Person[] memberList = new Person[1];

        try {
            ActivityInput = new Scanner(new FileInputStream("./ActivityList.txt"));
            MemberInput = new Scanner(new FileInputStream("./MemberList.txt"));
            lenActList = ActivityInput.nextInt();
            lenMemList = MemberInput.nextInt();
            activityList = new Activity[lenActList];
            memberList = new Person[lenMemList];

            ActivityInput.nextLine(); // 버퍼 비우기
            MemberInput.nextLine();

            for (int i = 0; i < lenActList; i++) {
                String temp[] = ActivityInput.nextLine().split(", ");
                if (temp[0].equals("Activity")) {
                    activityList[i] = new Activity(temp[1], temp[2], Integer.parseInt(temp[3]));
                } else if (temp[0].equals("Show")) {
                    activityList[i] = new ShowActivity(temp[1], temp[2], Integer.parseInt(temp[3]),
                            Integer.parseInt(temp[4]));
                } else if (temp[0].equals("Extreme")) {
                    activityList[i] = new ExtremeActivity(temp[1], temp[2], Integer.parseInt(temp[3]),
                            Integer.parseInt(temp[4]), Integer.parseInt(temp[5]));
                }
            }
            for (int i = 0; i < lenMemList; i++) {
                String temp[] = MemberInput.nextLine().split(", ");
                memberList[i] = new Person(temp[0], Integer.parseInt(temp[1]), Integer.parseInt(temp[2]),
                        Integer.parseInt(temp[3]));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(0); // 파일 입출력에서 예외 생기면 그냥 프로그램 종료!
        }

        while (true) {
            int firstMenu;

            while (true) {
                try {
                    firstMenu = printMainMenu();
                    break;
                } catch (InputMismatchException e) {
                    // int가 아닌 입력이 들어올 경우
                    System.out.println("input mismatch");
                } catch (InvalidAccessException e) {
                    // 1,2,3이 아닌 숫자가 들어올 경우
                    System.out.println(e.getMessage());
                }
            }

            if (firstMenu == 1) {
                selectSchedule(activityList, scheduleList);
            } else if (firstMenu == 2) {
                editSchedule(activityList, memberList, scheduleList);
            } else if (firstMenu == 3) {
                break;
            }
        }
    }
}
