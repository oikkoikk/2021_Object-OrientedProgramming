package lab11;

public class Manager extends Employee {
    public static int nextManagerNumber = 1000;
    
    public Manager(String name)
    {
        super(name, nextManagerNumber++, "Manager", 3000);
    }
}
