package lab11;

public class Engineer extends Employee {
    public static int nextEngineerNumber = 2000;

    public Engineer(String name) {
        super(name, nextEngineerNumber++, "Engineer", 3300);
    }
}
