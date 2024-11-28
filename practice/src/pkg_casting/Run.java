package pkg_casting;

public class Run {
	public static void main(String[] args) {
	
		// 업캐스팅
		Animal animal = new Dog();		
		animal.sound();
		// 자식이 부모로 업캐스팅 => 부모가 자식 메소드 사용(x)
		// animal.wagTail();
		
		// 다운캐스팅
		Dog dog = (Dog)animal;
		dog.wagTail();
	
		
	}
}