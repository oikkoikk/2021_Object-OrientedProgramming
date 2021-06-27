package Assignment1;

import java.util.Scanner;

public class TravelScheduler {

    public static void selectSchedule(Activity[] activityList, Schedule[] scheduleList) {
        Scanner keyboard = new Scanner(System.in);

        printScheduleList(scheduleList);
        System.out.print("Select a schedule: ");
        int selectedSchedule = keyboard.nextInt();

        if (selectedSchedule == 0 || scheduleList[selectedSchedule - 1] == null) {
            // NOTE: 0을 누르거나, empty 누르면 이전 메뉴로 이동
            return;
        }
        while (true) {
            System.out.println("1) Add activity");
            System.out.println("2) Remove activity");
            System.out.println("3) Print schedule");
            System.out.print("Select menu: ");
            int secondMenu = keyboard.nextInt();
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

    }

    public static void editSchedule(Activity[] activityList, Schedule[] scheduleList) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("1) Make a new schedule");
        System.out.println("2) Copy an existing schedule");
        System.out.print("Select menu: ");
        int secondMenu = keyboard.nextInt();
        if (secondMenu == 0) {
            return;
        }
        if (secondMenu == 1) {
            if (Schedule.scheduleNum == 5) {
                // 스케줄 리스트가 꽉차면 더 이상 추가 불가!
                System.out.println("ScheduleList is full");
                return;
            }
            System.out.print("Enter a name for the schedule: ");
            keyboard.nextLine(); // 버퍼 비우기
            String name = keyboard.nextLine();
            System.out.print("Enter travel days: ");
            int days = keyboard.nextInt();
            scheduleList[Schedule.scheduleNum] = new Schedule(name, days);
        } else if (secondMenu == 2) {
            if (Schedule.scheduleNum == 5) {
                // 스케줄 리스트가 꽉차면 더 이상 추가 불가!
                System.out.println("ScheduleList is full");
                return;
            }
            // 스케쥴 보여주기
            printScheduleList(scheduleList);
            System.out.print("Select the schedule to copy: ");
            int selectedSchedule = keyboard.nextInt();
            if (selectedSchedule == 0 || scheduleList[selectedSchedule - 1] == null) {
                // NOTE: 0을 누르거나, empty 누르면 처음으로 이동
                return;
            }
            System.out.print("Enter a new schedule name: ");
            keyboard.nextLine(); // 버퍼 비우기
            String name = keyboard.nextLine();
            scheduleList[Schedule.scheduleNum] = new Schedule(scheduleList[selectedSchedule - 1], name);

        }
    }

    public static int printMainMenu() {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("1) Select schedule");
        System.out.println("2) Edit schedule");
        System.out.println("3) End Program");
        System.out.print("Select menu: ");
        int firstMenu = keyboard.nextInt();

        return firstMenu;
    }

    public static void printActivity(Activity[] activityList) {
        for (int i = 0; i < activityList.length; i++) {
            System.out.println((i + 1) + ") " + activityList[i]);
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

        System.out.print("Select activity to do: ");
        int selectedActivity = keyboard.nextInt();
        if (selectedActivity == 0) {
            // 0을 누르면 뒤로가기
            return;
        }
        System.out.print("Enter the day to do activity: ");
        int day = keyboard.nextInt();
        System.out.print("Enter the time to do activity(9~20): ");
        int time = keyboard.nextInt();
        selectedSchedule.addActivity(activityList[selectedActivity - 1], day, time);
    }

    public static void removeActivity(Schedule selectedSchedule, Activity[] activityList) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the day to remove activity: ");
        int day = keyboard.nextInt();
        System.out.print("Enter the time to remove activity: ");
        int time = keyboard.nextInt();
        selectedSchedule.removeActivity(day, time);

    }

    public static void main(String[] args) {
        Schedule[] scheduleList = new Schedule[5];
        Activity[] activityList = new Activity[8];

        activityList[0] = new Activity("Hiking", "Mountain", 0);
        activityList[1] = new Activity("Horse Riding", "Hill", 3000);
        activityList[2] = new Activity("Visiting Museum", "Museum", 8000);
        activityList[3] = new Activity("Watching movie", "Theater", 11000);
        activityList[4] = new Activity("Fishing", "Sea", 15000);
        activityList[5] = new Activity("Surffing", "Beach", 20000);
        activityList[6] = new Activity("Camping", "Field", 30000);
        activityList[7] = new Activity("Paragliding", "Mountain", 50000);

        Scanner keyboard = new Scanner(System.in);
        while (true) {
            int firstMenu = printMainMenu();

            if (firstMenu == 1) {
                selectSchedule(activityList, scheduleList);
            } else if (firstMenu == 2) {
                editSchedule(activityList, scheduleList);
            } else if (firstMenu == 3) {
                break;
            }
        }
    }
}
