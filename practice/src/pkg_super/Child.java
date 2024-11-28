package pkg_super;

public class Child extends Parent{
	
    private int b;
    
    public Child() {
    	super(7);
        System.out.println("자식 기본 생성자: "+b);
    }
    public Child(int b) {
//    	super();
        System.out.println("자식 매개변수 생성자: "+b);
    }
    
}