package Assignment2;

public class Schedule {
    private String name; // Schedule 이름
    private int days; // Schedule 전체 일 수
    private Activity[][] plan; // Schedule 일정 [time][day](time : 9~20)
    private int expense; // Schedule 전체 비용
    private Person[] member; // Schedule에 참여하는 멤버

    public static int scheduleNum; // 생성된 Schedule 객체의 수

    public Schedule(String name, int days, Person[] member) {
        this.name = new String(name);
        this.days = days;
        this.plan = new Activity[12][days];
        this.expense = 0;
        this.member = new Person[member.length];
        for (int i = 0; i < member.length; i++) {
            this.member[i] = new Person(member[i]);
        }
        scheduleNum++;
    }

    public Schedule(Schedule otherSchedule, String name) {
        this.name = new String(name);
        this.days = otherSchedule.getDays();
        this.expense = otherSchedule.getExpense();
        Activity[][] tempAct = new Activity[12][otherSchedule.getDays()];
        Person[] tempMem = new Person[otherSchedule.getMember().length];

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < otherSchedule.getDays(); j++) {
                if (otherSchedule.getPlan()[i][j] == null) {
                    tempAct[i][j] = null;
                } else if (otherSchedule.getPlan()[i][j].getClass() == ExtremeActivity.class) {
                    tempAct[i][j] = new ExtremeActivity((ExtremeActivity) otherSchedule.getPlan()[i][j]);
                } else if (otherSchedule.getPlan()[i][j].getClass() == ShowActivity.class) {
                    tempAct[i][j] = new ShowActivity((ShowActivity) otherSchedule.getPlan()[i][j]);
                } else {
                    tempAct[i][j] = new Activity(otherSchedule.getPlan()[i][j]);
                }
            }
        }
        this.plan = tempAct;
        for (int i = 0; i < otherSchedule.getMember().length; i++) {
            if (otherSchedule.getMember()[i] == null) {
                tempMem[i] = null;
            } else {
                tempMem[i] = new Person(otherSchedule.getMember()[i]);
            }
        }
        this.member = tempMem;

        scheduleNum++;
    }

    public void addActivity(Activity activity, int day, int time)
            throws InvalidAccessException, InsufficientConditionException {
        // 해당 일정에 activity 추가
        // 해당 시간에 이미 activity가 있는지?
        if (day < 1 || day > this.days || time < 9 || time > 20 || this.plan[time - 9][day - 1] != null) {
            throw new InvalidAccessException();
        }

        // 이미 있는 activity인지?
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < this.days; j++) {
                if (activity.equals(this.plan[i][j])) {
                    throw new InvalidAccessException();
                }
            }
        }

        if (activity.getClass() == ExtremeActivity.class) {
            // extreme activity이면
            ExtremeActivity tempAct = (ExtremeActivity) activity;
            for (int i = 0; i < this.member.length; i++) {
                if (this.member[i].getHeight() < tempAct.getMinHeight()
                        || this.member[i].getWeight() < tempAct.getMinWeight()) {
                    throw new InsufficientConditionException();
                }
            }
            this.plan[time - 9][day - 1] = new ExtremeActivity(tempAct);
        } else if (activity.getClass() == ShowActivity.class) {
            // show activity이면
            ShowActivity tempAct = (ShowActivity) activity;
            for (int i = 0; i < this.member.length; i++) {
                if (this.member[i].getAge() < tempAct.getMinAge()) {
                    throw new InsufficientConditionException();
                }
            }
            this.plan[time - 9][day - 1] = new ShowActivity(tempAct);
        } else {
            // 일반 activity이면
            this.plan[time - 9][day - 1] = new Activity(activity);
        }
        for (int i = 0; i < this.member.length; i++) {
            this.expense += activity.getActualPrice(this.member[i]);
        }

    }

    public void removeActivity(int day, int time) throws InvalidAccessException {
        if (day < 1 || day > this.days || time < 9 || time > 20 || this.plan[time - 9][day - 1] == null) {
            throw new InvalidAccessException();
        } else {
            for (int i = 0; i < this.member.length; i++) {
                this.expense -= this.plan[time - 9][day - 1].getActualPrice(this.member[i]);
            }
            this.plan[time - 9][day - 1] = null;
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

    public Person[] getMember() {
        return member;
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

    public void setMember(Person[] member) {
        this.member = member;
    }

}
