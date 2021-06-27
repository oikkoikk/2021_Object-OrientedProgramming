package lab04;

import java.util.Random;

public class City {
    private String name;
    private int locationX;
    private int locationY;

    public City(String name, int locationX, int locationY) {
        this.name = name;
        this.locationX = locationX;
        this.locationY = locationY;
    }

    public City(String name) {
        Random rnd = new Random();

        this.name = name;
        this.locationX = rnd.nextInt(361);
        this.locationY = rnd.nextInt(361);
    }

    public static double distance(City cityOne, City cityTwo) {
        return (Math.sqrt(Math.pow(cityOne.locationX - cityTwo.locationX, 2)
                + Math.pow((cityOne.locationY - cityTwo.locationY), 2)));
    }

    public boolean equals(City city) {
        if (city.name == this.name && city.locationX == this.locationX && city.locationY == this.locationY) {
            return true;
        }
        return false;
    }

    public String toString() {
        return (name + ", " + locationX + ", " + locationY);
    }

    public String getName() {
        return name;
    }

    public int getLocationX() {
        return locationX;
    }

    public int getLocationY() {
        return locationY;
    }
}
