package Assignment1;

public class Activity {
    private String name;
    private String location;
    private int price; // 시간 당 가격

    public Activity(String name, String location, int price) {
        this.name = new String(name);
        this.location = new String(location);
        this.price = price;
    }

    public Activity(Activity otheraActivity) {
        this.name = otheraActivity.getName();
        this.location = otheraActivity.getLocation();
        this.price = otheraActivity.getPrice();
    }

    public String getName() {
        return new String(name);
    }

    public String getLocation() {
        return new String(location);
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String toString() {
        return this.name + "(" + this.location + ", " + this.price + " won)";
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Activity newAct = (Activity) obj;

        return newAct.getName().equals(this.name) && newAct.getLocation().equals(this.location)
                && newAct.getPrice() == this.price;
    }
}