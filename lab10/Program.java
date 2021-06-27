package lab10;

public class Program {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Tiger tiger = new Tiger();
        Turtle turtle = new Turtle();
        Animal[] animals = { dog, tiger, turtle };

        Person person = new Person() {
            private int hp = 100;

            @Override
            public void control(Animal animal) {
                if (animal.getClass() == Tiger.class) {
                    this.hp -= 80;
                } else if (animal.getClass() == Dog.class) {
                    this.hp -= 10;
                }
                System.out.println("You have overpowered the " + animal.getClass().getSimpleName());
            }

            @Override
            public void showinfo() {
                System.out.println("Person HP: " + hp);
            }
        };

        showResult(animals, person);

    }

    private static void showResult(Animal[] animals, Person p) {
        for (int i = 0; i < animals.length; i++) {
            System.out.println("Animal" + i + 1 + ":" + animals[i].getName());
            if (animals[i] instanceof Barkable) {
                Barkable temp = (Barkable) animals[i];
                System.out.println("Animal" + i + 1 + " barked " + temp.bark());
            }
            p.control(animals[i]);
            p.showinfo();
        }
    }
}
