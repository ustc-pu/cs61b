public class TestAnimals {
    public static void main(String[] args){
        Animal a = new Animal("Pluto", 10);
        Cat c = new Cat("Garfield", 6);
        Dog d = new Dog("Fibo", 4);
//        d.playFetch();
        a.greet();
        c.greet();
        d.greet();
        a = new Dog("Spot", 10);
        a.greet();


//        System.out.println();
//        a.playFetch();
    }

}
