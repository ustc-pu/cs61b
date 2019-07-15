public class testCat {
    public static void main(String[] args) {
        Animal a1 = new Animal("BoBo", 5);
        a1.greet();

        Object a2 = new Cat("Pinky", 2);
//        a2.greet();

        Animal a3 = ((Animal) a2);
        a3.greet();
    }
}
