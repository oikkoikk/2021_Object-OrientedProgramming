package lab04;

public class CityTest {
    public static void main(String[] args) {
        City Seoul = new City("Seoul", 23, 45);
        City Paris = new City("Paris", 123, 41);
        City Racoon = new City("Racoon City");
        City Mega = new City("Mega City");

        System.out.println(Seoul);
        System.out.println(Paris);
        System.out.println(Racoon);
        System.out.println(Mega);
        System.out.println("Seoul-Paris: " + City.distance(Seoul, Paris));
        System.out.println("Seoul-Racoon City: " + City.distance(Seoul, Racoon));
        System.out.println("Paris-Mega City: " + City.distance(Paris, Mega));
    }
}
