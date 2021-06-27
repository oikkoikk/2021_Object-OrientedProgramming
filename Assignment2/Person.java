package Assignment2;

public class Person {
    private String name;
    private int age;
    private int height;
    private int weight;

    public Person(String name, int age, int height, int weight) {
        this.name = new String(name);
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public Person(Person otherPerson) {
        this.name = new String(otherPerson.name);
        this.age = otherPerson.age;
        this.height = otherPerson.height;
        this.weight = otherPerson.weight;
    }

    public String toString() {
        return this.name + ", " + this.age + ", " + this.height + ", " + this.weight;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public String getName() {
        return new String(name);
    }

    public int getWeight() {
        return weight;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
