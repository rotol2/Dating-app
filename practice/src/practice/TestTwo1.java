package practice;

public class TestTwo1 {

	public static void main(String[] args) {

//		Animal animal = new Dog();
		Animal1 animal = new Animal1();
		Dog1 dog = (Dog1) animal;
		dog.sound(); // :
	}

}

class Animal1 {
	public String name;
	
	public Animal1() {}
	
	public Animal1(String name) {
		this.name = name;
	}
	
	public void eat() {
		System.out.println(" .");
	}

	public void walk() {
		System.out.println(" .");
	}

	public void sound() {
		System.out.println(" .");
	}
}

class Dog1 extends Animal1 {
	public void bark() {
		System.out.println(" .");
	}

	@Override
	public void sound() {
		System.out.println("멍멍");
	}

	public void wagTail() {
		System.out.println("꼬리를 흔듭니다.");
	}

}

class Cat1 extends Animal1 {
	public void meow() {
		System.out.println(" .");
	}

	@Override
	public void sound() {
		System.out.println("야옹");
	}

	public void eatChur() {
		System.out.println("츄르를 먹습니다.");
	}
}