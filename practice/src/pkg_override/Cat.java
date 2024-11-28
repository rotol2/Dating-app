package pkg_override;

public class Cat extends Animal{
    private int chur;
    
    public Cat() {
        super();
    }
    
    public Cat(String name, int chur) {
        super(name);
        this.chur = chur;
    }
    
    @Override
    public void eat() {
    	System.out.println(super.name+"가 츄르를 "+this.chur+"개 먹습니다.");
    } 
    
    
}