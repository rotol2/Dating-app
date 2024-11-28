package pkg_casting;

public class RunTwo {
    public static void main(String[] args) {
      
        Animal[] animals = new Animal[3];
        
        animals[0] = new Animal();
        animals[1] = new Dog();    
        animals[2] = new Cat();   
        
        for(int i = 0 ; i < animals.length ; i++) {
        	System.out.print(i+" : ");
        	animals[i].sound();
        }
        
        
    }
}
