package Assignment2;

public class ShowActivity extends Activity {
    private int minAge;
    // 최소 나이 미만인 경우 참여 불가

    public ShowActivity(String name, String location, int price, int minAge) {
        super(name, location, price);
        this.minAge = minAge;
    }

    public ShowActivity(ShowActivity otherShowActivity) {
        super(otherShowActivity.getName(), otherShowActivity.getLocation(), otherShowActivity.getPrice());
        this.minAge = otherShowActivity.minAge;
    }

    public int getActualPrice(Person person) {
        // Activity에 참여하는 사람에 따라 할인/할증된 가격을 return
        // ShowActivity class는 19세 이하는 20% 할인된 price return
        // 나머지는 price return
        return person.getAge() <= 19 ? (int) (this.getPrice() * 0.8) : this.getPrice();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ShowActivity newAct = (ShowActivity) obj;

        return newAct.getName().equals(this.getName()) && newAct.getLocation().equals(this.getLocation())
                && newAct.getPrice() == this.getPrice() && newAct.minAge == this.minAge;
    }

    @Override
    public String toString() {
        return super.toString().substring(0, super.toString().length() - 1) + ", minAge: " + minAge + ")";
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }
}
