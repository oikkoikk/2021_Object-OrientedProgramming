package Assignment1;

public class Schedule {
    private String name; // Schedule 이름
    private int days; // Schedule 전체 일 수
    private Activity[][] plan; // Schedule 일정 [time][day](time : 9~20)
    private int expense; // Schedule 전체 비용

    public static int scheduleNum; // 생성된 Schedule 객체의 수

    public Schedule(String name, int days) {
        this.name = new String(name);
        this.days = days;
        this.plan = new Activity[12][days];
        this.expense = 0;
        scheduleNum++;
    }

    public Schedule(Schedule otherSchedule, String name) {
        this.name = new String(name);
        this.days = otherSchedule.getDays();
        Activity[][] temp = new Activity[12][otherSchedule.getDays()];
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < otherSchedule.getDays(); j++) {
                if (otherSchedule.getPlan()[i][j] == null) {
                    temp[i][j] = null;
                } else {
                    temp[i][j] = new Activity(otherSchedule.getPlan()[i][j]);
                }
            }
        }
        this.plan = temp;
        this.expense = otherSchedule.getExpense();
        scheduleNum++;
    }

    public void addActivity(Activity activity, int day, int time) {
        // 해당 일정에 activity 추가
        // 해당 시간에 이미 activity가 있는지?
        if (day < 1 || day > this.days || time < 9 || time > 20 || this.plan[time - 9][day - 1] != null) {
            System.out.println("Fail to add activity");
            return;
        }

        // 이미 있는 activity인지?
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < this.days; j++) {
                if (activity.equals(this.plan[i][j])) {
                    System.out.println("Fail to add activity");
                    return;
                }
            }
        }
        this.plan[time - 9][day - 1] = new Activity(activity);
        this.expense += activity.getPrice();
    }

    public void removeActivity(int day, int time) {
        if (day < 1 || day > this.days || time < 9 || time > 20 || this.plan[time - 9][day - 1] == null) {
            System.out.println("Fail to remove activity");
            return;
        } else {
            Activity delActivity = new Activity(this.plan[time - 9][day - 1]);

            this.plan[time - 9][day - 1] = null;
            this.expense -= delActivity.getPrice();
            System.out.println("Removed Successfully");
        }
    }

    public String getName() {
        return new String(name);
    }

    public int getDays() {
        return days;
    }

    public int getExpense() {
        return expense;
    }

    public Activity[][] getPlan() {
        return plan;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public void setPlan(Activity[][] plan) {
        this.plan = plan;
    }

    public void setExpense(int expense) {
        this.expense = expense;
    }

}
