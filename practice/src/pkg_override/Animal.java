package pkg_override;

public class Animal {
    protected String name;
    
    public Animal() {}
    
    public Animal(String name) {
        this.name = name;
    }
    
	public void eat() {
	System.out.println("동물이 먹습니다.");
	} 

}
