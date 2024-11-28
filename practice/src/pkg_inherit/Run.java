package pkg_inherit;

public class Run {
    public static void main(String[] args) {
        // Dog
        Dog dog = new Dog();
        // Dog
        dog.bark();
        // Animal
        dog.eat();
        // Animal
        dog.walk();
    }
}