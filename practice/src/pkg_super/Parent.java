package pkg_super;


public class Parent {
	
    private int a;
    
    public Parent() {
        System.out.println("부모 기본 생성자: "+a);
    }
    public Parent(int a) {
        System.out.println("부모 매개변수 생성자: "+a);
    } 
    
}