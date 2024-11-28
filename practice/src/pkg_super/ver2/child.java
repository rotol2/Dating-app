package pkg_super.ver2;

public class child extends parent{
	
    public int a = 2;
    
    public child() {}
    
    public void childMethod(int b) {
        System.out.println("b : "+b);
        System.out.println("this.a : "+this.a);
        System.out.println("super.a : "+super.a);
    } 
}