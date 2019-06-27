public class Cat extends Animal {

    protected String name, noise;
    protected int age;

    public void Cat(String name, int age) {
        this.name = name;
        this.age = age;
        this.noise = "Meow!";
    }

    @Override
    public void greet() {
        System.out.println("Cat" + name + "says: " + this.makeNoise());
    }

    public static void main(String[] args) {
        Animal c1 = new Cat("d", 7);
        c1.name = "Dora";
        c1.age = 6;
        c1.greet();
    }
}
