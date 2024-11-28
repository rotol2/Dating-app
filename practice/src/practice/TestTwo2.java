package practice;

public class TestTwo2 {
	public static void main(String[] args) {
		Practice p = new Practice();
// callAnimal Dog, Cat
// 
		p.callAnimal(new Dog1());
		p.callAnimal(new Cat1());
	}
}

class Practice {
	public void callAnimal(Animal1 animal) {
		System.out.println("=== callAnimal ===");
		animal.sound();
		((Dog1) animal).wagTail();
	}
}

