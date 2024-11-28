package pkg_casting;

public class Practice {
	
    public void callAnimal(Animal animal) {
        animal.sound();
        
        if(animal instanceof Dog) {
            ((Dog) animal).wagTail();
        } else if(animal instanceof Cat){
        	((Cat)animal).eatChur();
        }
        
        
    }
    
}
