package practice;

abstract class Animal {
   // makeSound
   public abstract void makeSound();
}

class Cat extends Animal {
   // makeSound
   @Override
   public void makeSound() {
      System.out.println(" ~");
   }
}

// Dog Animal
class Dog extends Animal {
   // makeSound
   @Override
   public void makeSound() {
      System.out.println(" !");
   }
}

public class Test3 {
   public static void main(String[] args) {

      Animal dog = new Dog();
      Animal cat = new Cat();

      dog.makeSound(); // !
      cat.makeSound(); // ~
   }
}
