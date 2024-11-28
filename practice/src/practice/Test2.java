package practice;

public class Test2 {
	public static void main(String[] args) {
		Parent p1 = new Parent();
		Parent p2 = new Parent(23);
		p1.method1();
		Child c1 = new Child();
		Child c2 = new Child(48);
	}
}

class Parent {
	private int a;
	public int c;

	public Parent() {

		System.out.println("   : " + a);
	}

	public Parent(int a) {
		System.out.println("   : " + a);
	}
	
	public void method1() {
		System.out.println("   : " + a);
	}
	
	
}

class Child extends Parent {
	private int b;

	public Child() {
		super(7);
		System.out.println("   : " + b);
	}

	public Child(int b) {
		super(5);
		super.method1();
		super.c = 3;
		System.out.println("   : " + b);
	}
	
	
	public void method1() {
		System.out.println("   : " + b);
	}
}