package Assignment2;

public class ExtremeActivity extends Activity {
    private int minHeight;
    private int minWeight;

    // 최소 신장 미만 또는 최소 몸무게 미만 -> 참여 불가
    // 최소 신장, 최소 몸무게 중 하나라도 만족하지 못하면 참여 불가
    public ExtremeActivity(String name, String location, int price, int minHeight, int minWeight) {
        super(name, location, price);
        this.minHeight = minHeight;
        this.minWeight = minWeight;
    }

    public ExtremeActivity(ExtremeActivity otherExtremeActivity) {
        super(otherExtremeActivity.getName(), otherExtremeActivity.getLocation(), otherExtremeActivity.getPrice());
        this.minHeight = otherExtremeActivity.minHeight;
        this.minWeight = otherExtremeActivity.minWeight;
    }

    public int getActualPrice(Person person) {
        // Activity에 참여하는 사람에 따라 할인/할증된 가격을 return
        // ***ExtremeActivity class는 60세 이상은 30% 할증된 price return***
        return person.getAge() >= 60 ? (int) (this.getPrice() * 1.3) : this.getPrice();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ExtremeActivity newAct = (ExtremeActivity) obj;

        return newAct.getName().equals(this.getName()) && newAct.getLocation().equals(this.getLocation())
                && newAct.getPrice() == this.getPrice() && newAct.minHeight == this.minHeight
                && newAct.minWeight == this.minWeight;
    }

    @Override
    public String toString() {
        return super.toString().substring(0, super.toString().length() - 1) + ", minHeight: " + minHeight
                + ", minWeight: " + minWeight + ")";
    }

    public int getMinHeight() {
        return minHeight;
    }

    public int getMinWeight() {
        return minWeight;
    }

    public void setMinHeight(int minHeight) {
        this.minHeight = minHeight;
    }

    public void setMinWeight(int minWeight) {
        this.minWeight = minWeight;
    }
}
