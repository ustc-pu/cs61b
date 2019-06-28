public class Cat extends Animal {

    public void Cat(String name, int age) {
        super(name, age);
        this.noise = "Meow!";
    }

    @Override
    public void greet() {
        System.out.println("Cat" + name + "says: " + this.makeNoise());
    }

}
